package mas.mp5.mas_final.repository;

import mas.mp5.mas_final.model.Tutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TutorRepository extends CrudRepository<Tutor, Long> {
    @Query("from Tutor as d left join fetch d.teachesOn where d.id = :id")
    public Optional<Tutor> findById(@Param("id") Long id);
}
