/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.dspace.app.statistic_reporter.model.ScopeDefinition;
import org.dspace.app.statistic_reporter.model.DefaultConfiguration;
import org.dspace.app.statistic_reporter.model.MetadataSet;
import org.dspace.app.statistic_reporter.model.Operator;
import org.dspace.app.statistic_reporter.model.OperatorsSet;
import org.dspace.app.statistic_reporter.model.DefaultConfiguration.DefaultConfigProperties;
import org.dspace.services.factory.DSpaceServicesFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.jsonldjava.core.JsonLdTripleCallback;
import com.jayway.jsonpath.DocumentContext;

import org.dspace.app.statistic_reporter.utils.JsonUtils;


public class DefaultConfigurationLoaderServiceImpl implements ConfigurationLoaderService {

	private DefaultConfiguration configuration;
	
	static String STATISTICS_REPORTER_CONFIG_FILENAME = "statistics-reporter.json";
	
	static String configurationFilePath = DSpaceServicesFactory.getInstance().getConfigurationService().getProperty("dspace.dir") 
			+ File.separator + "config" + File.separator + "modules" + File.separator + STATISTICS_REPORTER_CONFIG_FILENAME;
	
	@Override
	public DefaultConfiguration loadConfiguration() {
		if(configuration == null) {
			loadDefaultConfiguration();
		}

		return configuration;
	}

	private void loadDefaultConfiguration() {
		createMockupConfig();
//		try {
//			
//			this.configuration = new DefaultConfiguration();
//		
//			DocumentContext configFile = JsonUtils.parseJsonFile(configurationFilePath);
//			
//			
//			//TODO cargar todas las configuraciones, por ahora levanto solo los Contextos para probar...
//			this.extractContextOptions(configFile);
//		
//		} catch (JsonProcessingException e) {
//			// TODO Manejar la execpción correctamente
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Manejar la execpción correctamente
//			e.printStackTrace();
//		}
		
		
		
	}

	private void createMockupConfig() {
		this.configuration = new DefaultConfiguration();

		//TODO por defecto el core asociado a esta configuración es el search, despues tengo que reestructurar el json de configuración
		ScopeDefinition scope;
		scope = this.configuration.addScope("bitstr_scp");
		scope.setLabel("Bitstream");
		scope.setSolrQueryString("search.resourcetype:0");
		
		scope = this.configuration.addScope("comm_scp");
		scope.setLabel("Community");
		scope.setSolrQueryString("search.resourcetype:4");
		
		ArrayList<Operator> operators = new ArrayList<Operator>();
		Operator op = new Operator();
		op.setId("eq_op");
		op.setLabel("equal");
		op.setSolrQuery("<placeholder>");
		op.setSymbol("=");
		operators.add(op);
		
		OperatorsSet operatorsSet = this.configuration.addOperatorSet("defaultOperators");
		operatorsSet.setOperators(operators);
		
	}

	private void extractContextOptions(DocumentContext configFile) {
		DocumentContext contextOptions = JsonUtils.find(configFile, "$." + DefaultConfigProperties.SCOPE_OPTIONS.changeDelimiter("."));
		int countOfContextOptions = contextOptions.read("$.length()");
		if( countOfContextOptions == 0) {
			//TODO lanzar excepción cuando no hay opciones de contexto...
		}
		for (int i = 0; i < countOfContextOptions; i++) {
			DocumentContext option = JsonUtils.find(contextOptions, "$.[" + i + "]");
			//TODO por ahora presupongo que todos los id's existen
			ScopeDefinition ctx = this.configuration.addScope(option.read("$." + DefaultConfigProperties.SCOPE_BODY_ID.text()));
			HashMap<String, String> optionProperties = JsonUtils.getProperties(contextOptions);
			ctx.setLabel(optionProperties.get(DefaultConfigProperties.SCOPE_BODY_LABEL.text()));
			ctx.setSolrQueryParameter(DefaultConfigProperties.SCOPE_BODY_SOLRQUERY.text());
		}
	}
	
	
	public ScopeDefinition getScopeById(String id) {
		return this.configuration.findScope(id);
	}
	
	public Operator getOperatorById(String id) {
		return this.configuration.findOperator(id);
	}
	
	public OperatorsSet getOperatorsSetById(String id) {
		return this.configuration.findOperatorsSet(id);
	}
	
	public MetadataSet getMetadataSetById(String id) {
		return this.configuration.findMetadataSet(id);
	}

}
