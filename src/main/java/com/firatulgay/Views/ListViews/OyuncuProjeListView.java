package com.firatulgay.Views.ListViews;

import com.firatulgay.Domain.BasRolOyuncu;
import com.firatulgay.Domain.Dizi;
import com.firatulgay.Domain.EnumTur;
import com.firatulgay.Domain.Film;
import com.firatulgay.dao.BasRolDao;
import com.firatulgay.dao.DiziFilmDao;
import com.firatulgay.utils.HibernateUtil;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class OyuncuProjeListView extends HorizontalLayout {

    private ComboBox basrolComboBox;
    private Table table;
    private IndexedContainer indexedContainer;
    private FormLayout mainLayout;

    public OyuncuProjeListView() {

        mainLayout = new FormLayout();
        addComponent(mainLayout);

        setSpacing(true);
        buildMainLayout();
        buildTableContainer();
        buildTable();
    }
    public void fillTable() {

        table.removeAllItems();
        DiziFilmDao diziFilmDao = new DiziFilmDao();
        BasRolDao basRolDao = new BasRolDao();

        BasRolOyuncu basRolOyuncu = (BasRolOyuncu) basrolComboBox.getValue();
        List<Film> filmList = diziFilmDao.findAllFilmByOyuncuId(basRolOyuncu.getId());
        List<Dizi> diziList = diziFilmDao.findAllDiziByOyuncuId(basRolOyuncu.getId());

        for (Film film : filmList) {
            Item item = indexedContainer.addItem(film);

            BasRolOyuncu oyuncuById = basRolDao.findOyuncuById(film.getBasRolOyuncu().getId());
            item.getItemProperty("basrolAdi").setValue(oyuncuById.getAdi());
            item.getItemProperty("filmAdi").setValue(film.getAdi());
            item.getItemProperty("filmTuru").setValue(film.getEnumTur());
        }
        for (Dizi dizi : diziList) {
            Item item = indexedContainer.addItem(dizi);
            /**
             * Lazy hatası.
             */
            BasRolOyuncu oyuncuById = basRolDao.findOyuncuById(dizi.getBasRolOyuncu().getId());
            item.getItemProperty("basrolAdi").setValue(oyuncuById.getAdi());
            item.getItemProperty("diziAdi").setValue(dizi.getAdi());
            item.getItemProperty("diziTuru").setValue(dizi.getEnumTur());
        }
    }
    private void buildMainLayout() {

        basrolComboBox = new ComboBox("Başrol Oyuncusu");
        basrolComboBox.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                fillTable();
            }
        });
        mainLayout.addComponent(basrolComboBox);
        basrolComboBox();
    }
    private void buildTableContainer() {

        indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("basrolAdi", String.class, null);
        indexedContainer.addContainerProperty("filmAdi", String.class, null);
        indexedContainer.addContainerProperty("filmTuru", EnumTur.class, null);
        indexedContainer.addContainerProperty("diziAdi", String.class, null);
        indexedContainer.addContainerProperty("diziTuru", EnumTur.class, null);
    }
    private void buildTable() {
        table = new Table();
        table.setContainerDataSource(indexedContainer);
        table.setColumnHeaders("BAŞROL", "FİLM ADI", "FİLM TÜRÜ", "DİZİ ADI", "DİZİ TÜRÜ");
        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);
        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {
            }
        });
        addComponent(table);
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
}
