/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.model;

import org.dspace.app.statistic_reporter.model.ScopeDefinition;

import java.util.ArrayList;
import java.util.HashMap;

import org.dspace.app.statistic_reporter.model.ConditionInstance;
import org.dspace.app.statistic_reporter.model.ObservableAspectInstance;

public class ReporterMetaDefinition {

	private HashMap<String,ScopeDefinition> scopes;
	
	private ArrayList<OperatorsSet> operatorsSet;
	
	private ArrayList<MetadataSet> metadataSet;
		
	
	public HashMap<String, ScopeDefinition> getScopes() {
		return scopes;
	}

	public void setScopes(HashMap<String, ScopeDefinition> scopes) {
		this.scopes = scopes;
	}

	public ArrayList<OperatorsSet> getOperatorsSet() {
		return operatorsSet;
	}

	public void setOperatorsSet(ArrayList<OperatorsSet> operatorsSet) {
		this.operatorsSet = operatorsSet;
	}

	public ArrayList<MetadataSet> getMetadataSet() {
		return metadataSet;
	}

	public void setMetadataSet(ArrayList<MetadataSet> metadataSet) {
		this.metadataSet = metadataSet;
	}
	
}