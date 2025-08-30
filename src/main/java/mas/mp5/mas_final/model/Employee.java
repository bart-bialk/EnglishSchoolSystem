package mas.mp5.mas_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Employee extends Person{

    @NotNull
    @Min(0)
    private double salary;

    @OneToOne(mappedBy = "superclass", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Tutor tutor;

    @OneToOne(mappedBy = "superclass", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Manager manager;

    @OneToOne(mappedBy = "superclass", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Administrator administrator;
}
