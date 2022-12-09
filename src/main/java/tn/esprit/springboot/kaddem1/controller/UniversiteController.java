package tn.esprit.springboot.kaddem1.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.kaddem1.entity.Universite;
import tn.esprit.springboot.kaddem1.services.UniversiteService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/universite")
public class UniversiteController {

    @Autowired
    UniversiteService universiteService;

    @GetMapping("/univ")
    private List<Universite> allUni(){
        return universiteService.retrieveAllUniversites();
    }

    @PostMapping("/univ")
    @ResponseBody
    public void ajoutUniveriste(@RequestBody Universite u){
        universiteService.ajoutUniversite(u);
    }

    @PutMapping("/update")
    private Universite modifierUni(@RequestBody Universite u){
        return universiteService.updateUniversite(u);
    }

    @GetMapping("/univ/{idUniv}")
    private Universite displayById(@PathVariable("idUniv") int idUniv){
        return universiteService.retrieveUniversite(idUniv);
    }


    @DeleteMapping("/remove/{idUniv}")
    public void removeUniv(@PathVariable("idUniv") long id){
        universiteService.removeUniversite(id);
    }


}
