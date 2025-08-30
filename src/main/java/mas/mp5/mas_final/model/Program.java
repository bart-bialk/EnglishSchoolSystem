package mas.mp5.mas_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private LocalDate startDate;

    @OneToMany(mappedBy = "realises")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Group> isRealisedBy = new HashSet<>();
}
