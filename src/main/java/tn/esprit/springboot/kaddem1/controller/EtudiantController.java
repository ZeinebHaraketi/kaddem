package tn.esprit.springboot.kaddem1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.kaddem1.entity.Etudiant;
import tn.esprit.springboot.kaddem1.services.EtudiantService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("etudiant")
public class EtudiantController {

    @Autowired
    EtudiantService etudiantService;


    @GetMapping("allEt")
    private List<Etudiant> allEtudiants(){
        return etudiantService.retrieveAllEtudiants();
    }

    @PostMapping("addEt")
    @ResponseBody
    public void ajoutEtudiant(@RequestBody Etudiant e){
        etudiantService.ajoutEtudiant(e);
    }


    @DeleteMapping("/suppEt/{idEtudiant}")
    @ResponseBody
    public void supprimerEtudiant(@PathVariable("idEtudiant") long idEtudiant){
        etudiantService.removeEtudiant(idEtudiant);
    }

    @PutMapping("/modifEt")
    private Etudiant modifierEtudiant(@RequestBody Etudiant e){
        return etudiantService.updateEtudiant(e);
    }

    @GetMapping("allEt/{idEtudiant}")
    private Etudiant displayById(@PathVariable("idEtudiant")int idEtudiant){
        return etudiantService.retrieveEtudiant(idEtudiant);
    }
}
