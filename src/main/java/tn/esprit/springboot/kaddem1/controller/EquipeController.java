package tn.esprit.springboot.kaddem1.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.kaddem1.entity.Contrat;
import tn.esprit.springboot.kaddem1.entity.Equipe;
import tn.esprit.springboot.kaddem1.services.EquipeService;

import java.util.List;

@Tag(name = "Gestion Equipe")
@RestController
@RequestMapping("/equipe")
public class EquipeController {

    @Autowired
    EquipeService equipeService;


    @Operation(description = "Affichage de la liste des equipes")
    @GetMapping("/allequipes")
    private List<Equipe> allEquipes(){
        return equipeService.retrieveAllEquipes();
    }

    @Operation(description = "Ajout d'une Equipe")
    @PostMapping("/addE")
    @ResponseBody
    public void ajoutEquipe(@RequestBody Equipe e){
        equipeService.ajoutEquipe(e);
    }


    @Operation(description = "Modification d'une Equipe")
    @PutMapping("/modifE")
    private Equipe modifierEquipe(@RequestBody Equipe e){
        return equipeService.updateEquipe(e);
    }


    @Operation(description = "Affichage d'une equipe par Id")
    @GetMapping("/allequipe/{idEquipe}")
    private Equipe displayById(@PathVariable("idEquipe") int idEquipe){
        return equipeService.retrieveEquipe(idEquipe);
    }

}
