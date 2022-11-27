package tn.esprit.springboot.kaddem1.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name="Departement")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepart")
    private Long idDepart;

    @Column(name = "nomDepart")
    private String nomDepart;

}
