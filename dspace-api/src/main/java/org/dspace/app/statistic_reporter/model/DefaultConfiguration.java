/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.model;

import java.util.Iterator;

import org.dspace.app.statistic_reporter.model.ScopeDefinition;

public class DefaultConfiguration extends Configuration{
	
	public static enum DefaultConfigProperties{
		SCOPE_ROOT("scope", "scope"), 
		SCOPE_OPTIONS("options", SCOPE_ROOT.appendPath("options")), SCOPE_BODY_LABEL("label", SCOPE_OPTIONS.appendPath("label")),
		SCOPE_BODY_ID("id", SCOPE_OPTIONS.appendPath("id")), SCOPE_BODY_SOLRQUERY("solrQuery", SCOPE_OPTIONS.appendPath("solrQuery")),
		SCOPE_BODY_MTD_SETS("metadataSets_ref", SCOPE_OPTIONS.appendPath("metadataSets_ref")),
		SCOPE_BODY_SOLRCORE("solrCore", SCOPE_OPTIONS.appendPath("solrCore")),
		METADATA_ROOT("metadataSets", "metadataSets"),
		OPERATORS_TAG_NAME("operatorsSets", "operatorsSets");
		
		private String PATH_DELIMITER;
		private String propertyName;
		private String propertyPath;
		
		DefaultConfigProperties(String propertyName, String propertyPath){
			this.propertyName = propertyName;
			this.propertyPath = propertyPath;
			this.PATH_DELIMITER = "::";
		}
		
		public String text() {
			return this.propertyName;
		}
		
		public String path() {
			return this.propertyPath;
		}
		
		public String[] tokenizePath() {
			return this.propertyPath.split(this.PATH_DELIMITER);
		}
		
		public String changeDelimiter(String newDelimiter) {
			StringBuilder pathWithChangedDelimiter = new StringBuilder();
			String[] tokenizedPath = this.tokenizePath();
			for (int i = 0; i < tokenizedPath.length; i++) {
				pathWithChangedDelimiter.append(tokenizedPath[i]);
				if(i < (this.tokenizePath().length - 1)) {
					pathWithChangedDelimiter.append(newDelimiter);
				}
			}
			return pathWithChangedDelimiter.toString();
		}
		
		private String appendPath(String... pathComponents ) {
			String path = this.path();
			for (String component : pathComponents) {
				path = path + this.PATH_DELIMITER + component;
			}
			return path;
		}
	}
	

	@Override
	public ScopeDefinition addScope(String id) {
		// TODO CHEQUEAR que el scope a agregar no exista...
		ScopeDefinition scope = new ScopeDefinition(id);
		this.scopes.put(id, scope);
		return scope;
	}


	@Override
	public OperatorsSet addOperatorSet(String id) {
		// TODO CHEQUEAR que el operatorSet a agregar no exista...
		OperatorsSet opSet = new OperatorsSet(id);
		this.operatorsSet.put(id,opSet);
		return opSet;
	}


	@Override
	public MetadataSet addMetadataSet(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	public ScopeDefinition findScope(String id) {
		return this.scopes.get(id);
	}
	
	public OperatorsSet findOperatorsSet(String id) {
		return this.operatorsSet.get(id);
	}
	
	public Operator findOperator(String id) {
		Iterator<String> opsSetKeys = this.operatorsSet.keySet().iterator();
		while(opsSetKeys.hasNext()) {
			OperatorsSet opSet = this.operatorsSet.get(opsSetKeys.next());
			for (Operator operator : opSet.getOperators()) {
				if(operator.getId().equals(id)) {
					return operator;
				}
			}
		}
		return null;
	}
	
	public MetadataSet findMetadataSet(String id) {
		return this.metadataSet.get(id);
	}

}
