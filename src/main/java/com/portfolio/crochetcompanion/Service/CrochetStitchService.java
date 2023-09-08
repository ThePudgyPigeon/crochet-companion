package com.portfolio.crochetcompanion.Service;

import com.portfolio.crochetcompanion.Dao.CrochetStitchDao;
import com.portfolio.crochetcompanion.Dao.StitchInstructionsDao;
import com.portfolio.crochetcompanion.Model.CrochetStitch;
import com.portfolio.crochetcompanion.Model.StitchInstructions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CrochetStitchService {

    @Autowired
    CrochetStitchDao crochetStitchDao;

    @Autowired
    StitchInstructionsDao instructionsDao;

    public CrochetStitch getCrochetStitch(int crochetStitchId) {
        CrochetStitch crochetStitch = crochetStitchDao.getStitchById(crochetStitchId);
        List<StitchInstructions> stitchInstructions = new ArrayList<>();
        instructionsDao.getStitchInstructions(crochetStitchId);
        crochetStitch.setStitchInstructions(stitchInstructions);

        return crochetStitch;
    }

}
