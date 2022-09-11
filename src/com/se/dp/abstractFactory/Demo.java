package com.se.dp.abstractFactory;

import com.se.dp.abstractFactory.app.Application;
import com.se.dp.abstractFactory.factories.GUIFactory;
import com.se.dp.abstractFactory.factories.MacOSFactory;
import com.se.dp.abstractFactory.factories.WindowsFactory;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {

    /**
     * Application picks the factory type and creates it in run time (usually at
     * initialization stage), depending on the configuration or environment
     * variables.
     */
    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();//构建
        app.paint();
    }
}