package com.portfolio.crochetcompanion.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@Entity
@Table(name= "crochet_stitch")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrochetStitch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stitch_name")
    private String stitchName;

    @Column(name = "stitch_description", columnDefinition = "TEXT")
    private String stitchDescription;

    @Column(name = "stitch_abbreviation")
    private String stitchAbbreviation;

    @OneToMany(mappedBy = "crochetStitch")
    private List<StitchInstructions> stitchInstructions;

}
