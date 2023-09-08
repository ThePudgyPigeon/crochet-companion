package com.portfolio.crochetcompanion.Dao;

import com.portfolio.crochetcompanion.Model.StitchInstructions;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StitchInstructionsDao {

    List<StitchInstructions> getStitchInstructions(int crochetStitchId);

}
