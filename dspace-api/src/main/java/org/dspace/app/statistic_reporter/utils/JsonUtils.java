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

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

public class JsonUtils {

	public static DocumentContext parseJsonText(String jsonText) throws IOException {
		return JsonPath.parse(jsonText);
	}
	
	public static DocumentContext parseJsonFile(String filePath) throws IOException{
		return JsonPath.parse(new File(filePath));
	}
	
	public static DocumentContext find(DocumentContext jsonContext, String jsonPathExpression) {
		String result = jsonContext.read(jsonPathExpression);
		return JsonPath.parse(result);
	}
	
	public static HashMap<String,String> getProperties(DocumentContext jsonContext){
		HashMap<String, String> properties = jsonContext.read("$.*");
		return properties;
	}

}
