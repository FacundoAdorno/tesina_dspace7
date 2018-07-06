/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.model;

public class Operator {
	public static String PLACEHOLDER = "<placeholder>";
	
	private String id;
	
	private String label;
	
	private String symbol;
	
	private String solrQuery;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSolrQuery() {
		return solrQuery;
	}

	public void setSolrQuery(String solrQuery) {
		this.solrQuery = solrQuery;
	}
}
