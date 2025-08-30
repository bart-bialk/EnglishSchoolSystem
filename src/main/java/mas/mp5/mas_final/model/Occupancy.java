package mas.mp5.mas_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"lessonId", "roomId"})
})
public class Occupancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private LocalTime hourFrom;

    @NotNull
    private LocalTime hourTo;

    @OneToOne
    @JoinColumn(name = "lessonId", nullable = false, updatable = false)
    @NotNull
    private Lesson occupiedBy;

    @ManyToOne
    @JoinColumn(name = "roomId",  nullable = false, updatable = false)
    @NotNull
    private Room occupies;
}
