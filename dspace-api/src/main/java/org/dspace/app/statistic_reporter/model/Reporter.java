package org.dspace.app.statistic_reporter.model;

import org.dspace.app.statistic_reporter.model.ContextDefinition;
import org.dspace.app.statistic_reporter.model.ConditionDefinition;
import org.dspace.app.statistic_reporter.model.ObservableAspectDefinition;

public class Reporter {

	//TODO convertir todos estos objetos a arrays o map...
	private ContextDefinition context;
	
	private ConditionDefinition condition;
	
	private ObservableAspectDefinition observable;

	
	public Reporter() {
		this.context = new ContextDefinition("example");
		this.condition = new ConditionDefinition("example");
		this.observable = new ObservableAspectDefinition("example");
	}
	
	
	public ContextDefinition getContext() {
		return context;
	}

	public void setContext(ContextDefinition context) {
		this.context = context;
	}

	public ConditionDefinition getCondition() {
		return condition;
	}

	public void setCondition(ConditionDefinition condition) {
		this.condition = condition;
	}

	public ObservableAspectDefinition getObservable() {
		return observable;
	}

	public void setObservable(ObservableAspectDefinition observable) {
		this.observable = observable;
	}
	
	
}
