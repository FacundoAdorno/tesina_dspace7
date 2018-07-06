package org.dspace.discovery.facu_tests;

import org.dspace.core.Context;
import org.dspace.discovery.DiscoverQuery;
import org.dspace.discovery.DiscoverResult;
import org.dspace.discovery.SearchServiceException;
import org.dspace.discovery.SearchUtils;
import org.dspace.discovery.SolrServiceImpl;
import org.dspace.servicemanager.DSpaceKernelImpl;
import org.dspace.servicemanager.DSpaceKernelInit;

public class Pruebas_Discovery {

	static String titleToSearch = "Resistencia";
	
	static String dateToSearch = "2014-12-05T14:44:25Z";
	
	static String dsoTypeToSearch = "2";
	
	/** The service manager kernel */
    private static transient DSpaceKernelImpl kernelImpl;
	
	public static void main(String[] args) {
		
		initDSpace();
		
		Context context = new Context(Context.Mode.READ_ONLY);
		context.turnOffAuthorisationSystem();
		
		DiscoverQuery query = new DiscoverQuery();
		
		String dsoFilter = "search.resourcetype:" + dsoTypeToSearch;
		
		String titleQ = "dc.title:" + titleToSearch;
		String accessionedQ = "dc.date.accessioned_dt:[* TO " + dateToSearch + "]"; 
		
		query.addFilterQueries(dsoFilter);
		query.setQuery(titleQ + " AND " + accessionedQ);
		SolrServiceImpl solrService = (SolrServiceImpl) SearchUtils.getSearchService();
		try {
			DiscoverResult result = solrService.search(context, query);
			result.getDspaceObjects();
		} catch (SearchServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void initDSpace() {
		// Initialise the service manager kernel
        try
        {
            kernelImpl = DSpaceKernelInit.getKernel(null);
            if (!kernelImpl.isRunning())
            {
                kernelImpl.start();
            }
        } catch (Exception e)
        {
            // Failed to start so destroy it and log and throw an exception
            try
            {
                kernelImpl.destroy();
            }
            catch (Exception e1)
            {
                // Nothing to do
            }
            String message = "Failure during kernel init: " + e.getMessage();
            System.err.println(message);
            e.printStackTrace();
            throw new IllegalStateException(message, e);
        }
	}
}
