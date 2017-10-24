package org.dspace.app.statistic_reporter.service;

import org.dspace.app.statistic_reporter.model.Reporter;

public class StatisticReporterServiceImpl implements StatisticReporterService {

	@Override
	public Reporter buildStatisticReporter() {
		return new Reporter();

	}

}
