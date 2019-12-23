package com.firatulgay.Buttons;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class SideBarButton extends Button {
    public SideBarButton(String caption) {

        addStyleName(ValoTheme.BUTTON_PRIMARY);
        setIcon(FontAwesome.CLOUD_DOWNLOAD);
        setWidth(110, Sizeable.Unit.PERCENTAGE);
        setCaption(caption);

    }
}
