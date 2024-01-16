package com.portfolio.crochetcompanion.dto;

import com.portfolio.crochetcompanion.model.CrochetStitch;
import com.portfolio.crochetcompanion.model.Project;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddStitchRequest {

    @NotBlank
    private CrochetStitch stitch;

    @NotBlank
    private Long projectId;
}
