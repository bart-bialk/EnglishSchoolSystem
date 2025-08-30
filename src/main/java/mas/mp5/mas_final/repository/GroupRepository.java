package mas.mp5.mas_final.repository;

import mas.mp5.mas_final.model.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GroupRepository extends CrudRepository<Group, Long> {

}
