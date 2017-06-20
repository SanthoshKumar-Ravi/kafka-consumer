package com.stackroute.swisit.serialization;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.swisit.crawler.domain.SwisitBean;
//import com.stackroute.swisit.domain.CrawlerBean;
import com.stackroute.swisit.domain.CrawlerResult;

public class CrawlerDeserializer implements Deserializer<CrawlerResult>{

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CrawlerResult deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		ObjectMapper o=new ObjectMapper();
		CrawlerResult c=null;
		try{
			//System.out.println(arg1.toString());
			c=o.readValue(data,CrawlerResult.class);
			}
		catch(Exception e){
			System.out.println("hi this "+e);
		}
		return c;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
