package io.javabrain.data.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepositiory;
	
	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepositiory.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepositiory.findById(id).orElse(null);
	}

	public void addCourse(Course course) {
		courseRepositiory.save(course);
	}

	public void updateCourse(Course course) {		
		courseRepositiory.save(course);
	}

	public void deleteCourse(String id) {
//		topics.removeIf(t -> t.getId().equals(id));
		courseRepositiory.deleteById(id);;
	}
}
