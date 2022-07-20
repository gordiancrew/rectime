package com.kazantsev.rectime.repo;

import com.kazantsev.rectime.models.Clients;
import com.kazantsev.rectime.models.Specialists;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends CrudRepository<Clients,Integer> {
}
