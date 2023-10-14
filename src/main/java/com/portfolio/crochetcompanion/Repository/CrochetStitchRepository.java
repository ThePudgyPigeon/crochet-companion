package com.portfolio.crochetcompanion.repository;

import com.portfolio.crochetcompanion.model.CrochetStitch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrochetStitchRepository extends JpaRepository<CrochetStitch, Long> {

    List<CrochetStitch> findStitchByStitchName(String name);

    List<CrochetStitch> findStitchByStitchAbbreviation(String abbreviation);

}
