package ca.samb.lab2.action;

import ca.samb.lab2.menu.Menu;

public class LeaveAction extends Action {
    public LeaveAction(Menu menu) {
        super(menu);
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
