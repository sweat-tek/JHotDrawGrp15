package org.jhotdraw.samples.svg;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class SVGPathFigureBehaviourTest extends ScenarioTest<GivenLineTool, WhenLineTool, ThenLineTool> {

    @Test
    public void drawLineTest() {
        given().lineToolCreated();
        when().whenLineDrawn();
        then().lineShouldExist();
    }
}
