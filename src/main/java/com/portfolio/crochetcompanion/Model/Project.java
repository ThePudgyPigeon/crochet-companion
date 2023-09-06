package com.portfolio.crochetcompanion.Model;

import java.util.List;

public class Project {

    private int projectId;
    private List<CrochetStitch> crochetStitches;
    private String projectName;

    public Project() {}

    public Project(int projectId, List<CrochetStitch> crochetStitches, String projectName) {
        this.projectId = projectId;
        this.crochetStitches = crochetStitches;
        this.projectName = projectName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public List<CrochetStitch> getCrochetStitches() {
        return crochetStitches;
    }

    public void setCrochetStitches(List<CrochetStitch> crochetStitches) {
        this.crochetStitches = crochetStitches;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", crochetStitches=" + crochetStitches +
                ", projectName='" + projectName + '\'' +
                '}';
    }

}


