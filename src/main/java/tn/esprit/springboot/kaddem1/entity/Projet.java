package tn.esprit.springboot.kaddem1.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name="Projet")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProjet")
    private Long idProjet;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Equipe> equipes;

}
