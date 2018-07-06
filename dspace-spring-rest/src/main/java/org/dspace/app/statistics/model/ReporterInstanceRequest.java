/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistics.model;

public class ReporterInstanceRequest {
	private ScopeRequest primaryScope;
	
	private String result;
	

	public ScopeRequest getPrimaryScope() {
		return primaryScope;
	}

	public void setPrimaryScope(ScopeRequest primaryScope) {
		this.primaryScope = primaryScope;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
