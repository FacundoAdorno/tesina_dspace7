/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.model;

import java.util.ArrayList;

public class MetadataSet {
	private String id;
	
	private ArrayList<String> metadata_def;
	
	private String operators_ref;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<String> getMetadata_def() {
		return metadata_def;
	}

	public void setMetadata_def(ArrayList<String> metadata_ref) {
		this.metadata_def = metadata_ref;
	}

	public String getOperators_ref() {
		return operators_ref;
	}

	public void setOperators_ref(String operators_ref) {
		this.operators_ref = operators_ref;
	}
}
