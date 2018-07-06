/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest.model.hateoas.statistics;

import org.dspace.app.statistic_reporter.model.ReporterInstance;
import org.dspace.app.statistic_reporter.model.ReporterMetaDefinition;
import org.dspace.app.statistics.model.ReporterInstanceRequest;
import org.springframework.hateoas.ResourceSupport;

public class ReporterMetaResource extends ResourceSupport {
	
	private ReporterMetaDefinition reporter;
	
	public ReporterMetaResource(ReporterMetaDefinition reporter) {
		this.reporter = reporter;
	}
	
	public ReporterMetaDefinition getReporter() {
		return this.reporter;
	}

}
