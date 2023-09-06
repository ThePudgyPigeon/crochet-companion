package com.portfolio.crochetcompanion.Controller;

import com.portfolio.crochetcompanion.Dao.CrochetStitchDao;
import com.portfolio.crochetcompanion.Model.CrochetStitch;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping(path = "/{id}")
    public CrochetStitch get(@PathVariable int id) {
        CrochetStitch stitch = stitchDao.getStitchById(id);
        if (stitch == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return stitch;
        }
    }

}
