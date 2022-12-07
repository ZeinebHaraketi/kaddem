package tn.esprit.springboot.kaddem1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.kaddem1.entity.Universite;
import tn.esprit.springboot.kaddem1.services.UniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteController {

    @Autowired
    UniversiteService universiteService;

    @GetMapping("/allU")
    private List<Universite> allUni(){
        return universiteService.retrieveAllUniversites();
    }

    @PostMapping("/addU")
    @ResponseBody
    public void ajoutUniveriste(@RequestBody Universite u){
        universiteService.ajoutUniversite(u);
    }

    @PutMapping("/modifU")
    private Universite modifierUni(@RequestBody Universite u){
        return universiteService.updateUniversite(u);
    }

    @GetMapping("/allU/{idUniv}")
    private Universite displayById(@PathVariable("idUniv") int idUniv){
        return universiteService.retrieveUniversite(idUniv);
    }
    @PutMapping("/assign/{idUniversite}/{idDepartement}")
    public void assignUniversityToDepartment(@PathVariable("idUniversite") Integer idUniversite,@PathVariable("idDepartement") Integer idDepartement){
        universiteService.assignUniversiteToDepartement(idUniversite,idDepartement);
    }



    }
