package org.dspace.app.statistic_reporter.service.factory;

import org.dspace.app.statistic_reporter.service.StatisticReporterService;
import org.dspace.services.factory.DSpaceServicesFactory;

public abstract class StatisticReporterServiceFactory {

	public abstract StatisticReporterService getStatisticReporterService();

    public static StatisticReporterServiceFactory getInstance()
    {
        return DSpaceServicesFactory.getInstance().getServiceManager().getServiceByName("statisticReporterServiceFactory", StatisticReporterServiceFactory.class);
    }
	
}
