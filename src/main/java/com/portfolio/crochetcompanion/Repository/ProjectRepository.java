package com.portfolio.crochetcompanion.Repository;

import com.portfolio.crochetcompanion.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    //Optional<Project> findProjectById(int id);

    //find projects for user

    //create project for user

    //update project for user

    //delete project for user

}
