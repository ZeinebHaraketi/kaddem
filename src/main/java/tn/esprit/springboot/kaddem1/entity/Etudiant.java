package tn.esprit.springboot.kaddem1.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table( name="Etudiant")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant;

    @Column(name = "prenomE")
    private String prenomE;

    @Column(name = "nomE")
    private String nomE;

    @Column(name = "opt")
    @Enumerated(EnumType.STRING)
    Option opt;

    @ManyToOne(cascade = CascadeType.ALL)
    Departement Departements;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Equipe> EtudiantEquipe;

}
