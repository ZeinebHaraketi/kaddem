package tn.esprit.springboot.kaddem1.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Universite")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUniv")
    Long idUniv;

    @Column(name = "nomUniv")
    String nomUniv;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> Departements;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Enseignant> enseignants;
}

