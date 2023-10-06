package com.portfolio.crochetcompanion.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name= "crochet_stitch")
@Data
//data is a shortcut annotation through lombok that generates the boilerplate of getters, setters, tostring, and equalshashcode
@NoArgsConstructor
@AllArgsConstructor
public class CrochetStitch {

    @Id
    @GeneratedValue
    private Integer crochetStitchId;

    @Column(name = "stitch_name")
    private String stitchName;

    @Column(name = "stitch_description")
    private String stitchDescription;

    @Column(name = "stitch_abbreviation")
    private String stitchAbbreviation;

    @OneToMany(mappedBy = "crochetStitch")
    private List<StitchInstructions> stitchInstructions;

}
