package tn.esprit.springboot.kaddem1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.kaddem1.entity.Departement;
import tn.esprit.springboot.kaddem1.services.DepartementService;

import java.util.List;

@RestController
@RequestMapping("/departement")
public class DepartementController {

    @Autowired
    DepartementService departementService;

    @GetMapping("/allD")
    private List<Departement> allDepartements(){
        return departementService.retrieveAllDepartements();
    }

    @PostMapping("/addD")
    @ResponseBody
    public void ajoutDepartement(@RequestBody Departement d){
        departementService.ajoutDepartement(d);
    }

    @DeleteMapping ("/sppD/{idDepart}")
    @ResponseBody
    public void supprimerContrat(@PathVariable("idDepart") Long idDepart){
        departementService.removeDepart(idDepart);
    }

    @PutMapping("/modifD")
    private Departement modifierDepartement(@RequestBody Departement d){
       return departementService.updateDepartement(d);
    }

    @PutMapping("/assign/{idDep}/{idEtud}")
    public void assignDepartementToStudent(@PathVariable("idDepart") long idDepart,@PathVariable("idEtud") long idEtud){
        departementService.assignEtudiantToDepartement(idDepart,idEtud);
    }

    @GetMapping("/findDepartmentsByUniversite/{idUniv}")
    public List<Departement> findDepartmentsByidUniv(@PathVariable("idUniv") Integer idUniv){
        return departementService.retrieveDepartementsByUniversite(idUniv);
    }

}
