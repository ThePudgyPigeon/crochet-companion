package com.portfolio.crochetcompanion.Controller;

import com.portfolio.crochetcompanion.Dao.CrochetStitchDao;
import com.portfolio.crochetcompanion.Model.CrochetStitch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crochetstitches")
public class CrochetStitchController {

    private CrochetStitchDao stitchDao;

    public  CrochetStitchController(CrochetStitchDao stitchDao) {
        this.stitchDao = stitchDao;
    }

    @GetMapping
    public List<CrochetStitch> list(@RequestParam(defaultValue = "") String name,
                                    @RequestParam(defaultValue = "") String abbreviation) {
        if (!name.isEmpty() && !abbreviation.isEmpty()) {
            return stitchDao.getStitchesByAbbreviation(abbreviation);
        }
        if (!name.isEmpty()) {
            return stitchDao.getStitchesByName(name);
        }
        if (!abbreviation.isEmpty()) {
            return stitchDao.getStitchesByAbbreviation(abbreviation);
        }
        return stitchDao.getCrochetStitches();
    }

}
