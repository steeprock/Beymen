package org.example.page;

import org.example.utils.Driver;

import static org.example.AutomationConstant.URL;

public class AppLauncher {

    public void openHome() {
        Driver.webDriver.get(URL);
    }
}
