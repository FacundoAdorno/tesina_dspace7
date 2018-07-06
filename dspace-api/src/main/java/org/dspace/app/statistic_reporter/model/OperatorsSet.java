/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.model;

import java.util.ArrayList;

public class OperatorsSet {
	private String id;
	
	private ArrayList<Operator> operators;

	public OperatorsSet(String id) {
		this.operators = new ArrayList<Operator>();
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public ArrayList<Operator> getOperators() {
		return operators;
	}

	public void setOperators(ArrayList<Operator> operators) {
		this.operators = operators;
	}
}
