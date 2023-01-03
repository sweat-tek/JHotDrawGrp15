package org.jhotdraw.samples.svg;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;
import org.jhotdraw.samples.svg.io.DefaultSVGFigureFactory;
import org.junit.Test;

import java.util.HashMap;

public class GivenLineTool extends Stage<GivenLineTool> {
    @ProvidedScenarioState
    private DefaultDrawingView defaultDrawingView;

    @ProvidedScenarioState
    private DefaultSVGFigureFactory defaultFactory;

    @ProvidedScenarioState
    private DefaultDrawingEditor defaultDrawingEditor;

    @ProvidedScenarioState
    private CreationTool creationTool;

    @BeforeStage
    void before() {
        defaultDrawingView = new DefaultDrawingView();
        defaultFactory = new DefaultSVGFigureFactory();
        defaultDrawingEditor = new DefaultDrawingEditor();
        defaultDrawingView.setDrawing(new DefaultDrawing());
        defaultDrawingEditor.setActiveView(defaultDrawingView);
    }

    @Test
    public GivenLineTool lineToolCreated() {
        creationTool = new CreationTool(new SVGPathFigure(), new HashMap<>());
        creationTool.activate(defaultDrawingEditor);
        return self();
    }
}
