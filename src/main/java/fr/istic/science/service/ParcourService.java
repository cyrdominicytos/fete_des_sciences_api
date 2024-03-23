package fr.istic.science.service;

import fr.istic.science.exception.ResourceNotFoundException;
import fr.istic.science.model.Parcour;
import fr.istic.science.model.Tag;
import fr.istic.science.repository.ParcourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcourService {

    @Autowired
    private ParcourRepository parcourRepository;

    public Parcour createParcour(Parcour parcour) {
        return parcourRepository.save(parcour);
    }

    public Parcour getParcourById(Long parcourId) {
        return parcourRepository.findById(parcourId)
                .orElseThrow(() -> new ResourceNotFoundException("Parcour", "id", parcourId));
    }

    public List<Parcour> getParcours() {
        return parcourRepository.findAll();
    }

    public Parcour updateParcour(Long parcourId, Parcour parcourDetails) {
        Parcour parcour = parcourRepository.findById(parcourId)
                .orElseThrow(() -> new ResourceNotFoundException("Parcour", "id", parcourId));

        parcour.setTitle(parcourDetails.getTitle());
        parcour.setDescription(parcourDetails.getDescription());

        return parcourRepository.save(parcour);
    }

    public void deleteParcour(Long parcourId) {
        parcourRepository.deleteById(parcourId);
    }

}

