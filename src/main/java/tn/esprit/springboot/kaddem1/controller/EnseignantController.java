package tn.esprit.springboot.kaddem1.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.kaddem1.entity.Enseignant;
import tn.esprit.springboot.kaddem1.entity.Projet;
import tn.esprit.springboot.kaddem1.services.EnseignantService;

import java.util.List;

@Tag(name = "Gestion Enseignant")
@RestController
@RequestMapping("/enseignant")
public class EnseignantController {

    @Autowired
    EnseignantService enseignantService;

    @Operation(description = "Affichage de la liste des enseignants")
    @GetMapping("/allEns")
    private List<Enseignant> allEnseignants(){
        return enseignantService.retrieveAllEnseignants();
    }

    @Operation(description = "Ajout d'un enseignant")
    @PostMapping("/addEn")
    @ResponseBody
    public Enseignant addEnseignant(@RequestBody Enseignant e) {
        return enseignantService.addEnseignant(e);
    }

    @Operation(description = "Modification d'un enseignant ")
    @PutMapping("/modifEn")
    @ResponseBody
    public Enseignant updateEnseignant(@RequestBody  Enseignant e) {
        return enseignantService.updateEnseignant(e);
    }

    @Operation(description = "Suppression d'un enseignant")
    @DeleteMapping ("/sppEn/{idEns}")
    @ResponseBody
    public void removeEnseignant(@PathVariable("idEns") Long idEns) {
        enseignantService.removeEnseignant(idEns);
    }


    @Operation(description = "Affichage d'un enseignat par Id")
    @GetMapping("/allEns/{idEns}")
    private Enseignant displayById(@PathVariable("idEns") int idEns){
        return enseignantService.retrieveEnseignant(idEns);
    }
}
