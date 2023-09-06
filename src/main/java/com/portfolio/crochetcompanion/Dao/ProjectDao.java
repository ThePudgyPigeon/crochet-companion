package com.portfolio.crochetcompanion.Dao;

import com.portfolio.crochetcompanion.Model.Project;

import java.util.List;

public interface ProjectDao {

    Project getProjectById(int id);

    List<Project> getProjects();

    Project createProject(Project project);

    void updateProject(Project project);

    void deleteProjectById(int id);





}
