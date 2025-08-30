package mas.mp5.mas_final.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "courses", joinColumns = @JoinColumn(name = "managerId"))
    @Builder.Default
    private Set<String> courses = new HashSet<>();

    @OneToOne(optional = false)
    @JoinColumn(name = "superclassId", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Employee superclass;
}
