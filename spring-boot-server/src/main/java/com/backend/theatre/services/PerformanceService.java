package com.backend.theatre.services;

import com.backend.theatre.models.Performance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface PerformanceService {

    public Performance savePerformance(Performance performance);

    public Page<Performance> getAllPerformance(int pageNumber, int pageSize, Sort.Direction order);

    public Optional<Performance> getById(Long id);

    public Performance updatePerformance(Performance performance);

    public void deletePerformance(Long id);

    public List<Performance> getAll();
}
