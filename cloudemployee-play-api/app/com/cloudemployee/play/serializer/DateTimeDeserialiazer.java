package com.cloudemployee.play.serializer;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

/**
 * Sep 20, 2016 12:45:34 PM
 * 
 * @author © tdelacerna <teodoro.delacerna@fsoft.com.vn>
 */
public class DateTimeDeserialiazer extends StdScalarDeserializer<DateTime> {
	
    public DateTimeDeserialiazer(){
        super(DateTime.class);
    }
    
    public DateTimeDeserialiazer(Class<?> vc){
        super(vc);
    }

    @Override
    public DateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
    	String date = jsonParser.getText();
    	DateTimeFormatter parser = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
    	
		return parser.parseDateTime(date);
    }
}
