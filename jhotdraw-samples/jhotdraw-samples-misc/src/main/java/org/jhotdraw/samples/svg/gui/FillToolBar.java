/*
 * @(#)FillToolBar.java
 *
 * Copyright (c) 2007-2008 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the
 * accompanying license terms.
 */
package org.jhotdraw.samples.svg.gui;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.event.SelectionComponentDisplayer;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.*;

/**
 * FillToolBar.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class FillToolBar extends AbstractToolBar {

    private static final long serialVersionUID = 1L;
    private SelectionComponentDisplayer displayer;
    private static final String LABELS = "org.jhotdraw.samples.svg.Labels";
    /**
     * Creates new instance.
     */
    @FeatureEntryPoint(value = "FILL_TOOL")
    public FillToolBar() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle(LABELS);
        setName(labels.getString(getID() + ".toolbar"));
        setDisclosureStateCount(3);
    }

    @Override
    public void setEditor(DrawingEditor newValue) {
        if (displayer != null) {
            displayer.dispose();
            displayer = null;
        }
        super.setEditor(newValue);
        if (newValue != null) {
            displayer = new SelectionComponentDisplayer(editor, this);
        }
    }


    @Override
    @FeatureEntryPoint(value = "FILL_TOOL")
    public JComponent createDisclosedComponent(int state) {
        Panel p = new Panel();
        if(state == 1 ) {
            p = new JPanelState1();
        }
        if(state == 2) {
            p = new JPanelState2();
        }
        return p.getPanelState(editor, disposables);
    }

    @Override
    protected String getID() {
        return "fill";
    }

    @Override
    protected int getDefaultDisclosureState() {
        return 1;
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setOpaque(false);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
