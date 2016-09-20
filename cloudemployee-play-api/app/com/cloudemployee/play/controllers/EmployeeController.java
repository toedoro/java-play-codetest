/**
 * 
 */
package com.cloudemployee.play.controllers;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import com.cloudemployee.play.models.Employee;
import com.cloudemployee.play.service.EmployeeService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Sep 20, 2016 12:27:07 PM
 * 
 * @author © tdelacerna <teodoro.delacerna@fsoft.com.vn>
 */
public class EmployeeController extends Controller{
	
	@Inject
	EmployeeService service;
	
	@Inject HttpExecutionContext ec;
	
	@BodyParser.Of(BodyParser.Json.class)
	public CompletionStage<Result> sortEmployee() {
		try{
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			Json.setObjectMapper(objectMapper);
			JsonNode nodes = request().body().asJson();
			if( null == nodes){
				throw new Exception("Payload not found!");
			}
			String jsonString = nodes.toString();
			return CompletableFuture.supplyAsync(() ->{
					try {
						List<Employee> employees = objectMapper.readValue(jsonString, objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
						service.sort(employees);
						
						return employees;
					} catch (IOException e) {
						throw new IllegalStateException(e.getMessage(),e);
					}
				}).thenApply(employees -> ok( Json.toJson(employees) ) );
		}catch(Exception ex ){
			throw new IllegalStateException(ex.getMessage(), ex);
		}
	}
	
}
