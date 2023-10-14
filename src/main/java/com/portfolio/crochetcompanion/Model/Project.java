package com.portfolio.crochetcompanion.model;

import com.portfolio.crochetcompanion.model.auth.User;
import jakarta.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(name = "project_name")
    private String projectName;

    @ManyToMany
    @JoinTable(name = "project_crochet_stitch", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "crochet_stitch_id"))
    private Set<CrochetStitch> crochetStitches;

}