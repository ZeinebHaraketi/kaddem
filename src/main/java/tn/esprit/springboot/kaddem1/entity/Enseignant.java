package tn.esprit.springboot.kaddem1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table( name="Enseignant")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Enseignant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEns")
    private Long idEns;

    @Column(name = "nomEn")
    private String nomEn;

    @Column(name = "prenomEn")
    private String prenomEn;

    @Column(name = "salaire")
    private Float salaire;
}
