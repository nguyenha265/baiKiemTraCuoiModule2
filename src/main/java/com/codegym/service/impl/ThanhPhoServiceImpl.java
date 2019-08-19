package com.codegym.service.impl;

import com.codegym.model.ThanhPho;
import com.codegym.repository.ThanhPhoRepository;
import com.codegym.service.ThanhPhoService;
import org.springframework.beans.factory.annotation.Autowired;

public class ThanhPhoServiceImpl implements ThanhPhoService {
    @Autowired
    ThanhPhoRepository thanhPhoRepository;


    @Override
    public Iterable<ThanhPho> findAll() {
        return thanhPhoRepository.findAll();
    }

    @Override
    public ThanhPho findById(Long id) {
        return thanhPhoRepository.findOne(id);
    }

    @Override
    public void save(ThanhPho thanhPho) {
        thanhPhoRepository.save(thanhPho);
    }

    @Override
    public void delete(Long id) {
        thanhPhoRepository.delete(id);
    }
}
