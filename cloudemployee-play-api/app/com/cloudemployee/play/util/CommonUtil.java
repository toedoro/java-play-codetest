package com.cloudemployee.play.util;

import java.io.Closeable;
import java.util.List;
import java.util.Map;


/**
 * Sept 21, 2016 2:55:03 PM
 * 
 * @author © tdelacerna <teodoro.delacerna@fsoft.com.vn>
 */
public class CommonUtil {
	
	
	public static boolean isEmpty( Object... objects ){
		for( Object obj : objects ){
			if( null == obj ) return true;
			if( obj instanceof String ) return ((String)obj).isEmpty(); 
			if( obj instanceof List ) return ((List)obj).isEmpty();
			if( obj instanceof Map ) return ((Map)obj).isEmpty();
				
			return false;
		}
		
		return true;
	}
	
	public static void closeQuietely( Closeable closeable ){
		if( !isEmpty(closeable) ){
			try{closeable.close();}catch(Exception ex){;}
		}
	}
	
}
