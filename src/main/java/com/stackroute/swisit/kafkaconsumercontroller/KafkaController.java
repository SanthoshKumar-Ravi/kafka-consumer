package com.stackroute.swisit.kafkaconsumercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.stackroute.swisit.domain.CrawlerBean;
import com.stackroute.swisit.domain.CrawlerResult;
import com.stackroute.swisit.kafkaconsumerservice.ReceiverMessage;


//import com.stackroute.swisit.kafkaproducer.ProducerMessage;
@RestController
public class KafkaController {

	@Autowired
	ReceiverMessage receiverMessage;
	//Movie movie=new Movie();
	
	@RequestMapping("/receiver")
	public String publishMessage(){
		//movie.setId("1");
		//movie.setName("santhosh");
		System.out.println("hi inside consumer");
		List<CrawlerResult> l=receiverMessage.receivingMessage("tointent");
		System.out.println("list is "+l);
		return "published";
	}
}
