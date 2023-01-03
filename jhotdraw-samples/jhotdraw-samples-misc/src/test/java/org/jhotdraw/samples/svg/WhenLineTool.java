package org.jhotdraw.samples.svg;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;
import org.jhotdraw.samples.svg.io.DefaultSVGFigureFactory;
import org.junit.Test;

import java.awt.*;
import java.util.HashMap;

import static org.junit.Assert.*;

public class WhenLineTool extends Stage<WhenLineTool> {

    @ExpectedScenarioState
    private DefaultDrawingView defaultDrawingView;

    @ExpectedScenarioState
    private DefaultSVGFigureFactory defaultFactory;

    @Test
    public WhenLineTool whenLineDrawn() {
        Figure figure = defaultFactory.createLine(0, 0, 2, 2, new HashMap<>());
        defaultDrawingView.getDrawing().add(figure);
        Point point = new Point(1, 1);
        Figure foundFigure = defaultDrawingView.findFigure(point);
        assertNotNull(figure);
        assertNotNull(foundFigure);
        assertTrue(foundFigure instanceof SVGPathFigure);
        assertSame(foundFigure, figure);
        return self();
    }

}
