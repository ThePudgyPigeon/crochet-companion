package com.portfolio.crochetcompanion.Model;

public class StitchInstructions {

    private Integer instructionsId;
    private Integer crochetStitchId;
    private String row;
    private Integer lineNumber;


    public StitchInstructions() {}

    public StitchInstructions(Integer instructionsId, Integer crochetStitchId, String row, Integer lineNumber) {
        this.instructionsId = instructionsId;
        this.crochetStitchId = crochetStitchId;
        this.row = row;
        this.lineNumber = lineNumber;
    }

    public void setInstructionsId(Integer instructionsId) {
        this.instructionsId = instructionsId;
    }

    public void setCrochetStitchId(Integer crochetStitchId) {
        this.crochetStitchId = crochetStitchId;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "StitchInstructions{" +
                "instructionsId=" + instructionsId +
                ", crochetStitchId=" + crochetStitchId +
                ", row='" + row + '\'' +
                ", lineNumber=" + lineNumber +
                '}';
    }
}
