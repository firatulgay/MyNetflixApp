package com.firatulgay.Views.EkleView;

import com.firatulgay.Buttons.MyTextField;
import com.firatulgay.Buttons.SaveButton;
import com.firatulgay.Domain.BasRolOyuncu;
import com.firatulgay.Domain.Dizi;
import com.firatulgay.Domain.EnumTur;
import com.firatulgay.Domain.Film;
import com.firatulgay.dao.BasRolDao;
import com.firatulgay.dao.DiziFilmDao;
import com.firatulgay.utils.HibernateUtil;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.VerticalLayout;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class DiziFilmEkle extends VerticalLayout {

    private MyTextField idField;
    private MyTextField adiField;
    private MyTextField yapimYiliField;
    private MyTextField yonetmenAdiField;
    private ComboBox turComboBox;
    private ComboBox basrolComboBox;
    private FormLayout mainLayout;

    DiziFilmDao diziFilmDao;
    private boolean isFilm;

    public DiziFilmEkle() {
        diziFilmDao = new DiziFilmDao();
        buildMainLayout();
    }

    private void buildMainLayout() {
        mainLayout = new FormLayout();
        addComponent(mainLayout);

        idField = new MyTextField("Id");
        idField.setEnabled(false);
        mainLayout.addComponent(idField);

        adiField = new MyTextField("Adı");
        mainLayout.addComponent(adiField);

        yapimYiliField = new MyTextField("Yapım Yılı");
        mainLayout.addComponent(yapimYiliField);

        yonetmenAdiField = new MyTextField("Yönetmen Adı");
        mainLayout.addComponent(yonetmenAdiField);

        turComboBox = new ComboBox("Tür");
        for (EnumTur enumTur : EnumTur.values()) {
            turComboBox.addItem(enumTur);
        }
        mainLayout.addComponent(turComboBox);

        basrolComboBox = new ComboBox("Başrol Oyuncusu");
        mainLayout.addComponent(basrolComboBox);
        basrolComboBox();

        SaveButton saveButton = new SaveButton();
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                SaveDiziFilm();
            }
        });
        mainLayout.addComponent(saveButton);
    }

    public void SaveDiziFilm() {

        Long idFieldValue = null;
        if (idField.getValue() != "") {
            idFieldValue = Long.parseLong(idField.getValue());
        }
        String adiFieldValue = adiField.getValue();
        String yapimYiliFieldValue = yapimYiliField.getValue();
        String yonetmenAdiFieldValue = yonetmenAdiField.getValue();
        EnumTur turComboValue = (EnumTur) turComboBox.getValue();
        BasRolOyuncu basRolOyuncu = (BasRolOyuncu) basrolComboBox.getValue();

        if (isFilm) {


            Film film = new Film();
            if (idFieldValue != null) {
                film.setId(idFieldValue);
            }
            film.setAdi(adiFieldValue);
            film.setYapimYili(yapimYiliFieldValue);
            film.setYonetmenAdi(yonetmenAdiFieldValue);
            film.setEnumTur(turComboValue);
            film.setBasRolOyuncu(basRolOyuncu);

            diziFilmDao.filmEkle(film);
        } else {
            Dizi dizi = new Dizi();
            if (idFieldValue != null) {
                dizi.setId(idFieldValue);
            }
            dizi.setAdi(adiFieldValue);
            dizi.setYapimYili(yapimYiliFieldValue);
            dizi.setYonetmenAdi(yonetmenAdiFieldValue);
            dizi.setEnumTur(turComboValue);
            dizi.setBasRolOyuncu(basRolOyuncu);
            diziFilmDao.diziEkle(dizi);
        }
    }

    public boolean isFilm() {
        return isFilm;
    }

    public void setIsFilm(boolean isFilm) {
        this.isFilm = isFilm;
    }

    private void basrolComboBox() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sessionEx = null;
        try (Session session = sessionFactory.openSession();) {
            sessionEx = session;
            Query query = sessionEx.createQuery("Select basrol From BasRolOyuncu basrol");
            List<BasRolOyuncu> basRolOyuncuList = query.list();

            for (BasRolOyuncu basRolOyuncu : basRolOyuncuList) {
                basrolComboBox.addItem(basRolOyuncu);
            }

        } catch (Exception ex) {
            sessionEx.getTransaction().rollback();
            System.out.println(ex.getMessage());
        }
    }

    public void fillFilmView(Film film) {

        BasRolDao basRolDao = new BasRolDao();

        idField.setValue(String.valueOf(film.getId()));
        adiField.setValue(film.getAdi());
        yapimYiliField.setValue(film.getYapimYili());
        yonetmenAdiField.setValue(film.getYonetmenAdi());
        turComboBox.setValue(film.getEnumTur());
        if (film.getBasRolOyuncu() != null) {
            BasRolOyuncu oyuncuById = basRolDao.findOyuncuById(film.getBasRolOyuncu().getId());
            basrolComboBox.setValue(oyuncuById);

        }
    }
    public void fillDiziView(Dizi dizi) {

        BasRolDao basRolDao = new BasRolDao();
        idField.setValue(String.valueOf(dizi.getId()));
        adiField.setValue(dizi.getAdi());
        yapimYiliField.setValue(dizi.getYapimYili());
        yonetmenAdiField.setValue(dizi.getYonetmenAdi());
        turComboBox.setValue(dizi.getEnumTur());
        if (dizi.getBasRolOyuncu() != null){
            BasRolOyuncu oyuncuById = basRolDao.findOyuncuById(dizi.getBasRolOyuncu().getId());
            basrolComboBox.setValue(oyuncuById);
        }

    }
}
