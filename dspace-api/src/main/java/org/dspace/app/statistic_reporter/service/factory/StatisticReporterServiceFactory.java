/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.service.factory;

import org.dspace.app.statistic_reporter.service.ConfigurationLoaderService;
import org.dspace.app.statistic_reporter.service.StatisticReporterService;
import org.dspace.services.factory.DSpaceServicesFactory;

public abstract class StatisticReporterServiceFactory {

	public abstract StatisticReporterService getStatisticReporterService();
	
	public abstract ConfigurationLoaderService getStatisticConfigurationService();

    public static StatisticReporterServiceFactory getInstance()
    {
        return DSpaceServicesFactory.getInstance().getServiceManager().getServiceByName("statisticReporterServiceFactory", StatisticReporterServiceFactory.class);
    }
	
}
