package com.firatulgay.Domain;

import javax.persistence.*;

/**
 * Created by FiratUlgay on 20.12.2019.
 */
@Entity
@Table(name = "BASROLOYUNCU")
public class BasRolOyuncu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 50)
    private String adi;

    @Column (length = 10)
    private int yas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }
}
