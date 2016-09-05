package ru.interview.springnature.drawingapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.interview.springnature.drawingapp.commands.CreateCanvas;
import ru.interview.springnature.drawingapp.commands.DrawLine;
import ru.interview.springnature.drawingapp.drawing.CanvasPainter;
import ru.interview.springnature.drawingapp.drawing.ConsoleCanvasPainter;
import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.exceptions.NoCanvasCreated;
import ru.interview.springnature.drawingapp.exceptions.UnknownCommandException;
import ru.interview.springnature.drawingapp.models.Line;
import ru.interview.springnature.drawingapp.models.Point;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Eraskin Alexei on 04.09.2016.
 */
public class CreateCanvasTests {

    private CanvasPainter painter;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initialize() {
        painter =  new ConsoleCanvasPainter();
    }

    @After
    public void cleanUp() {
        painter = null;
    }

    @Test
    public void testWrongParametersForCanvas() throws IllegalParametersException, UnknownCommandException {
        CreateCanvas command = new CreateCanvas(new Point(-11, 10));
        thrown.expect(IllegalParametersException.class);
        command.execute(painter);
    }

    @Test
    public void testToTryToDrawLineWhenCanvasNotCreated() throws NoCanvasCreated, IllegalParametersException, UnknownCommandException {
        DrawLine command = new DrawLine(new Line(new Point(1, 1), new Point(10, 2)));
        thrown.expect(NoCanvasCreated.class);
        command.execute(painter);
    }

    @Test
    public void testCreateCanvas() throws IllegalParametersException, UnknownCommandException {
        CreateCanvas command = new CreateCanvas(new Point(1, 10));
        command.execute(painter);

        Point[][] outputCanvasArray = painter.getCanvas().getArray();

        assertThat(outputCanvasArray.length, is(1));
        assertThat(outputCanvasArray[0].length, is(10));
    }


}
