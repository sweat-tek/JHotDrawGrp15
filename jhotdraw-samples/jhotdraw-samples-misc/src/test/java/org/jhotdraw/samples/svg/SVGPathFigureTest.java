package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.draw.handle.Handle;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Collection;

import static org.junit.Assert.*;

public class SVGPathFigureTest {
    private SVGPathFigure svgPathFigure;
    private Graphics2D g;

    @Before
    public void setup() {
        svgPathFigure = new SVGPathFigure();
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        g = bufferedImage.createGraphics();
    }

    @Test
    public void getActionsTest() {
        Collection<Action> actions = svgPathFigure.getActions(new Point2D.Double(10, 10));
        assertFalse(actions.isEmpty());
    }

    @Test
    public void createHandlesTest() {
        Collection<Handle> detailLevelm1 = svgPathFigure.createHandles(-1);
        assertNotNull(detailLevelm1);
        assertEquals(1, detailLevelm1.size());

        Collection<Handle> detailLevel1 = svgPathFigure.createHandles(1);
        assertNotNull(detailLevel1);
        assertEquals(10, detailLevel1.size());

        Collection<Handle> detailLevel2 = svgPathFigure.createHandles(2);
        assertNotNull(detailLevel2);
        assertEquals(2, detailLevel2.size());
    }
}
