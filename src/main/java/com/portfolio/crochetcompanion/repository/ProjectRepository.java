package com.portfolio.crochetcompanion.repository;

import com.portfolio.crochetcompanion.model.Project;
import com.portfolio.crochetcompanion.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByUser(User user);
    boolean existsByProjectName(String projectName);

}
