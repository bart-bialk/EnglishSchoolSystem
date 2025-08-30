package mas.mp5.mas_final.repository;

import mas.mp5.mas_final.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
