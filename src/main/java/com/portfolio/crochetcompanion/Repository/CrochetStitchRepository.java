package com.portfolio.crochetcompanion.Repository;

import com.portfolio.crochetcompanion.Model.CrochetStitch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CrochetStitchRepository extends JpaRepository<CrochetStitch, Integer> {

    Optional<CrochetStitch> findStitchById(int id);

    List<CrochetStitch> findStitchByName(String name);

    List<CrochetStitch> findStitchByAbbreviation(String abbreviation);

}
