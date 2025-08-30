package mas.mp5.mas_final.repository;

import mas.mp5.mas_final.model.Administrator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
    @Query("from Administrator as d left join fetch d.manages where d.id = :id")
    public Optional<Administrator> findById(@Param("id") Long id);
}
