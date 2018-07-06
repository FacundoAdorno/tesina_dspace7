/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistics.model;

import java.util.ArrayList;

public class ScopeRequest {
	
	private String id;
	
	private ArrayList<ConditionRequest> conditions;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public ArrayList<ConditionRequest> getConditions() {
		return conditions;
	}

	public void setConditions(ArrayList<ConditionRequest> conditions) {
		this.conditions = conditions;
	}

}
