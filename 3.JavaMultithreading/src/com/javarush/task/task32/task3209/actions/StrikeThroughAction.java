package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

public class StrikeThroughAction extends StyledEditorKit.StyledTextAction {
    public StrikeThroughAction() {
        this("");
    }

    /**
     * Creates a new StyledTextAction from a string action name.
     *
     * @param nm the name of the action
     */
    public StrikeThroughAction(String nm) {
        super(nm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
