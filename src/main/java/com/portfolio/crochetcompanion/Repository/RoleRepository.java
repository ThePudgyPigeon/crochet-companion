package com.portfolio.crochetcompanion.Repository;

import com.portfolio.crochetcompanion.Model.Authorization.ERole;
import com.portfolio.crochetcompanion.Model.Authorization.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(ERole name);
}
