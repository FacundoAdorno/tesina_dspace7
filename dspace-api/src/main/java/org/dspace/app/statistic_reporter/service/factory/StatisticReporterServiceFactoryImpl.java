package org.dspace.app.statistic_reporter.service.factory;

import org.dspace.app.statistic_reporter.service.StatisticReporterService;
import org.springframework.beans.factory.annotation.Autowired;

public class StatisticReporterServiceFactoryImpl extends StatisticReporterServiceFactory {

	@Autowired(required = true)
	private StatisticReporterService statisticReporterService;
	
	@Override
	public StatisticReporterService getStatisticReporterService() {
		return statisticReporterService;
	}

}
