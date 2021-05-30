package com.backend.theatre.repository;

import com.backend.theatre.models.Performance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    public List<Performance> findAll();

    public Page<Performance> findAll(Pageable pageable);

    public void deleteById(Long aLong);

    public <S extends Performance> S save(S s);

    public Optional<Performance> findById(Long aLong);

}
