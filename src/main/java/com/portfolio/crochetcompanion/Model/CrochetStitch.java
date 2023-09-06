package com.portfolio.crochetcompanion.Model;

public class CrochetStitch {

    private int crochetStitchId;
    private String stitchName;
    private String stitchDescription;
    private String stitchAbbreviation;

    public CrochetStitch() {}

    public CrochetStitch(int crochetStitchId, String stitchName, String stitchDescription, String stitchAbbreviation) {
        this.crochetStitchId = crochetStitchId;
        this.stitchName = stitchName;
        this.stitchDescription = stitchDescription;
        this.stitchAbbreviation = stitchAbbreviation;
    }

    public int getCrochetStitchId() {
        return crochetStitchId;
    }

    public void setCrochetStitchId(int crochetStitchId) {
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
