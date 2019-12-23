package com.firatulgay.Layouts;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class Header extends VerticalLayout {

    MenuBar.MenuItem item1;
    MenuBar.MenuItem item2;
    MenuBar.MenuItem item3;
    MenuBar.MenuItem item4;
    MenuBar.MenuItem item5;
    MenuBar.MenuItem item6;
    MenuBar.MenuItem item7;


    public Header(Label label) {

        setHeaderOzellik(label);
        addMenuBar();
    }

    void addMenuBar() {

        MenuBar menuBar = new MenuBar();
        menuBar.setWidth(100, Unit.PERCENTAGE);
        addComponent(menuBar);

        item1 = menuBar.addItem("Film Ekle", FontAwesome.AMAZON, null);
        item2 = menuBar.addItem("Dizi Ekle", FontAwesome.BELL, null);
        item3 = menuBar.addItem("Başrol Ekle", FontAwesome.CHAIN, null);
        item4 = menuBar.addItem("Film Listele", FontAwesome.FAST_BACKWARD, null);
        item5 = menuBar.addItem("Dizi Listele", FontAwesome.FAST_BACKWARD, null);
        item6= menuBar.addItem("Başrol/Proje Listele", FontAwesome.FAST_BACKWARD, null);


        item1.setEnabled(false);
        item2.setEnabled(false);
        item3.setEnabled(false);
        item4.setEnabled(false);
        item4.setEnabled(false);
        item5.setEnabled(false);
        item6.setEnabled(false);

    }


    public void setHeaderOzellik(Label label) {
        setWidth(100, Unit.PERCENTAGE);
        setHeight(100, Unit.PIXELS);
        label.addStyleName(ValoTheme.TEXTAREA_ALIGN_CENTER);
        label.addStyleName(ValoTheme.LABEL_HUGE);
        label.addStyleName(ValoTheme.LABEL_BOLD);

    }

    public void setHeader(Component component) {
        this.removeAllComponents();
        addComponent(component);
    }

    public MenuBar.MenuItem getItem1() {
        return item1;
    }

    public void setItem1(MenuBar.MenuItem item1) {
        this.item1 = item1;
    }

    public MenuBar.MenuItem getItem2() {
        return item2;
    }

    public void setItem2(MenuBar.MenuItem item2) {
        this.item2 = item2;
    }

    public MenuBar.MenuItem getItem3() {
        return item3;
    }

    public void setItem3(MenuBar.MenuItem item3) {
        this.item3 = item3;
    }

    public MenuBar.MenuItem getItem4() {
        return item4;
    }

    public void setItem4(MenuBar.MenuItem item4) {
        this.item4 = item4;
    }

    public MenuBar.MenuItem getItem5() {
        return item5;
    }

    public void setItem5(MenuBar.MenuItem item5) {
        this.item5 = item5;
    }

    public MenuBar.MenuItem getItem6() {
        return item6;
    }

    public void setItem6(MenuBar.MenuItem item6) {
        this.item6 = item6;
    }

    public MenuBar.MenuItem getItem7() {
        return item7;
    }

    public void setItem7(MenuBar.MenuItem item7) {
        this.item7 = item7;
    }
}
