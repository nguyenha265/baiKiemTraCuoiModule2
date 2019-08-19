package com.codegym.service.impl;

import com.codegym.model.QuocGia;
import com.codegym.repository.QuocGiaRepository;
import com.codegym.service.QuocGiaService;
import org.springframework.beans.factory.annotation.Autowired;

public class QuocGiaServiceImpl implements QuocGiaService {
    @Autowired
    private QuocGiaRepository quocGiaRepository;

    @Override
    public Iterable<QuocGia> findAll() {
        return quocGiaRepository.findAll();
    }

}
