package io.soumyadev.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class topicBook {
	@Bean
	public NewTopic creationTopicConfig() {
		return TopicBuilder.name("TopicBook-dev-insertUpdate").partitions(1).replicas(1).build();
	}
}
