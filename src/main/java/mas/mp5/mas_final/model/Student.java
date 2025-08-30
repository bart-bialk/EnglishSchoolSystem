package mas.mp5.mas_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Student extends Person{

    @NotNull
    @Enumerated(EnumType.STRING)
    private StudentStatus status = StudentStatus.Candidate;

    @ManyToOne
    @JoinColumn(name = "groupId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Group belongsTo;
}
