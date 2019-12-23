package com.firatulgay.Buttons;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;

/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class SaveButton extends Button {

    public SaveButton() {
        setIcon(FontAwesome.CHECK);
        setCaption("Kaydet");
    }
}
