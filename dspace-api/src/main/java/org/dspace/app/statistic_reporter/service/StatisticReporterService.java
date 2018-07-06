/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.service;

import org.dspace.app.statistic_reporter.model.ReporterInstance;
import org.dspace.app.statistic_reporter.model.ReporterMetaDefinition;
import org.dspace.app.statistic_reporter.model.ReporterResult;

public interface StatisticReporterService {
	
	/**
	 * Retorna la definición de un StatristicReporter.
	 */
	public ReporterMetaDefinition buildStatisticReporter();
	
	public ConfigurationLoaderService getConfigurationService();

	//TODO cambiar el tipo de resultado a algun objeto distinto
	public ReporterResult getReporterResult(ReporterInstance reporterInst);
}
