package com.se.dp.factory.factory;

import com.se.dp.factory.buttons.Button;
import com.se.dp.factory.buttons.HtmlButton;


/**
 * HTML Dialog will produce HTML buttons.
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
