package org.jhotdraw.samples.svg;

import org.jhotdraw.samples.svg.gui.FillToolBar;
import org.junit.Test;
import javax.swing.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import javax.swing.border.EmptyBorder;

public class FillToolBarTest {
    private FillToolBar fillTool;
    private JComponent panel;

    @org.junit.Before
    public void setUp() throws Exception {
        fillTool = new FillToolBar();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        fillTool.dispose();
    }

    @Test
    public void createDisclosedComponent1() {
        panel = fillTool.createDisclosedComponent(1);
        assertEquals(JPanel.class, panel.getClass());
        assertFalse(panel.isOpaque());
        assertEquals(new EmptyBorder(5, 5, 5, 8).getBorderInsets(), panel.getBorder().getBorderInsets(panel));
    }
    @Test
    public void createDisclosedComponent2() {
        panel = fillTool.createDisclosedComponent(2);
        assertEquals(JPanel.class, panel.getClass());
        assertFalse(panel.isOpaque());
    }
}
