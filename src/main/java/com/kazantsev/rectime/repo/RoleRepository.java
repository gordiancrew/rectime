package com.kazantsev.rectime.repo;

import com.kazantsev.rectime.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
