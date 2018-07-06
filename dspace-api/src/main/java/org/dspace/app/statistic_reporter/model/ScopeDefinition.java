/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.model;

public class ScopeDefinition {

	private String id;
	
	private String label;
	
	/**
	 * Es el valor del queryParameter de este elemento. Retorna especificamente los elementos vinculados a un contexto
	 */
	private String solrQueryString;
	
	/**
	 * Para saber qué parámetro de Solr debe utilizarse para aplicar la condición. Por ejemplo, el parámetro podria ser "fq" o "q"... 
	 */
	private String solrQueryParameter;
	
	/**
	 * Nombre del core Solr sobre el que se va a resolver este contexto
	 */
	private String solrCoreName;

	
	public ScopeDefinition(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSolrQueryString() {
		return solrQueryString;
	}

	public void setSolrQueryString(String solrQueryString) {
		this.solrQueryString = solrQueryString;
	}

	public String getSolrQueryParameter() {
		return solrQueryParameter;
	}

	public void setSolrQueryParameter(String solrQueryParameter) {
		this.solrQueryParameter = solrQueryParameter;
	}

	public String getSolrCoreName() {
		return solrCoreName;
	}

	public void setSolrCoreName(String solrCoreName) {
		this.solrCoreName = solrCoreName;
	}
	
	
}
