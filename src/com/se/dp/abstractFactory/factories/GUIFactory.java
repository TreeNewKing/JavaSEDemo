package com.se.dp.abstractFactory.factories;


import com.se.dp.abstractFactory.buttons.Button;
import com.se.dp.abstractFactory.checkboxes.Checkbox;


/**
 * Abstract factory knows about all (abstract) product types.
 */
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}