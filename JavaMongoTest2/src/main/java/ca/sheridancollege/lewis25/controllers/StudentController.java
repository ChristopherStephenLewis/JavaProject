package ca.sheridancollege.lewis25.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.lewis25.beans.Student;
import ca.sheridancollege.lewis25.repository.StudentRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StudentController {
	
	private StudentRepository stuRepo;

	@GetMapping("/students")
	public List<Student> getCollection() {
		return stuRepo.findAll();
	}
	
	@PostMapping(value="/students", headers= {"Content-type=application/json"})
	public String postCollection(@RequestBody Student student) {
		Student s = stuRepo.save(student);
		return s.getId();
	}
	
	@PutMapping(value="/students/{id}", headers= {"Content-type=application/json"})
	public String putElement(@RequestBody Student student, @PathVariable String id) {
		student.setId(id);
		Student s = stuRepo.save(student);
		return "Student at id " + s.getId() + " was replaced";
	}
	
	@DeleteMapping(value="/students/{id}", headers= {"Content-type=application/json"})
	public String deleteElement(@PathVariable String id) {
		Optional<Student> student = stuRepo.findById(id);
		if (student.isPresent()) {
			stuRepo.deleteById(id);
			return "Element was deleted";
		} else {
			return "Element was not found";
		}
	}
}
