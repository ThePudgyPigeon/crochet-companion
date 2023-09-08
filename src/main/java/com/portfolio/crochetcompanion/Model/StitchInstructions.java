package com.portfolio.crochetcompanion.Model;

public class StitchInstructions {

    private Integer instructionsId;
    private Integer crochetStitchId;
    private String text;
    private Integer lineNumber;


    public StitchInstructions() {}

    public StitchInstructions(Integer instructionsId, Integer crochetStitchId, String text, Integer lineNumber) {
        this.instructionsId = instructionsId;
        this.crochetStitchId = crochetStitchId;
        this.text = text;
        this.lineNumber = lineNumber;
    }

    public Integer getInstructionsId() {
        return instructionsId;
    }

    public void setInstructionsId(Integer instructionsId) {
        this.instructionsId = instructionsId;
    }

    public Integer getCrochetStitchId() {
        return crochetStitchId;
    }

    public void setCrochetStitchId(Integer crochetStitchId) {
        this.crochetStitchId = crochetStitchId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
                ", text='" + text + '\'' +
                ", lineNumber=" + lineNumber +
                '}';
    }
}
