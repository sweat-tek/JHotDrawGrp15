package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.draw.figure.AbstractAttributedCompositeFigure;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static org.jhotdraw.samples.svg.SVGAttributeKeys.OPACITY;

public class SVGHelper {
    public static void draw(AbstractAttributedCompositeFigure compositeFigure, Graphics2D g) {
        double opacity = compositeFigure.get(OPACITY);
        opacity = Math.min(Math.max(0d, opacity), 1d);
        if (opacity != 0d && opacity != 1d) {
            Rectangle2D.Double drawingArea = compositeFigure.getDrawingArea();
            Rectangle2D clipBounds = g.getClipBounds();
            if (clipBounds != null) {
                Rectangle2D.intersect(drawingArea, clipBounds, drawingArea);
            }
            if (!drawingArea.isEmpty()) {
                BufferedImage buf = new BufferedImage(
                        Math.max(1, (int) ((2 + drawingArea.width) * g.getTransform().getScaleX())),
                        Math.max(1, (int) ((2 + drawingArea.height) * g.getTransform().getScaleY())),
                        BufferedImage.TYPE_INT_ARGB);
                Graphics2D gr = buf.createGraphics();
                gr.scale(g.getTransform().getScaleX(), g.getTransform().getScaleY());
                gr.translate((int) -drawingArea.x, (int) -drawingArea.y);
                gr.setRenderingHints(g.getRenderingHints());
                compositeFigure.drawFigure(gr);
                gr.dispose();
                Composite savedComposite = g.getComposite();
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
                g.drawImage(buf, (int) drawingArea.x, (int) drawingArea.y,
                        2 + (int) drawingArea.width, 2 + (int) drawingArea.height, null);
                g.setComposite(savedComposite);
            }
        } else {
            compositeFigure.drawFigure(g);
        }
    }
}
