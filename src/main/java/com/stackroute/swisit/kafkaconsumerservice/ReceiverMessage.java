package com.stackroute.swisit.kafkaconsumerservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.stereotype.Service;


//import com.stackroute.swisit.domain.CrawlerBean;
import com.stackroute.swisit.domain.CrawlerResult;
@Service
public class ReceiverMessage {

	public List<CrawlerResult> receivingMessage(String string) {
		// TODO Auto-generated method stub
		Properties props = new Properties();
	    props.put("group.id", "group-1");
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	    props.put("value.deserializer","com.stackroute.swisit.serialization.CrawlerDeserializer");
		List<CrawlerResult> final_kafka=new ArrayList<CrawlerResult>();
	    KafkaConsumer<String, CrawlerResult> kafkaConsumer = new KafkaConsumer<>(props);
	    kafkaConsumer.subscribe(Arrays.asList(string));
	    System.out.println("hi i am getting");
	    while (true) {
	      ConsumerRecords<String, CrawlerResult> records = kafkaConsumer.poll(100000);
	      for (ConsumerRecord<String, CrawlerResult> record : records) {
	       System.out.println("inside consumer i am getting"+record.value());
	    	  final_kafka.add(record.value());
	    	 }
	    	  return final_kafka;
	    }
	     
	  }
	}


