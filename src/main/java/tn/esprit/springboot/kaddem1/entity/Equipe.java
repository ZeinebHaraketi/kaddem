package tn.esprit.springboot.kaddem1.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name="Equipe")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")
    private Long idEquipe;

    @Column(name = "nomEquipe")
    private String nomEquipe;

    @Enumerated(EnumType.STRING)
    @Column(name = "niveau")
    private Niveau niveau;


    @OneToOne
    private DetailEquipe detailEquipe;

    @ManyToMany(mappedBy = "EtudiantEquipe", cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

    @OneToOne
    private  Projet projet;

}
