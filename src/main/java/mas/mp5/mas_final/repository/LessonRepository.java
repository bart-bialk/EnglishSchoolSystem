package mas.mp5.mas_final.repository;

import mas.mp5.mas_final.model.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    @Query("from Lesson as d left join fetch d.taughtBy left join fetch d.taughtOn where d.id = :id")
    public Optional<Lesson> findById(@Param("id") Long id);
}
