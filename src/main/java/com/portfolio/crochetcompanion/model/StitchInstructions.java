package com.portfolio.crochetcompanion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="stitch_instructions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StitchInstructions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructionsId;

    @ManyToOne()
    @JoinColumn(name="crochet_stitch_id")
    private CrochetStitch crochetStitch;

    @Column(name="row")
    private String row;

    @Column(name = "line_number")
    private Integer lineNumber;


}
