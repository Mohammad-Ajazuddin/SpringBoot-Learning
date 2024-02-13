package learning.edtex.demoForJpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learning.edtex.demoForJpa.Repository.StudentRepo;
import learning.edtex.demoForJpa.entity.Student;

@RestController
public class StudentController {
	@Autowired
	StudentRepo repo;
	
	@PostMapping("api/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		
		List<Student> allStudents = repo.findAll();
		
		for(int i=0;i<allStudents.size();i++)
		{
			if(allStudents.get(i).getStudentName().equalsIgnoreCase(student.getStudentName()) && allStudents.get(i).getStudentEmail().equalsIgnoreCase(student.getStudentEmail()) && allStudents.get(i).getStudentAddress().equalsIgnoreCase(student.getStudentAddress()))
			{
				return new ResponseEntity<>(HttpStatus.CONFLICT);
				//student already exists
			}
		}
		return new ResponseEntity<>(repo.save(student),HttpStatus.CREATED);
		//here response entity is class implemented from Http entity
		//we can decide the http code for which response what to be sent here ex:created =>Response code 201 Created(can see in postman)
		//trying to fetch non-existent data, so some internal error like that
	}
	
	@GetMapping("api/student")
	public ResponseEntity<List<Student>> getAllStudents()
	{
		return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("api/student/{id}")
	public ResponseEntity<Student> getById(@PathVariable("id") int id)
	{
		Optional<Student> studentData = repo.findById(id);
		
		//i thought it would return null if not found
//		if(studentData==null)
//		{
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
		if(studentData.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);//404 Not Found
		}
		else
		{
			return new ResponseEntity<>(studentData.get(),HttpStatus.OK);
		}
	}
	
//	@PutMapping("api/student/{id}")
//	public ResponseEntity<Student> updateOrSaveStudent(@PathVariable("id") int id,@RequestBody Student student)
//	{
//		Optional<Student> studentData = repo.findById(id);
//		
//		if(studentData.isPresent())
//		{
//			studentData.get().setId(id);
//			studentData.get().setStudentName(student.getStudentName());
//			studentData.get().setStudentEmail(student.getStudentEmail());
//			studentData.get().setStudentAddress(student.getStudentAddress());
//			return new ResponseEntity<>(repo.save(studentData.get()),HttpStatus.OK);
//			//updation ok
//		}
//		else
//		{
//			repo.save(student)
//			student.setId(id);
//			return new ResponseEntity<>(student,HttpStatus.CREATED);
//			//ID following the order of auto generation. Unable to specify Desired ID
//		}
//	}
	//lets use only for updating
	@PutMapping("api/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id,@RequestBody Student student)
	{
		Optional<Student> studentData = repo.findById(id);
		
		if(studentData.isPresent())
		{
			studentData.get().setId(id);
			studentData.get().setStudentName(student.getStudentName());
			studentData.get().setStudentEmail(student.getStudentEmail());
			studentData.get().setStudentAddress(student.getStudentAddress());
			return new ResponseEntity<>(repo.save(studentData.get()),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("api/student/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id)
	{
		Optional<Student> studentData = repo.findById(id);
		
		if(studentData.isPresent())
		{
			Optional<Student> deletedStudent = studentData;
			repo.deleteById(id);
			return new ResponseEntity(deletedStudent.get(),HttpStatus.GONE);
		}
		
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
