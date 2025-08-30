package mas.mp5.mas_final.repository;

import mas.mp5.mas_final.model.Building;
import mas.mp5.mas_final.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, Long> {
    @Query("from Room as d left join fetch d.whole where d.id = :id")
    public Optional<Room> findById(@Param("id") Long id);

    @Query("from Room as d left join fetch d.whole")
    public Iterable<Room> findAllWithWhole();
}
