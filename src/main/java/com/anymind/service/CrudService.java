package com.anymind.service;

import org.springframework.stereotype.Service;

import java.util.Set;


public interface CrudService<T, Id>{

    Set<T> findAll();

    T findById(Id Id);

    T save(T object);

    void delete(T object);

    void deleteById(Id id);
}
