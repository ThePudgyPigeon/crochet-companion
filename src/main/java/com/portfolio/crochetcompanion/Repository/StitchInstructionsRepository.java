package com.portfolio.crochetcompanion.Repository;

import com.portfolio.crochetcompanion.Model.StitchInstructions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StitchInstructionsRepository extends JpaRepository<StitchInstructions, Integer> {

    List<StitchInstructions> findStitchInstructionsByCrochetStitchId(int crochetStitchId);

}
