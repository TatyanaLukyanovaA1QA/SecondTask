package google.framework.elements;


public class Label extends BaseElement {
    public Label(String locator, String name) {
        super(locator, name);
    }

    public boolean isLabelVisible() {
        return isElementVisible();
    }

}
