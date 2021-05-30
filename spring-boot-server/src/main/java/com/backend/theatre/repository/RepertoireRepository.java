package com.backend.theatre.repository;

import com.backend.theatre.models.Repertoire;
import com.backend.theatre.models.RepertoirePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepertoireRepository extends JpaRepository<Repertoire, RepertoirePK> {
}
