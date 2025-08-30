package mas.mp5.mas_final.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Tutor{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "knownLanguages", joinColumns = @JoinColumn(name = "tutorId"))
    @Builder.Default
    private Set<String> knownLanguages = new HashSet<>();

    @OneToMany(mappedBy = "taughtBy", cascade = {CascadeType.REMOVE})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Lesson> teachesOn = new HashSet<>();

    @OneToOne(optional = false)
    @JoinColumn(name = "superclassId", nullable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Employee superclass;
}
