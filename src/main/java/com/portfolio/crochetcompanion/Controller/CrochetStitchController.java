package com.portfolio.crochetcompanion.Controller;

import com.portfolio.crochetcompanion.Dao.CrochetStitchDao;
import com.portfolio.crochetcompanion.Dao.StitchInstructionsDao;
import com.portfolio.crochetcompanion.Model.CrochetStitch;
import com.portfolio.crochetcompanion.Model.StitchInstructions;
import com.portfolio.crochetcompanion.Service.CrochetStitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/crochet-stitches")
public class CrochetStitchController {

    @Autowired
    private CrochetStitchService stitchService;

    @GetMapping
    public List<CrochetStitch> list(@RequestParam(defaultValue = "") String name,
                                    @RequestParam(defaultValue = "") String abbreviation) {
        if (!name.isEmpty() && !abbreviation.isEmpty()) {
            return stitchService.getCrochetStitchesByAbbreviation(abbreviation);
        }
        if (!name.isEmpty()) {
            return stitchService.getCrochetStitchesByName(name);
        }
        if (!abbreviation.isEmpty()) {
            return stitchService.getCrochetStitchesByAbbreviation(abbreviation);
        }
        return stitchService.getCrochetStitches();
    }

    @GetMapping(path = "/{id}")
    public CrochetStitch get(@PathVariable int id) {
        CrochetStitch stitch = stitchService.getCrochetStitchById(id);
        if (stitch == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return stitch;
        }
    }

}
