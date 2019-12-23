package com.firatulgay.Views.ListViews;

import com.firatulgay.Domain.BasRolOyuncu;
import com.firatulgay.Domain.Dizi;
import com.firatulgay.Domain.EnumTur;
import com.firatulgay.Domain.Film;
import com.firatulgay.Views.EkleView.DiziFilmEkle;
import com.firatulgay.dao.BasRolDao;
import com.firatulgay.dao.DiziFilmDao;
import com.firatulgay.utils.HibernateUtil;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by FiratUlgay on 21.12.2019.
 */
public class DiziFilmListView extends HorizontalLayout {

    private Table table;
    private IndexedContainer indexedContainer;
    private DiziFilmEkle diziFilmEkle;
    private boolean isFilm;

    public DiziFilmListView() {
        setSpacing(true);

        buildTableContainer();

        buildTable();
        addComponent(table);

        diziFilmEkle = new DiziFilmEkle();
        addComponent(diziFilmEkle);
    }

    public void fillTable() {

        if (isFilm) {

            DiziFilmDao diziFilmDao = new DiziFilmDao();
            BasRolDao basRolDao = new BasRolDao();
            List<Film> filmList = diziFilmDao.findAllFilm();

            for (Film film : filmList) {

                Item item = indexedContainer.addItem(film);

                item.getItemProperty("id").setValue(film.getId());
                item.getItemProperty("adi").setValue(film.getAdi());
                item.getItemProperty("enumTur").setValue(film.getEnumTur());
                item.getItemProperty("yapimYili").setValue(film.getYapimYili());
                item.getItemProperty("yonetmenAdi").setValue(film.getYonetmenAdi());

                if (film.getBasRolOyuncu() != null) {
                    BasRolOyuncu oyuncuById = basRolDao.findOyuncuById(film.getBasRolOyuncu().getId());

                    item.getItemProperty("basrol").setValue(oyuncuById);
                }
            }

        } else {

            DiziFilmDao diziFilmDao = new DiziFilmDao();
            BasRolDao basRolDao = new BasRolDao();
            List<Dizi> diziList = diziFilmDao.findAllDizi();

            for (Dizi dizi : diziList) {

                Item item = indexedContainer.addItem(dizi);

                item.getItemProperty("id").setValue(dizi.getId());
                item.getItemProperty("adi").setValue(dizi.getAdi());
                item.getItemProperty("enumTur").setValue(dizi.getEnumTur());
                item.getItemProperty("yapimYili").setValue(dizi.getYapimYili());
                item.getItemProperty("yonetmenAdi").setValue(dizi.getYonetmenAdi());
                if (dizi.getBasRolOyuncu() != null) {
                    BasRolOyuncu oyuncuById = basRolDao.findOyuncuById(dizi.getBasRolOyuncu().getId());
                    item.getItemProperty("basrol").setValue(oyuncuById);
                }
            }
        }
    }

    private void buildTableContainer() {

        indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("id", Long.class, null);
        indexedContainer.addContainerProperty("adi", String.class, null);
        indexedContainer.addContainerProperty("enumTur", EnumTur.class, null);
        indexedContainer.addContainerProperty("yapimYili", String.class, null);
        indexedContainer.addContainerProperty("yonetmenAdi", String.class, null);
        indexedContainer.addContainerProperty("basrol", BasRolOyuncu.class, null);
    }

    private void buildTable() {
        table = new Table();
        table.setContainerDataSource(indexedContainer);
        table.setColumnHeaders("ID", "ADI", "TÜRÜ", "YAPIM YILI", "YÖNETMEN ADI", "BASROL");
        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);
        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent ıtemClickEvent) {

                if (isFilm) {

                    Film film = (Film) ıtemClickEvent.getItemId();
                    diziFilmEkle.fillFilmView(film);
                    diziFilmEkle.setIsFilm(true);
                } else {
                    Dizi dizi = (Dizi) ıtemClickEvent.getItemId();
                    diziFilmEkle.fillDiziView(dizi);
                    diziFilmEkle.setIsFilm(false);

                }
            }
        });
    }

    public boolean isFilm() {
        return isFilm;
    }

    public void setIsFilm(boolean isFilm) {
        this.isFilm = isFilm;
    }

}
