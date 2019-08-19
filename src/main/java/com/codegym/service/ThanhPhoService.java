package com.codegym.service;

import com.codegym.model.ThanhPho;

public interface ThanhPhoService {
    Iterable<ThanhPho> findAll();

    ThanhPho findById(Long id);

    void save(ThanhPho thanhPho);

    void delete(Long id);
}
