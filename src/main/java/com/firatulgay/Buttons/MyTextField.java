package com.firatulgay.Buttons;

import com.vaadin.ui.TextField;import java.lang.String;

/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class MyTextField extends TextField {

    public MyTextField() {
        addStyleName("st-text-field");
        setNullRepresentation("");
    }

    public MyTextField(String caption) {
        this();
        setCaption(caption);
    }
}
