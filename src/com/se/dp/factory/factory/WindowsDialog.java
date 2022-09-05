package com.se.dp.factory.factory;


import com.se.dp.factory.buttons.Button;
import com.se.dp.factory.buttons.WindowsButton;


/**
 * Windows Dialog will produce Windows buttons.
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}