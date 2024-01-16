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
        return stitchRepository.findById(crochetStitchId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Crochet stitch does not exist."));
    }

    public List<CrochetStitch> getAllStitches(String name, String abbreviation) {
        if (!abbreviation.isEmpty()) {
            return stitchRepository.findStitchByStitchAbbreviation(abbreviation);
        } else if (!name.isEmpty()) {
            return stitchRepository.findStitchByStitchName(name);
        }
        return stitchRepository.findAll();
    }

}
