package com.portfolio.crochetcompanion.controller;

import com.portfolio.crochetcompanion.model.CrochetStitch;
import com.portfolio.crochetcompanion.model.Project;
import com.portfolio.crochetcompanion.service.CrochetStitchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/crochet-stitches")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class CrochetStitchController {

    @Autowired
    CrochetStitchService service;

    @GetMapping
    public List<CrochetStitch> list(@RequestParam(defaultValue = "") String name,
                                    @RequestParam(defaultValue = "") String abbreviation) {
        return service.getAllStitches(name, abbreviation);
    }

    @GetMapping(path = "/{id}")
    public CrochetStitch get(@PathVariable Long id) {
        return service.getCrochetStitch(id);
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(value = HttpStatus.CREATED)
    public CrochetStitch createStitch(@RequestBody CrochetStitch stitch) {
        return service.createStitch(stitch);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public CrochetStitch updateStitch(@RequestBody CrochetStitch newStitch, @PathVariable Long id) {
        return service.updateStitch(id, newStitch);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteStitch(@PathVariable Long id) {

    }

}
