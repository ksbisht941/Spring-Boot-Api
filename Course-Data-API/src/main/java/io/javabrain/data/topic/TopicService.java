package io.javabrain.data.topic;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepositiory;
	
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepositiory.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepositiory.findById(id).orElse(null);
	}

	public void addTopic(Topic topic) {
		topicRepositiory.save(topic);
	}

	public void updateTopic(String id, Topic topic) {		
		topicRepositiory.save(topic);
	}

	public void deleteTopic(String id) {
//		topics.removeIf(t -> t.getId().equals(id));
		topicRepositiory.deleteById(id);;
	}
}
