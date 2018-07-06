/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.model;

import java.util.HashMap;
import org.dspace.app.statistic_reporter.model.ScopeDefinition;
import org.dspace.app.statistic_reporter.model.OperatorsSet;
import org.dspace.app.statistic_reporter.model.MetadataSet;

public abstract class Configuration {

	HashMap<String,ScopeDefinition> scopes;
	
	HashMap<String,OperatorsSet> operatorsSet;
	
	HashMap<String,MetadataSet> metadataSet;
	
	public abstract ScopeDefinition addScope(String id);
	
	public HashMap<String,ScopeDefinition> getScopes(){
		return scopes;
	}
	
	public abstract OperatorsSet addOperatorSet(String id);	
	
	public HashMap<String,OperatorsSet> getOperatorsSet(){
		return operatorsSet;
	}

	public abstract MetadataSet addMetadataSet(String id);	
	
	public HashMap<String,MetadataSet> getMetadataSet(){
		return metadataSet;
	}
	
	public Configuration() {
		this.scopes = new HashMap<String,ScopeDefinition>();
		this.operatorsSet = new HashMap<String,OperatorsSet>();
		this.metadataSet = new HashMap<String,MetadataSet>();
	}
	
}
