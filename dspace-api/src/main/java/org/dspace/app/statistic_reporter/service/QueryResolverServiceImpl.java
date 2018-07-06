/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.service;

import java.util.Iterator;

import org.apache.commons.validator.routines.UrlValidator;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.dspace.app.statistic_reporter.model.ConditionInstance;
import org.dspace.app.statistic_reporter.model.Operator;
import org.dspace.app.statistic_reporter.model.ReporterInstance;
import org.dspace.app.statistic_reporter.model.ReporterResult;
import org.dspace.services.factory.DSpaceServicesFactory;


public class QueryResolverServiceImpl implements QueryResolverService {

	private static final Logger log = Logger.getLogger(QueryResolverServiceImpl.class);
	
	
	HttpSolrServer getSolrServer(String coreName) {
		HttpSolrServer solrServer = null;
		
		String solrCoreUrl = DSpaceServicesFactory.getInstance().getConfigurationService().getProperty("solr.server") + "/" + coreName;

        UrlValidator urlValidator = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);
        
        if(urlValidator.isValid(solrCoreUrl)) {
            log.debug("Solr URL: " + solrCoreUrl);
            solrServer = new HttpSolrServer(solrCoreUrl);

            solrServer.setBaseURL(solrCoreUrl);
            solrServer.setUseMultiPartPost(true);

        } else {
            log.error("Error while initializing solr, invalid url: " + solrCoreUrl);
        }
        return solrServer;
	}
	
	//TODO tiene que devolver un JSON supuestamente...
	@Override
	public ReporterResult resolveFromReporterToJSON(ReporterInstance reporterInstance) {
		HttpSolrServer solr = this.getSolrServer("search");
		
		SolrQuery query = new SolrQuery();
		
		query.setFilterQueries(reporterInstance.getPrimaryScope().getScope().getSolrQueryString());
		
		//TODO tengo que ver el tema de la unión de condiciones...
		String DEFAULT_LOGICAL_OP = " AND ";
		StringBuilder queryString = new StringBuilder();
		if(reporterInstance.getPrimaryScope().getConditions().isEmpty()) {
			queryString.append("*:*");
		} else {
			Iterator<ConditionInstance> conditions = reporterInstance.getPrimaryScope().getConditions().iterator();
			ConditionInstance condition;
			while(conditions.hasNext()) {
				condition = conditions.next();
				String queryPrefix = condition.getMetadata();
				String querySuffix = condition.getOperator().getSolrQuery().replaceAll(Operator.PLACEHOLDER, condition.getValue());
				queryString.append(queryPrefix);
				queryString.append(":");
				queryString.append(querySuffix);
				if(conditions.hasNext()) {
					queryString.append(DEFAULT_LOGICAL_OP);
				}
			}
		}
		query.setQuery(queryString.toString());
		
		ReporterResult result = null;
		try {
			QueryResponse queryResponse = solr.query(query);
			//TODO tengo que mejorar esta respuesta...
			Iterator<SolrDocument> results = queryResponse.getResults().iterator();
			StringBuilder response = new StringBuilder();
			while(results.hasNext()) {
				response.append(results.next().toString());
			}
			result = new ReporterResult(response.toString());
		} catch (SolrServerException e) {
			// TODO Resolver esto de una mejor forma, subir la excepeción enmascarandola en otra mas general y modificar la interface...
			e.printStackTrace();
		}
		
		return result;
	}

}
