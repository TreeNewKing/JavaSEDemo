package com.se.dp.abstractFactory.factories;

import com.se.dp.abstractFactory.buttons.Button;
import com.se.dp.abstractFactory.buttons.WindowsButton;
import com.se.dp.abstractFactory.checkboxes.Checkbox;
import com.se.dp.abstractFactory.checkboxes.WindowsCheckbox;


/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}