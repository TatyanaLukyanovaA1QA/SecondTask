package google.app.pages;

import google.framework.elements.Label;

public class MainPage {
    private Label uniqueLabel = new Label("//*[@id=\"hplogo\"]", "unqueLabel");

    public boolean isPageOpen() {
        return uniqueLabel.isLabelVisible();
    }
}