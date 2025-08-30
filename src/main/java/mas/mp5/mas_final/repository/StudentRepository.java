package mas.mp5.mas_final.repository;

import mas.mp5.mas_final.model.Student;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findAllByBelongsToIsNull();
}

