package ca.samb.lab2.action;

import ca.samb.lab2.menu.Menu;

public abstract class Action {

    private Menu menu;

    public Action(Menu menu) {
        this.menu = menu;
    }

    public abstract void execute();
 
    protected Menu getMenu() {
        return this.menu;
    }
}
