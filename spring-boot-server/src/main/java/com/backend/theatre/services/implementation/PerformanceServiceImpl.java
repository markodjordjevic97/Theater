package com.backend.theatre.services.implementation;

import com.backend.theatre.models.Performance;
import com.backend.theatre.repository.PerformanceRepository;
import com.backend.theatre.services.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    @Override
    public Performance savePerformance(Performance performance) {
        return performanceRepository.save(performance);
    }

    @Override
    public Page<Performance> getAllPerformance(int pageNumber, int pageSize, Sort.Direction order) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(order, "id"));
        return performanceRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Performance> getById(Long id) {
        return performanceRepository.findById(id);
    }

    @Override
    public Performance updatePerformance(Performance performance) {
        return performanceRepository.save(performance);
    }

    @Override
    public void deletePerformance(Long id) {
        performanceRepository.deleteById(id);
    }

    @Override
    public List<Performance> getAll() {
        return performanceRepository.findAll();
    }
}
