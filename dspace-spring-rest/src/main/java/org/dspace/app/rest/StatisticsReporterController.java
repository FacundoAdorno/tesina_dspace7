/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest;

import org.dspace.app.rest.model.hateoas.statistics.ReporterMetaResource;
import org.dspace.app.statistic_reporter.model.ReporterInstance;
import org.dspace.app.statistic_reporter.model.ReporterResult;
import org.dspace.app.statistic_reporter.service.StatisticReporterService;
import org.dspace.app.statistic_reporter.service.factory.StatisticReporterServiceFactory;
import org.dspace.app.statistics.model.ReporterConverter;
import org.dspace.app.statistics.model.ReporterInstanceRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Collection;


@RestController
@RequestMapping("/statistics/reporter")
public class StatisticsReporterController {
	
	StatisticReporterService statisticReporterService = StatisticReporterServiceFactory.getInstance().getStatisticReporterService();
	
	@RequestMapping(method = RequestMethod.GET)
	ReporterMetaResource getReporterBuilder() {
		ReporterMetaResource reporter = new ReporterMetaResource(statisticReporterService.buildStatisticReporter());
		
		reporter.add(linkTo(methodOn(this.getClass()).getReporterBuilderOnCommunity()).withRel("community"));
		reporter.add(linkTo(methodOn(this.getClass()).getReporterBuilderOnCommunities()).withRel("communities"));
		
		return reporter;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	ReporterInstanceRequest getReporterBuilderAndInstantiate(@RequestBody ReporterInstanceRequest reporterInstanceReq) {
		ReporterInstance reporterInstance = ReporterConverter.toModel(statisticReporterService, reporterInstanceReq);
		ReporterResult result = statisticReporterService.getReporterResult(reporterInstance);
		//TODO se tiene que mejorar la respuesta...
		reporterInstanceReq.setResult(result.getResult());
		return reporterInstanceReq;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/community")
	ReporterMetaResource getReporterBuilderOnCommunity() {
		ReporterMetaResource reporter = new ReporterMetaResource(statisticReporterService.buildStatisticReporter());
		return reporter;
	}
	
	
	@RequestMapping("/community_collection_test")
	Collection<ReporterMetaResource> getReporterBuilderOnCommunities() {
		ReporterMetaResource reporter1 = new ReporterMetaResource(statisticReporterService.buildStatisticReporter());
		ReporterMetaResource reporter2 = new ReporterMetaResource(statisticReporterService.buildStatisticReporter());
		ArrayList<ReporterMetaResource> array = new ArrayList<ReporterMetaResource>();
		array.add(reporter1); array.add(reporter2);
		return array;
	}
}
