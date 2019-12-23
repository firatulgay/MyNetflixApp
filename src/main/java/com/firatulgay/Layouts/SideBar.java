package com.firatulgay.Layouts;

import com.firatulgay.Buttons.SideBarButton;
import com.firatulgay.Views.EkleView.DiziFilmEkle;
import com.firatulgay.Views.EkleView.OyuncuEkleView;
import com.firatulgay.Views.ListViews.DiziFilmListView;
import com.firatulgay.Views.ListViews.OyuncuProjeListView;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class SideBar extends VerticalLayout {

    private Header header;
    private Content content;

    private SideBarButton btnFilmEkle;
    private SideBarButton btnDiziEkle;
    private SideBarButton btnBasrolEkle;
    private SideBarButton btnBasrolProjeListele;
    private SideBarButton btnDiziListele;
    private SideBarButton btnFilmListele;


    public SideBar(Header header, Content content) {

        comoponentOlustur();
        listenerOlustur();

        this.header = header;
        this.content = content;

        setSpacing(true);
        setMargin(true);

    }

    private void listenerOlustur() {

        btnFilmEkle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent    clickEvent) {

                Label headerCaption = new Label(btnFilmEkle.getCaption());
                header.setHeaderOzellik(headerCaption);

                DiziFilmEkle diziFilmEkle = new DiziFilmEkle();
                diziFilmEkle.setIsFilm(true);
                content.setContent(diziFilmEkle);
                header.setHeader(headerCaption);

                header.addMenuBar();
                header.getItem1().setEnabled(true);
                header.getItem2().setEnabled(false);
                header.getItem3().setEnabled(false);
                header.getItem4().setEnabled(false);
                header.getItem5().setEnabled(false);
                header.getItem6().setEnabled(false);

            }
        });

        btnDiziEkle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                Label headerCaption = new Label(btnDiziEkle.getCaption());
                header.setHeaderOzellik(headerCaption);

                DiziFilmEkle diziFilmEkle = new DiziFilmEkle();
                diziFilmEkle.setIsFilm(false);
                content.setContent(diziFilmEkle);
                header.setHeader(headerCaption);

                header.addMenuBar();
                header.getItem1().setEnabled(false);
                header.getItem2().setEnabled(true);
                header.getItem3().setEnabled(false);
                header.getItem4().setEnabled(false);
                header.getItem5().setEnabled(false);
                header.getItem6().setEnabled(false);
            }
        });

        btnBasrolEkle.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Label headerCaption = new Label(btnBasrolEkle.getCaption());
                header.setHeaderOzellik(headerCaption);

                OyuncuEkleView oyuncuEkleView = new OyuncuEkleView();
                content.setContent(oyuncuEkleView);
                header.setHeader(headerCaption);

                header.addMenuBar();
                header.getItem1().setEnabled(false);
                header.getItem2().setEnabled(false);
                header.getItem3().setEnabled(true);
                header.getItem4().setEnabled(false);
                header.getItem5().setEnabled(false);
                header.getItem6().setEnabled(false);
            }
        });


        btnFilmListele.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                Label headerCaption = new Label(btnFilmListele.getCaption());
                header.setHeaderOzellik(headerCaption);

                DiziFilmListView diziFilmListView = new DiziFilmListView();
                diziFilmListView.setIsFilm(true);
                diziFilmListView.fillTable();

                content.setContent(diziFilmListView);
                header.setHeader(headerCaption);

                header.addMenuBar();
                header.getItem1().setEnabled(false);
                header.getItem2().setEnabled(false);
                header.getItem3().setEnabled(false);
                header.getItem4().setEnabled(true);
                header.getItem5().setEnabled(false);
                header.getItem6().setEnabled(true);

            }
        });

        btnDiziListele.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                Label headerCaption = new Label(btnDiziListele.getCaption());
                header.setHeaderOzellik(headerCaption);

                DiziFilmListView diziListView = new DiziFilmListView();
                diziListView.setIsFilm(false);
                diziListView.fillTable();
                content.setContent(diziListView);
                header.setHeader(headerCaption);

                header.addMenuBar();
                header.getItem1().setEnabled(false);
                header.getItem2().setEnabled(false);
                header.getItem3().setEnabled(false);
                header.getItem4().setEnabled(false);
                header.getItem5().setEnabled(true);
                header.getItem6().setEnabled(false);

            }
        });

        btnBasrolProjeListele.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                Label headerCaption = new Label(btnBasrolProjeListele.getCaption());
                header.setHeaderOzellik(headerCaption);

                OyuncuProjeListView oyuncuProjeListView = new OyuncuProjeListView();
                content.setContent(oyuncuProjeListView);
                header.setHeader(headerCaption);

                header.addMenuBar();
                header.getItem1().setEnabled(false);
                header.getItem2().setEnabled(false);
                header.getItem3().setEnabled(false);
                header.getItem4().setEnabled(false);
                header.getItem5().setEnabled(false);
                header.getItem6().setEnabled(true);
            }
        });

    }

    private void comoponentOlustur() {
        btnFilmEkle = new SideBarButton("Film Ekle");
        btnFilmEkle.setIcon(FontAwesome.PLUS_CIRCLE);

        btnDiziEkle = new SideBarButton("Dizi Ekle");
        btnDiziEkle.setIcon(FontAwesome.PLUS_CIRCLE);

        btnBasrolEkle = new SideBarButton("Başrol Ekle");
        btnBasrolEkle.setIcon(FontAwesome.PLUS_CIRCLE);

        btnBasrolProjeListele = new SideBarButton("Oyuncu/Proje Listele");
        btnBasrolProjeListele.setIcon(FontAwesome.LIST_OL);

        btnFilmListele = new SideBarButton("Film Listele");
        btnFilmListele.setIcon(FontAwesome.LIST_OL);

        btnDiziListele = new SideBarButton("Dizi Listele");
        btnDiziListele.setIcon(FontAwesome.LIST_OL);


        addComponent(btnFilmEkle);
        addComponent(btnDiziEkle);
        addComponent(btnBasrolEkle);
        addComponent(btnFilmListele);
        addComponent(btnDiziListele);
        addComponent(btnBasrolProjeListele);
    }
}