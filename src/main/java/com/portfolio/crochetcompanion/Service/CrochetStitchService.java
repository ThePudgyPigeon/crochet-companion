package com.portfolio.crochetcompanion.service;

import com.portfolio.crochetcompanion.model.CrochetStitch;
import com.portfolio.crochetcompanion.repository.CrochetStitchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CrochetStitchService {

    @Autowired
    CrochetStitchRepository stitchRepository;

    public CrochetStitch getCrochetStitch(Long crochetStitchId) {
        Optional<CrochetStitch> stitch = stitchRepository.findById(crochetStitchId);
        if (stitch.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Crochet Stitch not found.");
        }
        return stitch.get();
    }

    public List<CrochetStitch> getAllStitches() {
        return stitchRepository.findAll();
    }

    public List<CrochetStitch> getStitchesByName(String name) {
        return stitchRepository.findStitchByStitchName(name);
    }

    public List<CrochetStitch> getStitchesByAbbreviation(String abbreviation) {
        return stitchRepository.findStitchByStitchAbbreviation(abbreviation);
    }

    public CrochetStitch createStitch(CrochetStitch crochetStitch) {
        return stitchRepository.save(crochetStitch);
    }

    public CrochetStitch updateStitch(Long stitchId, CrochetStitch crochetStitch) {
        Optional<CrochetStitch> optCrochetStitch = stitchRepository.findById(stitchId);
        if (optCrochetStitch.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Crochet Stitch not found.");
        }

        CrochetStitch existingStitch = optCrochetStitch.get();
        existingStitch.setStitchAbbreviation(crochetStitch.getStitchAbbreviation());
        existingStitch.setStitchDescription(crochetStitch.getStitchDescription());
        existingStitch.setStitchInstructions(crochetStitch.getStitchInstructions());

        return stitchRepository.save(existingStitch);
    }

    public void deleteStitch(Long stitchId) {
        Optional<CrochetStitch> optStitch = stitchRepository.findById(stitchId);
        if (optStitch.isEmpty()) return;

        stitchRepository.deleteById(stitchId);
    }

}
