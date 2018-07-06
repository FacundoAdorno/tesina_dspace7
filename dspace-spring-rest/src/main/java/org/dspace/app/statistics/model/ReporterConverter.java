/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistics.model;

import java.util.ArrayList;

import org.dspace.app.statistic_reporter.model.ConditionInstance;
import org.dspace.app.statistic_reporter.model.ReporterInstance;
import org.dspace.app.statistic_reporter.model.ScopeInstance;
import org.dspace.app.statistic_reporter.service.DefaultConfigurationLoaderServiceImpl;
import org.dspace.app.statistic_reporter.service.StatisticReporterService;

public class ReporterConverter {
	public static ReporterInstance toModel(StatisticReporterService statisticService, ReporterInstanceRequest reporterRequest) {
		//TODO me parece que voy a tener que sacar el configurationService... y poner un objeto mas simple??
		DefaultConfigurationLoaderServiceImpl config = (DefaultConfigurationLoaderServiceImpl) statisticService.getConfigurationService();
		
		ReporterInstance ri = new ReporterInstance();
		//TODO no estamos haciendo ninguna validación...
		ScopeInstance scopeInst = new  ScopeInstance();
		scopeInst.setScope(config.getScopeById(reporterRequest.getPrimaryScope().getId()));

		if(reporterRequest.getPrimaryScope().getConditions().size() > 0) {
			ArrayList<ConditionInstance> conditions = new ArrayList<ConditionInstance>(); 
			for (ConditionRequest condition : reporterRequest.getPrimaryScope().getConditions()) {
				//TODO validar que la condición sea válida en el Scope requerido
				ConditionInstance condInst = new ConditionInstance();
				condInst.setOperator(config.getOperatorById(condition.getOp_id()));
				condInst.setMetadata(condition.getMtd_id());
				condInst.setValue(condition.getValue());
				conditions.add(condInst);
			}
			scopeInst.setConditions(conditions);
		}
		
		ri.setPrimaryScope(scopeInst);
		
		//TODO seguir con los ObservableAspects...
		
		
		return ri;
	}
}
