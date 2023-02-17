/*package org.jhotdraw.samples.svg;

import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.junit.Before;
import org.junit.Test;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import static org.junit.Assert.*;

public class SVGRectFigureTest {

    private SVGRectFigure rect;
    private Rectangle2D.Double bounds;


    @Before
    public void before() {
        rect = new SVGRectFigure(10, 11, 12, 13);
        bounds = rect.getBounds();
    }

    @Test
    public void testSVGRectFigureConst() {
        rect = new SVGRectFigure(10, 11, 12, 13);

        assertEquals(10, rect.getX(), 0);
        assertEquals(11, rect.getY(), 0);
        assertEquals(12, rect.getWidth(), 0);
        assertEquals(13, rect.getHeight(), 0);
    }

    @Test
    public void testTransform(){
        AffineTransform tx = new AffineTransform();
        tx.setToTranslation(10, 10);
        
        rect.transform(tx);

        assertNotEquals(rect.getBounds().x, bounds.x);
        assertNotEquals(rect.getBounds().y, bounds.y);
    }

    @Test
    public void testClone(){
        SVGRectFigure clone = rect.clone();

        assertEquals(clone.getX(), rect.getX(), 0);
        assertEquals(clone.getY(), rect.getY(), 0);
        assertEquals(clone.getWidth(), rect.getWidth(), 0);
        assertEquals(clone.getHeight(), rect.getHeight(), 0);
    }
}
*/