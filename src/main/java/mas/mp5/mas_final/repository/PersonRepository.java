package mas.mp5.mas_final.repository;

import mas.mp5.mas_final.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
