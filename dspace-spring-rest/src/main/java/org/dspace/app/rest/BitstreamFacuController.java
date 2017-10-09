package org.dspace.app.rest;

import java.util.ArrayList;
import java.util.List;

import org.dspace.app.rest.exception.PaginationException;
import org.dspace.app.rest.model.BitstreamRest;
import org.dspace.app.rest.model.RestModel;
import org.dspace.app.rest.model.hateoas.DSpaceResource;
import org.dspace.app.rest.repository.BitstreamRestRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api_facu/bs")
//public class BitstreamFacuController implements InitializingBean{
public class BitstreamFacuController {
	
	@Autowired
	DiscoverableEndpointsService discoverableEndpointsService;
	
	//Spring inyecta este bean automáticamente...
	@Autowired
	private BitstreamRestRepository bitstreamRestRepository; 
	
	@RequestMapping(value = "/filter")
//	public <T extends RestModel> PagedResources<DSpaceResource<T>> filterByBundleName(@RequestParam(value = "bundleName", required = true) String bundleName){
//	public Page<BitstreamRest> filterByBundleName(@RequestParam(value = "bundleName", required = true) String bundleName){
	public ResponseEntity<String> filterByBundleName(@RequestParam(value = "bundleName", required = true) String bundleName){
		//TODO: completar....
//		bitstreamRestRepository.findAllByBundle(context, pageable, bundleName);
	
//		List<Link> links = new ArrayList<Link>();
//		links.add(linkTo(methodOn(BitstreamFacuController.class).filterByBundleName(bundleName)));
//		discoverableEndpointsService.register(this, links);
		
		return new ResponseEntity<String>(bundleName, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/filter_2")
	@SuppressWarnings("unchecked")
	public PagedResources<DSpaceResource<BitstreamRest>> filterByBundleNameGetAll(@RequestParam(value = "bundleName", required = true) String bundleName, Pageable page, PagedResourcesAssembler assembler){
		Page<DSpaceResource<BitstreamRest>> resources;
		try {
			resources = bitstreamRestRepository.findAllByBundle(page, bundleName).map(bitstreamRestRepository::wrapResource);
		} catch (PaginationException pe) {
			resources = new PageImpl<DSpaceResource<BitstreamRest>>(new ArrayList<DSpaceResource<BitstreamRest>>(), page, pe.getTotal());
		}
		Link link = linkTo(methodOn(BitstreamFacuController.class).filterByBundleNameGetAll(bundleName, page, assembler)).withSelfRel();
		PagedResources<DSpaceResource<BitstreamRest>> result = assembler.toResource(resources, link);
		return result;
	}
	
//	@RequestMapping(value = "/filter_post")
//	public String filterByBundleNamePOST(@RequestBody String bundleName) {
//		
//	}

//	@Override
//	public void afterPropertiesSet() throws Exception {
//		List<Link> links = new ArrayList<Link>();
//		links.add(linkTo(methodOn(BitstreamFacuController.class).filterByBundleName("ORIGINAL")).withRel("filterByBundleName"));
//		links.add(linkTo(methodOn(BitstreamFacuController.class)).withSelfRel());
//		discoverableEndpointsService.register(this, links);
//		
//	}
}
