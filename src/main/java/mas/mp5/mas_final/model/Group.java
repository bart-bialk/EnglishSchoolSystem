package mas.mp5.mas_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import mas.mp5.mas_final.validator.ValidGroupCode;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ValidGroupCode
@Table(name = "\"GROUP\"")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String groupCode;

    @NotBlank
    private String city;

    @NotBlank
    private String language;

    @NotBlank
    private String level;

    @Getter
    private static int maxStudents = 2;

    @OneToMany(mappedBy = "taughtOn", cascade = {CascadeType.REMOVE})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Lesson> learnsOn = new HashSet<>();

    @OneToMany(mappedBy = "belongsTo")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Student> isGroupOf = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "programId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Program realises;


    public static void changeMaxStudents(int newMaxStudents){
        if (newMaxStudents <= 0){
            throw new IllegalArgumentException("maxStudents must be greater than zero");
        }
        maxStudents = newMaxStudents;
    }

}
