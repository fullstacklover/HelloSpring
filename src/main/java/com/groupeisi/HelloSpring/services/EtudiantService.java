package com.groupeisi.HelloSpring.services;

import com.groupeisi.HelloSpring.entities.Etudiant;
import com.groupeisi.HelloSpring.repositories.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    private final EtudiantRepository repository;

    public EtudiantService(EtudiantRepository repository) {
        this.repository = repository;
    }

    public List<Etudiant> getAll() {
        return repository.findAll();
    }

    public Optional<Etudiant> getById(Long id) {
        return repository.findById(id);
    }

    public Etudiant save(Etudiant etudiant) {
        return repository.save(etudiant);
    }

    public Etudiant update(Long id, Etudiant etudiant) {

        Optional<Etudiant> result = repository.findById(id);

        if (result.isPresent()) {

            Etudiant existing = result.get();

            existing.setNom(etudiant.getNom());
            existing.setPrenom(etudiant.getPrenom());
            existing.setEmail(etudiant.getEmail());
            existing.setTelephone(etudiant.getTelephone());
            existing.setFormation(etudiant.getFormation());

            return repository.save(existing);
        }

        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}