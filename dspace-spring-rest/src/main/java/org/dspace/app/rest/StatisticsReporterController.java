package org.dspace.app.rest;

import org.dspace.app.rest.model.hateoas.statistics.ReporterResource;
import org.dspace.app.statistic_reporter.service.StatisticReporterService;
import org.dspace.app.statistic_reporter.service.factory.StatisticReporterServiceFactory;
import org.dspace.content.service.CollectionService;
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
	ReporterResource getReporterBuilder() {
		ReporterResource reporter = new ReporterResource(statisticReporterService.buildStatisticReporter());
		
		reporter.add(linkTo(methodOn(this.getClass()).getReporterBuilderOnCommunity()).withRel("community"));
		reporter.add(linkTo(methodOn(this.getClass()).getReporterBuilderOnCommunities()).withRel("communities"));
		
		return reporter;
	}
	
	@RequestMapping("/community")
	ReporterResource getReporterBuilderOnCommunity() {
		ReporterResource reporter = new ReporterResource(statisticReporterService.buildStatisticReporter());
		return reporter;
	}
	
	
	@RequestMapping("/community_collection_test")
	Collection<ReporterResource> getReporterBuilderOnCommunities() {
		ReporterResource reporter1 = new ReporterResource(statisticReporterService.buildStatisticReporter());
		ReporterResource reporter2 = new ReporterResource(statisticReporterService.buildStatisticReporter());
		ArrayList<ReporterResource> array = new ArrayList<ReporterResource>();
		array.add(reporter1); array.add(reporter2);
		return array;
	}
}
