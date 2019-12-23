package com.firatulgay.Views.EkleView;

import com.firatulgay.Buttons.MyTextField;
import com.firatulgay.Buttons.SaveButton;
import com.firatulgay.Domain.BasRolOyuncu;
import com.firatulgay.dao.BasRolDao;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class OyuncuEkleView extends VerticalLayout {

    private MyTextField idField;
    private MyTextField adiField;
    private MyTextField yasField;
    private FormLayout mainLayout;

    public OyuncuEkleView() {

        buildMainLayout();
    }

    private void buildMainLayout() {

        mainLayout = new FormLayout();
        addComponent(mainLayout);

        idField = new MyTextField("Id");
        idField.setEnabled(false);
        mainLayout.addComponent(idField);

        adiField = new MyTextField("Adi");
        mainLayout.addComponent(adiField);

        yasField = new MyTextField("Yaş");
        mainLayout.addComponent(yasField);

        SaveButton saveButton = new SaveButton();
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                String adiFieldValue = adiField.getValue();
                String yasFieldValue = yasField.getValue();

                BasRolOyuncu basRolOyuncu = new BasRolOyuncu();
                basRolOyuncu.setAdi(adiFieldValue);
                basRolOyuncu.setYas(Integer.parseInt(yasFieldValue));

                BasRolDao basRolDao = new BasRolDao();
                basRolDao.basRolEkle(basRolOyuncu);


            }
        });
        mainLayout.addComponent(saveButton);
    }
}
