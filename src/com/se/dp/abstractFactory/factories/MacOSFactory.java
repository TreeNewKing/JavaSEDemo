package com.se.dp.abstractFactory.factories;

import com.se.dp.abstractFactory.buttons.Button;
import com.se.dp.abstractFactory.buttons.MacOSButton;
import com.se.dp.abstractFactory.checkboxes.Checkbox;
import com.se.dp.abstractFactory.checkboxes.MacOSCheckbox;


/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();//这创建实例的可以混着使用工厂类。需要把Button改成一个抽象类
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
