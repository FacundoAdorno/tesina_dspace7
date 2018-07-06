/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.statistic_reporter.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.filter.JsonPointerBasedFilter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PrimerIntentoJsonUtils {

	public static JsonNode readJsonFile(String filePath) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
    	JsonNode configRoot = mapper.readTree(new File(filePath));
    	return configRoot;
	}
	
	public static HashMap<String,Object> readJsonFileAsMap(String filePath) throws JsonProcessingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		JsonNode configRoot = mapper.readTree(new File(filePath));
		HashMap<String, Object> map = mapper.convertValue(configRoot, HashMap.class);
		return map;
		
	}
	
	/**
	 * Encuentra un nodo hijo inmediatamente bajo el nodo contextual. No busca en profundidad, es decir en propiedades de otros subnodos....
	 * 
	 * @param contextNode
	 * @param PropertyName
	 * @return
	 */
	public static JsonNode readProperty(JsonNode contextNode, String propertyKey) {
		return contextNode.path("options").path(propertyKey);
	}
	
	public static String readPropertyAsString(JsonNode contextNode, String propertyKey) {
		return contextNode.path("options").path(propertyKey).asText();
	}
	
//	public static String CONTEXT_TAG_NAME = "Context";
//	public static String MDT_TAG_NAME = "MetadataSets";
//	public static String OPERATORS_TAG_NAME = "OperatorsSets";
//
//	
//    public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException
//    {
//    	
//    	ObjectMapper mapper = new ObjectMapper();
//    	
//    	JsonNode configRoot = mapper.readTree(new File("src/main/java/org/facu/tesina/example.json"));
//    	
//    	
//    	
//    	JsonNode contextOptions = configRoot.get(CONTEXT_TAG_NAME);
//    	JsonNode mdtSets = configRoot.get(MDT_TAG_NAME);
//    	JsonNode opSets = configRoot.get(OPERATORS_TAG_NAME);
//    	
//    	Iterator<String> contexts = contextOptions.path("options").fieldNames();
//    	
//    	while(contexts.hasNext()) {
//    		String context = contexts.next();
//    		System.out.println(context);
//    		JsonNode implClasses = contextOptions.path("options").path(context).path("implementingClass");
//    		//Cuando no existe la ruta especificada, en vez de retornar NULL retorna un MissingNode
//    		if(!implClasses.isMissingNode()) {
//    			System.out.println("Clase que implementa: " + implClasses.asText());
//    		}
//    	}
//    	
//    	
//    	JsonNode classes = contextOptions.path("implementingClasses");
//    	
//    	for(JsonNode node : classes) {
//    		Iterator<Entry<String, JsonNode>> iterator_class = node.fields(); 
//    		while(iterator_class.hasNext()) {
//    			Entry<String, JsonNode> implClass = iterator_class.next();
//    			String class_id = implClass.getKey();
//    			String class_path = implClass.getValue().asText();
//    			System.out.println(class_id);
//    			System.out.println(class_path);
//    		}
//    	}
//    	
//    	
//    }
}
