package com.backend.theatre.repository;

import com.backend.theatre.models.Writer;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class Test implements JpaRepository<Writer, Long> {
    @Override
    public List<Writer> findAll() {
        return null;
    }

    @Override
    public List<Writer> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Writer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Writer> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Writer writer) {

    }

    @Override
    public void deleteAll(Iterable<? extends Writer> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Writer> S save(S s) {
        return null;
    }

    @Override
    public <S extends Writer> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Writer> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Writer> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Writer> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Writer getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Writer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Writer> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Writer> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Writer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Writer> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Writer> boolean exists(Example<S> example) {
        return false;
    }
}
