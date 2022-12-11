package tn.esprit.springboot.kaddem1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.kaddem1.entity.Departement;
import tn.esprit.springboot.kaddem1.services.DepartementService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Tag(name = "Gestion des Departement")
@RequestMapping("/depart")
public class DepartementController {

    @Autowired
    DepartementService departementService;

    @Operation(description = "Affichage de la liste des departements")
    @GetMapping("/depart")
    private List<Departement> allDepartements(){
        return departementService.retrieveAllDepartements();
    }

    @Operation(description = "Ajout d'un departement")
    @PostMapping("/depart")
    @ResponseBody
    public void ajoutDepartement(@RequestBody Departement d){
        departementService.ajoutDepartement(d);
    }

    @Operation(description = "Suppression d'un departement")
    @DeleteMapping ("/depart{idDepart}")
    @ResponseBody
    public void supprimerContrat(@PathVariable("idDepart") Long idDepart){
        departementService.removeDepart(idDepart);
    }

    @PutMapping("/update")
    @Operation(description = "Modification d'un departement  ")
    private Departement modifierDepartement(@RequestBody Departement d){
       return departementService.updateDepartement(d);
    }



    @PutMapping("/assignEtudiantToDepartement/{idEtudiant}/{idDepart}")
    public void assignEtudiantToDepartement(@RequestParam Integer idEtudiant,@RequestParam Long idDepart) {
        departementService.assignEtudiantToDepartement(idEtudiant,idDepart);
    }

}
