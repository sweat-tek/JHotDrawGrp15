package org.jhotdraw.samples.svg;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ThenLineTool extends Stage<ThenLineTool> {

    @ExpectedScenarioState
    private DefaultDrawingView defaultDrawingView;

    @Test
    public ThenLineTool lineShouldExist() {
        Point point = new Point(1, 1);
        Figure figure = defaultDrawingView.findFigure(point);

        assertNotNull(figure);
        assertTrue(figure instanceof SVGPathFigure);
        return self();
    }
}
