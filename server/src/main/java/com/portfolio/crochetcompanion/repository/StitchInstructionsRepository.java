package com.portfolio.crochetcompanion.repository;

import com.portfolio.crochetcompanion.model.StitchInstructions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StitchInstructionsRepository extends JpaRepository<StitchInstructions, Long> {

}
