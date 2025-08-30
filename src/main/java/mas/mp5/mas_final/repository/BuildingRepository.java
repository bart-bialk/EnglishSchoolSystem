package mas.mp5.mas_final.repository;

import mas.mp5.mas_final.model.Building;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BuildingRepository extends CrudRepository<Building, Long> {

    @Query("from Building as d left join fetch d.managedBy where d.id = :id")
    public Optional<Building> findById(@Param("id") Long id);

    public Optional<Building> findByName(@Param("name") String name);
}
