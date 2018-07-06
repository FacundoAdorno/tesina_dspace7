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
import org.springframework.beans.factory.annotation.Autowired;

public class StatisticReporterServiceFactoryImpl extends StatisticReporterServiceFactory {

	@Autowired(required = true)
	private StatisticReporterService statisticReporterService;
	
	@Autowired(required = true)
	private ConfigurationLoaderService statisticConfigurationService;
	
	@Override
	public StatisticReporterService getStatisticReporterService() {
		return statisticReporterService;
	}

	@Override
	public ConfigurationLoaderService getStatisticConfigurationService() {
		return statisticConfigurationService;
	}

}
