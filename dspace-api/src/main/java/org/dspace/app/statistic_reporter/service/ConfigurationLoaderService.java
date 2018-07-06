/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.service;

import org.dspace.app.statistic_reporter.model.Configuration;
import org.dspace.app.statistic_reporter.model.MetadataSet;
import org.dspace.app.statistic_reporter.model.Operator;
import org.dspace.app.statistic_reporter.model.OperatorsSet;
import org.dspace.app.statistic_reporter.model.ScopeDefinition;

public interface ConfigurationLoaderService {

	
	public Configuration loadConfiguration();
	
	public ScopeDefinition getScopeById(String id);
	
	public Operator getOperatorById(String id);
	
	public OperatorsSet getOperatorsSetById(String id);
	
	public MetadataSet getMetadataSetById(String id);
	
}
