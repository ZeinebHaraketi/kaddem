package tn.esprit.springboot.kaddem1.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.kaddem1.entity.Projet;
import tn.esprit.springboot.kaddem1.services.ProjetService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",exposedHeaders = "Access-Control-Allow-Origin")
@Tag(name = "Gestion Projet")
@RestController
@RequestMapping("/projet")
public class ProjetController {

    @Autowired
    ProjetService projetService;

    @Operation(description = "Affichage de la liste des projets")
    @GetMapping("/projet")
    private List<Projet> allProjets(){
        return projetService.retrieveAllProjets();
    }

    @Operation(description = "Ajout d'un projet")
    @PostMapping("/projet")
    @ResponseBody
    public Projet addProjet(@RequestBody Projet p) {
        return projetService.addProjet(p);
    }

    @Operation(description = "Modification d'un projet ")
    @PutMapping("/update")
    @ResponseBody
    public Projet updateProjet(@RequestBody  Projet p) {
        return projetService.updateProjet(p);
    }

    @Operation(description = "Suppression d'un projet")
    @DeleteMapping ("/projet/{idProjet}")
    @ResponseBody
    public void removeProjet(@PathVariable("idProjet") Long idProjet) {
        projetService.removeProjet(idProjet);
    }


    @Operation(description = "Affichage d'un projet par Id")
    @GetMapping("/projet/{idProjet}")
    private Projet displayById(@PathVariable("idProjet") long idProjet){
        return projetService.retrieveProjet(idProjet);
    }

    /*
    @PutMapping("/projets/{id}")
    public void updateTutorial(@PathVariable("id") long id, @RequestBody Projet projet) {
        Optional<Projet> projetData = Optional.of(projetService.retrieveProjet(id));

        Projet _tutorial = projetData.get();
        _tutorial.setIdProjet(projet.getIdProjet());
        _tutorial.setDescription(projet.getDescription());

    }*/


    @PutMapping ("/update/{idProjet}")
    public Projet updateProjet(@PathVariable("idProjet") long idProjet, @RequestBody Projet ce) throws Exception{
        return  projetService.updateProjet(idProjet,ce);
    }

    @DeleteMapping("/remove/{idProjet}")
    public void removeProjet(@PathVariable("idProjet") long id){
        projetService.removeProjet(id);
    }
}

