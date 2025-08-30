package mas.mp5.mas_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"tutorId", "groupId", "date"})
})
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tutorId", nullable = false, updatable = false)
    @NotNull
    private Tutor taughtBy;

    @ManyToOne
    @JoinColumn(name = "groupId", nullable = false, updatable = false)
    @NotNull
    private Group taughtOn;

    @NotNull
    private LocalDate date;

    @NotBlank
    private String topic;

    @OneToOne
    @JoinColumn(name = "occupancyId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Occupancy occupies;

}
