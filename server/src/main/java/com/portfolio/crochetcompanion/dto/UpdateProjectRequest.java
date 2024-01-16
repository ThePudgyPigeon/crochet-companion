package com.portfolio.crochetcompanion.dto;

import com.portfolio.crochetcompanion.model.CrochetStitch;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProjectRequest {
    @NotBlank
    private String name;

    @NotBlank
    private Set<CrochetStitch> stitches;
}
