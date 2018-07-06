/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.service;

import java.util.ArrayList;

import org.dspace.app.statistic_reporter.model.DefaultConfiguration;
import org.dspace.app.statistic_reporter.model.OperatorsSet;
import org.dspace.app.statistic_reporter.model.ReporterInstance;
import org.dspace.app.statistic_reporter.model.ReporterMetaDefinition;
import org.dspace.app.statistic_reporter.model.ReporterResult;
import org.springframework.beans.factory.annotation.Autowired;

public class StatisticReporterServiceImpl implements StatisticReporterService {

	@Autowired(required=true)
	ConfigurationLoaderService statisticConfigurationService;
	
	@Autowired(required=true)
	QueryResolverService queryResolverService;
	
	@Override
	public ReporterMetaDefinition buildStatisticReporter() {
		ReporterMetaDefinition reporter = new ReporterMetaDefinition();
		DefaultConfiguration config = (DefaultConfiguration) statisticConfigurationService.loadConfiguration();
		
		reporter.setScopes(config.getScopes());
		reporter.setOperatorsSet(new ArrayList<OperatorsSet>(config.getOperatorsSet().values()));
		
		return reporter;

	}
	
	public ConfigurationLoaderService getConfigurationService() {
		//TODO hasta el momento hago esto para que se parseen las configuraciones...
		statisticConfigurationService.loadConfiguration();
		return statisticConfigurationService;
	}

	@Override
	public ReporterResult getReporterResult(ReporterInstance reporterInst) {
		return queryResolverService.resolveFromReporterToJSON(reporterInst);
	}
	
}
