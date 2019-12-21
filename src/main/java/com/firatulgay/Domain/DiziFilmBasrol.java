package com.firatulgay.Domain;

import javax.persistence.*;

/**
 * Created by FiratUlgay on 21.12.2019.
 */
@Entity
@Table(name = "DIZI_FILM_BASROL")
public class DiziFilmBasrol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BASROL", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "DIZI_FILM_BASROL_BASROL"))
    BasRolOyuncu basRolOyuncu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DIZI", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "DIZI_FILM_BASROL_DIZI"))
    Dizi dizi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FILM", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "DIZI_FILM_BASROL_FILM"))
    Film film;



}
