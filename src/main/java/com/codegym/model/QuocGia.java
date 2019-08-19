package com.codegym.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quocgia")
public class QuocGia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(targetEntity = QuocGia.class)
    private List<ThanhPho> thanhPho;

    public QuocGia() {
    }

    public QuocGia(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ThanhPho> getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(List<ThanhPho> thanhPho) {
        this.thanhPho = thanhPho;
    }
}
