/**
 * 
 */
package com.cloudemployee.play.service;

import java.util.Collections;
import java.util.List;

import javax.inject.Singleton;

import com.cloudemployee.play.models.Employee;


/**
 * Sep 20, 2016 12:45:34 PM
 * 
 * @author © tdelacerna <teodoro.delacerna@fsoft.com.vn>
 */
@Singleton
public class EmployeeService {
	
	public void sort( List<Employee> employees ){
		Collections.sort( employees );
	}
	
}
