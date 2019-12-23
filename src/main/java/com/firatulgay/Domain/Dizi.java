package com.firatulgay.Domain;

import javax.persistence.*;

/**
 * Created by FiratUlgay on 20.12.2019.
 */
@Entity
@Table(name="DIZI")
public class Dizi {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column (length = 50)
    private String adi;

    @Column (length = 50)
    private String yapimYili;

    @Column (length = 50)
    private String yonetmenAdi;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private EnumTur enumTur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BASROL", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "DIZI_BASROL_ID"))
    private BasRolOyuncu basRolOyuncu;

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

    public String getYapimYili() {
        return yapimYili;
    }

    public void setYapimYili(String yapimYili) {
        this.yapimYili = yapimYili;
    }

    public String getYonetmenAdi() {
        return yonetmenAdi;
    }

    public void setYonetmenAdi(String yonetmenAdi) {
        this.yonetmenAdi = yonetmenAdi;
    }

    public EnumTur getEnumTur() {
        return enumTur;
    }

    public void setEnumTur(EnumTur enumTur) {
        this.enumTur = enumTur;
    }

    public BasRolOyuncu getBasRolOyuncu() {
        return basRolOyuncu;
    }

    public void setBasRolOyuncu(BasRolOyuncu basRolOyuncu) {
        this.basRolOyuncu = basRolOyuncu;
    }

}
