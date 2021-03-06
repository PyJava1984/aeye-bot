package com.a.eye.bot.common.message.actor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.a.eye.bot.common.message.dispatch.ConsumerDispathcer;

public class ActorConsumer extends Thread {
	private Logger logger = LogManager.getLogger(this.getClass());
	private static Properties properties = new Properties();
	private static String kafkaproperty = "properties/kafka.properties";
	private final KafkaConsumer<Long, String> consumer;
	private ConsumerDispathcer consumerDispathcer = new ConsumerDispathcer();

	private String topicName;

	public ActorConsumer() {
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(kafkaproperty);
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		consumer = new KafkaConsumer<>(properties);
	}

	@Override
	public void run() {
		consumer.subscribe(Arrays.asList(topicName));
		logger.debug(topicName);
		while (true) {
			ConsumerRecords<Long, String> records = consumer.poll(100);
			for (ConsumerRecord<Long, String> record : records) {
				logger.debug("offset = " + record.offset() + ", key = " + record.key() + ", value = " + record.value());
				try {
					consumerDispathcer.dispatch(record.key(), record.value());
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(record.value());
				}
			}
		}
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
}
