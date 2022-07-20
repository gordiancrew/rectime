package com.kazantsev.rectime.repo;

import com.kazantsev.rectime.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Clients,Integer> {
    Clients findByUsername(String login);
}
