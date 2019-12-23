package com.firatulgay.Layouts;

import com.vaadin.ui.*;
import com.vaadin.ui.Component;


/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class Content extends VerticalLayout {

    public void setContent(Component component) {

        this.removeAllComponents();
        addComponent(component);
    }


}
