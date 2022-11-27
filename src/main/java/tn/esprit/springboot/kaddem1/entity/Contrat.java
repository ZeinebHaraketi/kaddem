package tn.esprit.springboot.kaddem1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name="Contrat")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private Long idContrat;

    @Column(name = "dateDebutContrat")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/mm/dd")
    private Date dateDebutContrat;

    @Column(name = "dateFinContrat")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/mm/dd")
    private Date dateFinContrat;

    @Column(name = "specialite")
    @Enumerated(EnumType.STRING)
    Specialite specialite;

    @Column(name = "archive")
    private Boolean archive;

    @Column(name = "montantContrat")
    private int montantContrat;

    @ManyToOne
    private Etudiant etudiant;


}
