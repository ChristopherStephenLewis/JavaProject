package ca.sheridancollege.lewis25.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.lewis25.beans.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}
