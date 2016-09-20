/**
 * 
 */
package com.cloudemployee.play.service;

import java.util.Collections;
import java.util.List;

import javax.inject.Singleton;

import com.cloudemployee.play.models.Customer;


/**
 * Sep 20, 2016 12:45:34 PM
 * 
 * @author © tdelacerna <teodoro.delacerna@fsoft.com.vn>
 */
@Singleton
public class CustomerService {
	
	public void sort( List<Customer> customers ){
		Collections.sort( customers );
	}
	
}
