package com.example.client;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; // JPQL is just an object-oriented way of defining queries based on entity attributes.

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("select p from Client p where concat(p.id, '', p.full_name, '', p.visit_date, '', p.service, '', p.master_name) like %?1%") // the concatted method parameter will be assigned to the query parameter with index 1.
    List<Client> search(String keyword);
}
