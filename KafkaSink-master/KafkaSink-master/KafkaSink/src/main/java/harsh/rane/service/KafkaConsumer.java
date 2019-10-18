package harsh.rane.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.KafkaHeaders;


@Service
public class KafkaConsumer {
	
	private static final Logger LOG = LogManager.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "topic2", group = "group_id", containerFactory="kafkaListenerContainerFactory")
	public void consumeJoin(@Payload String data,
            @Header(KafkaHeaders.OFFSET) Long offset,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey,
            @Header("X-Custom-Header") String customHeader)
	{
		System.out.println(data
				);
		LOG.info("- - - - - - - - - - - - - - -");
		LOG.info("received message='{}'", data);
		//LOG.info("consumer: {}", consumer);
		LOG.info("topic: {}", topic);
		LOG.info("message key: {}", messageKey);
		LOG.info("partition id: {}", partitionId);
		LOG.info("offset: {}", offset);
//		LOG.info("timestamp type: {}", timestampType);
//		LOG.info("timestamp: {}", timestamp);
		//LOG.info("custom header: {}", customHeader);
		System.out.println(data);}
}
