package com.portfolio.crochetcompanion.Model;

import java.util.List;

public class CrochetStitch {

    private Integer crochetStitchId;
    private String stitchName;
    private String stitchDescription;
    private String stitchAbbreviation;
    private List<StitchInstructions> stitchInstructions;

    public CrochetStitch() {}

    public CrochetStitch(Integer crochetStitchId, String stitchName, String stitchDescription, String stitchAbbreviation) {
        this.crochetStitchId = crochetStitchId;
        this.stitchName = stitchName;
        this.stitchDescription = stitchDescription;
        this.stitchAbbreviation = stitchAbbreviation;
    }

    public Integer getCrochetStitchId() {
        return crochetStitchId;
    }

    public void setCrochetStitchId(Integer crochetStitchId) {
        this.crochetStitchId = crochetStitchId;
    }

    public String getStitchName() {
        return stitchName;
    }

    public void setStitchName(String stitchName) {
        this.stitchName = stitchName;
    }

    public String getStitchDescription() {
        return stitchDescription;
    }

    public void setStitchDescription(String stitchDescription) {
        this.stitchDescription = stitchDescription;
    }

    public String getStitchAbbreviation() {
        return stitchAbbreviation;
    }

    public void setStitchAbbreviation(String stitchAbbreviation) {
        this.stitchAbbreviation = stitchAbbreviation;
    }

    public List<StitchInstructions> getStitchInstructions() {
        return stitchInstructions;
    }

    public void setStitchInstructions(List<StitchInstructions> stitchInstructions) {
        this.stitchInstructions = stitchInstructions;
    }

    @Override
    public String toString() {
        return "CrochetStitch{" +
                "crochetStitchId=" + crochetStitchId +
                ", stitchName='" + stitchName + '\'' +
                ", stitchDescription='" + stitchDescription + '\'' +
                ", stitchAbbreviation='" + stitchAbbreviation + '\'' +
                '}';
    }

}
