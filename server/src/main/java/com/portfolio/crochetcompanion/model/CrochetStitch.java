package com.portfolio.crochetcompanion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@Entity
@Table(name= "crochet_stitch")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrochetStitch {

    public CrochetStitch(Long id, String stitchName, String stitchAbbreviation) {
        this.id = id;
        this.stitchName = stitchName;
        this.stitchAbbreviation = stitchAbbreviation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stitch_name")
    private String stitchName;

    @Column(name = "stitch_description", length = 10000)
    @Size(min = 1, max = 10000)
    private String stitchDescription;

    @Column(name = "stitch_abbreviation")
    private String stitchAbbreviation;

    @JsonIgnoreProperties({"crochetStitch"})
    @OneToMany(mappedBy = "crochetStitch")
    private List<StitchInstructions> stitchInstructions;

}
