package com.portfolio.crochetcompanion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.portfolio.crochetcompanion.model.auth.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    public Project(Long projectId, String projectName, User user) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;


    @Column(name = "project_name")
    @NotBlank
    private String projectName;

    @ManyToMany
    @JoinTable(name = "project_crochet_stitch", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "crochet_stitch_id"))
    private Set<CrochetStitch> crochetStitches;

    @ManyToOne
    @JsonIgnoreProperties({"projects"})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}