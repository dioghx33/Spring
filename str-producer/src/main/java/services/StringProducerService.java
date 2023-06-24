package services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.config.StringProducerFactoryConfig;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StringProducerService {
	StringProducerFactoryConfig str;
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public StringProducerService() {
		str = new StringProducerFactoryConfig();
		kafkaTemplate = str.kafkaTemplate(str.producerFactory());
	}
	public void sendMessage (String message) {
		kafkaTemplate.send("str-topic", message);
	}
	
}
