/**
 * 
 */
package com.cloudemployee.play.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import com.cloudemployee.play.models.Customer;
import com.cloudemployee.play.service.CustomerService;
import com.cloudemployee.play.util.CommonUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;

/**
 * Sep 20, 2016 12:27:07 PM
 * 
 * @author © tdelacerna <teodoro.delacerna@fsoft.com.vn>
 */
public class CustomerController extends Controller{
	
	@Inject
	CustomerService service;
	
	@BodyParser.Of(BodyParser.Json.class)
	public Result getCustomers() {
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			Json.setObjectMapper(objectMapper);
			JsonNode nodes = request().body().asJson();
			if( null == nodes){
				throw new Exception("Payload not found!");
			}
			
			String jsonString = nodes.toString();
			List<Customer> customers = objectMapper.readValue(jsonString, objectMapper.getTypeFactory().constructCollectionType(List.class, Customer.class));
			service.sort(customers);
			
			return ok( Json.toJson(customers) );
		}catch(Exception ex ){
			throw new IllegalStateException(ex.getMessage(), ex);
		}
	}
	
	public Result previewCustomers(){
		InputStream is = null;
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			Json.setObjectMapper(objectMapper);
			MultipartFormData<File> body = request().body().asMultipartFormData();
			if( CommonUtil.isEmpty(body) )
				throw new Exception("File not found.");
			
			for( FilePart<File> file : body.getFiles() ){
				String fileName = file.getFilename();
				int idx = fileName.lastIndexOf('.');
				boolean valid = (idx > 0 && fileName.substring(idx+1).toLowerCase().matches("json"));
				if( idx <= 0 || !valid ){
					// throw new Exception("Invalid file.");
					continue;
				}
				is = new FileInputStream(file.getFile());
				JsonNode nodes = Json.parse(is);
				
				String jsonString = nodes.toString();
				List<Customer> customers = objectMapper.readValue(jsonString, objectMapper.getTypeFactory().constructCollectionType(List.class, Customer.class));
				
				service.sort(customers);
				
				return ok( Json.toJson(customers) );
			}
			
			return ok();
		}catch( Exception ex){
			throw new IllegalStateException(ex.getMessage(),ex);
		}finally{
			CommonUtil.closeQuietely(is);
		}
	}
	
	
}
