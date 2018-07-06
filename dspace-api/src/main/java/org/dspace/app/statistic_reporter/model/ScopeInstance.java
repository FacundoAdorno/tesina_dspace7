/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.model;

import java.util.ArrayList;

public class ScopeInstance {

	private ScopeDefinition scope;
	
	private ArrayList<ConditionInstance> conditions;
	
	public ScopeInstance() {
		this.conditions = new ArrayList<ConditionInstance>();
	}

	public ScopeDefinition getScope() {
		return scope;
	}

	public void setScope(ScopeDefinition scope) {
		this.scope = scope;
	}

	public ArrayList<ConditionInstance> getConditions() {
		return conditions;
	}

	public void setConditions(ArrayList<ConditionInstance> conditions) {
		this.conditions = conditions;
	}
	
}
