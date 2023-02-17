package org.jhotdraw.samples.svg.gui;

import org.jhotdraw.api.app.Disposable;
import org.jhotdraw.draw.DrawingEditor;

import javax.swing.*;
import java.util.LinkedList;

public class Panel {
    public JPanel getPanelState(DrawingEditor editor, LinkedList<Disposable> disposables) {
        return new JPanel();
    };
}
