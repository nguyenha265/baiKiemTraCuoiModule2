package com.codegym.model;

import javax.persistence.*;


@Entity
@Table(name = "thanhPho")
public class ThanhPho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tenThanhPho;
    private String dienTich;
    private String danSo;
    private String gdp;
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "quocGia_id")
    private QuocGia quocGia;

    public QuocGia getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(QuocGia quocGia) {
        this.quocGia = quocGia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }

    public String getDienTich() {
        return dienTich;
    }

    public void setDienTich(String dienTich) {
        this.dienTich = dienTich;
    }

    public String getDanSo() {
        return danSo;
    }

    public void setDanSo(String danSo) {
        this.danSo = danSo;
    }

    public String getGdp() {
        return gdp;
    }

    public void setGdp(String gdp) {
        this.gdp = gdp;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public ThanhPho(String tenThanhPho, String dienTich, String danSo, String gdp, String moTa) {
        this.tenThanhPho = tenThanhPho;
        this.dienTich = dienTich;
        this.danSo = danSo;
        this.gdp = gdp;
        this.moTa = moTa;
    }

    public ThanhPho() {
    }
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    public User getUsers() {
//        return user;
//    }
//
//    public void setUsers(User user) {
//        this.user = user;
//    }


}