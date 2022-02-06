package com.anymind.service;

import org.springframework.context.annotation.Bean;

import java.util.Set;


public interface CRUDService<T, ID> {

    Set<T> findAll();

    T findById(ID Id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
