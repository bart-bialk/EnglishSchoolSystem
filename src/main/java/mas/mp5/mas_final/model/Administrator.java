package mas.mp5.mas_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Administrator{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(1)
    private double bonus;

    @ManyToOne
    @JoinColumn(name = "buildingId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Building manages;

    @OneToOne(optional = false)
    @JoinColumn(name = "superclassId", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Employee superclass;
}
