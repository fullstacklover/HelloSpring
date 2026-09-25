package com.groupeisi.HelloSpring.services;

import com.groupeisi.HelloSpring.entities.Stage;
import com.groupeisi.HelloSpring.repositories.StageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StageService {

    private final StageRepository repository;

    public StageService(StageRepository repository) {
        this.repository = repository;
    }

    public List<Stage> getAll() {
        return repository.findAll();
    }

    public Optional<Stage> getById(Long id) {
        return repository.findById(id);
    }

    public Stage save(Stage stage) {
        return repository.save(stage);
    }

    public Stage update(Long id, Stage stage) {

        Optional<Stage> result = repository.findById(id);

        if (result.isPresent()) {

            Stage existing = result.get();

            existing.setTitre(stage.getTitre());
            existing.setDescription(stage.getDescription());
            existing.setDateDebut(stage.getDateDebut());
            existing.setDateFin(stage.getDateFin());
            existing.setEtudiant(stage.getEtudiant());
            existing.setEntreprise(stage.getEntreprise());

            return repository.save(existing);
        }

        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}