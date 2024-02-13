package learning.edtex.demoForJpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import learning.edtex.demoForJpa.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
