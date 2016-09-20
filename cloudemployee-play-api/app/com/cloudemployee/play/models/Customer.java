/**
 * 
 */
package com.cloudemployee.play.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.joda.time.DateTime;

import com.cloudemployee.play.serializer.DateTimeDeserialiazer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Sep 20, 2016 12:29:51 PM
 * 
 * @author © tdelacerna <teodoro.delacerna@fsoft.com.vn>
 */
@Entity
public class Customer implements Serializable, Comparable<Customer>{
	
	@Id
	private long id;
	
	private String name;
	
	@JsonDeserialize(using = DateTimeDeserialiazer.class)
	private DateTime duetime;
	
	@JsonDeserialize(using = DateTimeDeserialiazer.class)
	private DateTime jointime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DateTime getDuetime() {
		return duetime;
	}

	public void setDuetime(DateTime duetime) {
		this.duetime = duetime;
	}
	
	public DateTime getJointime() {
		return jointime;
	}

	public void setJointime(DateTime jointime) {
		this.jointime = jointime;
	}

	@Override
	public int compareTo(Customer customer) {
		DateTime thisDueDate = this.getDuetime();
		DateTime otherDueDate = customer.getDuetime();
		
		int flag = 0;
		
		if( thisDueDate.isAfter(otherDueDate) )
			flag = 1;
		else if( thisDueDate.isBefore(otherDueDate) )
			flag = -1;
		
		// default equals
		return flag;
	}
	
}
