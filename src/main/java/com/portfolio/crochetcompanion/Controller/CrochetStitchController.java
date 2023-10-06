package com.portfolio.crochetcompanion.Controller;

import com.portfolio.crochetcompanion.Model.CrochetStitch;
import com.portfolio.crochetcompanion.Service.CrochetStitchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/crochet-stitches")
@RequiredArgsConstructor
public class CrochetStitchController {

    CrochetStitchService service;

    @GetMapping
    public List<CrochetStitch> list(@RequestParam(defaultValue = "") String name,
                                    @RequestParam(defaultValue = "") String abbreviation) {
        if (!name.isEmpty() && !abbreviation.isEmpty()) {
            return service.getStitchesByAbbreviation(abbreviation);
        } else if (!name.isEmpty()) {
            return service.getStitchesByName(name);
        } else if (!abbreviation.isEmpty()) {
            return service.getStitchesByAbbreviation(abbreviation);
        }
        return service.getAllStitches();
    }

    @GetMapping(path = "/id")
    public CrochetStitch get(@PathVariable int id) {
        CrochetStitch stitch = service.getCrochetStitch(id);
        if (stitch == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return stitch;
    }

}
