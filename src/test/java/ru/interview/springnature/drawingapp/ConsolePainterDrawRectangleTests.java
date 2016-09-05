package ru.interview.springnature.drawingapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.interview.springnature.drawingapp.commands.CreateCanvas;
import ru.interview.springnature.drawingapp.commands.DrawLine;
import ru.interview.springnature.drawingapp.commands.DrawRectangle;
import ru.interview.springnature.drawingapp.drawing.CanvasPainter;
import ru.interview.springnature.drawingapp.drawing.ConsoleCanvasPainter;
import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.exceptions.NoCanvasCreated;
import ru.interview.springnature.drawingapp.exceptions.UnknownCommandException;
import ru.interview.springnature.drawingapp.models.Line;
import ru.interview.springnature.drawingapp.models.Point;
import ru.interview.springnature.drawingapp.models.Rectangle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Eraskin Alexei on 06.09.2016.
 */
public class ConsolePainterDrawRectangleTests {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private CanvasPainter painter;

    @Before
    public void initialize() throws IllegalParametersException, UnknownCommandException {
        System.setOut(new PrintStream(out));
        painter =  new ConsoleCanvasPainter();
        CreateCanvas command = new CreateCanvas(new Point(20, 11));
        command.execute(painter);
        out.reset();
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void testThatWeCanDrawRectangleAndShowItOnConsole() throws IllegalParametersException,
                                                                         UnknownCommandException,
                                                                         NoCanvasCreated {

        DrawRectangle command =  new DrawRectangle(new Rectangle(new Point(3, 1), new Point(7, 5)));
        command.execute(painter);

        String outputStr =  "----------------------\r\n" +
                            "|  xxxxx             |\r\n" +
                            "|  x   x             |\r\n" +
                            "|  x   x             |\r\n" +
                            "|  x   x             |\r\n" +
                            "|  xxxxx             |\r\n" +
                            "|                    |\r\n" +
                            "|                    |\r\n" +
                            "|                    |\r\n" +
                            "|                    |\r\n" +
                            "|                    |\r\n" +
                            "|                    |\r\n" +
                            "----------------------\r\n";

        assertThat(out.toString(), is(outputStr));
    }

}
