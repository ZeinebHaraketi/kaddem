package tn.esprit.springboot.kaddem1.services;

import tn.esprit.springboot.kaddem1.entity.Universite;

import java.util.List;

public interface IUniversiteService {

    List<Universite> retrieveAllUniversites();

    Universite addUniversite (Universite u);

    Universite updateUniversite (Universite u);

    Universite retrieveUniversite (Integer idUniversite);
}
