package org.dspace.app.rest.model.hateoas.statistics;

import org.dspace.app.statistic_reporter.model.Reporter;
import org.springframework.hateoas.ResourceSupport;

public class ReporterResource extends ResourceSupport {
	
	private Reporter reporter;
	
	public ReporterResource(Reporter reporter) {
		this.reporter = new Reporter();
	}
	
	public Reporter getReporter() {
		return this.reporter;
	}
	
//	private String name = "Hello";
	
	
//	public String getName() {
//		return this.name;
//	}
}
