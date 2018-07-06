/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistics.model;

public class ConditionRequest {
	private String mtd_id;
	private String op_id;
	private String value;
	
	
	public String getMtd_id() {
		return mtd_id;
	}
	public void setMtd_id(String mtd_id) {
		this.mtd_id = mtd_id;
	}
	public String getOp_id() {
		return op_id;
	}
	public void setOp_id(String op_id) {
		this.op_id = op_id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
