package edu.cjc.sma.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cjc.sma.app.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

	List<Student> findAllByBatchNumber(String batchNumber,String batchMode );

}
