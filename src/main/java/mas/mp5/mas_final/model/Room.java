package mas.mp5.mas_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Room implements Comparable<Room> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(1)
    @NotNull(message = "number is mandatory")
    private Integer number;

    @Min(0)
    @NotNull(message = "places is mandatory")
    private int places;

    @ManyToOne(optional = false)
    @JoinColumn(name = "wholeId", nullable = false, updatable = false)
    private Building whole;

    @OneToMany(mappedBy = "occupies")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Occupancy> occupiedBy;

    @Override
    public int compareTo(Room o) {
        return this.number.compareTo(o.number);
    }
}
