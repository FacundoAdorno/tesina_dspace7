/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.model;

import java.util.ArrayList;
import org.dspace.app.statistic_reporter.model.ReporterResult;

public class ReporterInstance {

	private ScopeInstance primaryScope;
	
	private ArrayList<ObservableAspectInstance> observables;

	public ReporterInstance() {
		this.observables = new ArrayList<ObservableAspectInstance>();
	}

	public ScopeInstance getPrimaryScope() {
		return primaryScope;
	}

	public void setPrimaryScope(ScopeInstance primaryScope) {
		this.primaryScope = primaryScope;
	}

	public ArrayList<ObservableAspectInstance> getObservables() {
		return observables;
	}

	public void setObservables(ArrayList<ObservableAspectInstance> observables) {
		this.observables = observables;
	}

}
