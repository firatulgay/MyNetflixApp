package com.firatulgay.Layouts;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class General extends VerticalLayout {

    public General(){
        Label label = new Label();

        Header header = new Header(label);
        addComponent(header);

        Container container = new Container(header);
        addComponent(container);
    }
}
