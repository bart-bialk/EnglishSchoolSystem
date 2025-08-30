package mas.mp5.mas_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    @OneToMany(mappedBy = "manages")
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Administrator> managedBy = new HashSet<>();

    @OneToMany(mappedBy = "whole", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("number")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Room> parts = new TreeSet<>();

}
