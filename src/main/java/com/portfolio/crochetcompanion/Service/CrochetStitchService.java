package com.portfolio.crochetcompanion.Service;

import com.portfolio.crochetcompanion.Model.CrochetStitch;
import com.portfolio.crochetcompanion.Repository.CrochetStitchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CrochetStitchService {

    CrochetStitchRepository stitchRepository;

    public CrochetStitch getCrochetStitch(int crochetStitchId) {
        Optional<CrochetStitch> stitch = stitchRepository.findStitchById(crochetStitchId);
        if (stitch.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Crochet Stitch not found.");
        }
        return stitch.get();
    }

    public List<CrochetStitch> getAllStitches() {
        return stitchRepository.findAll();
    }

    public List<CrochetStitch> getStitchesByName(String name) {
        return stitchRepository.findStitchByName(name);
    }

    public List<CrochetStitch> getStitchesByAbbreviation(String abbreviation) {
        return stitchRepository.findStitchByAbbreviation(abbreviation);
    }


}
