package org.dspace.app.statistic_reporter.service;

import org.dspace.app.statistic_reporter.model.Reporter;

public interface StatisticReporterService {
	
	/**
	 * Retorna la definición de un StatristicReporter.
	 */
	public Reporter buildStatisticReporter();

}
