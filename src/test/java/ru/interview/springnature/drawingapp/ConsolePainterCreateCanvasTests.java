package ru.interview.springnature.drawingapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.interview.springnature.drawingapp.commands.CreateCanvas;
import ru.interview.springnature.drawingapp.drawing.CanvasPainter;
import ru.interview.springnature.drawingapp.drawing.console.ConsoleCanvasPainter;
import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.exceptions.UnknownCommandException;
import ru.interview.springnature.drawingapp.models.Point;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Eraskin Alexei on 05.09.2016.
 */
public class ConsolePainterCreateCanvasTests {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private CanvasPainter painter;

    @Before
    public void initialize() {
        System.setOut(new PrintStream(out));
        painter =  new ConsoleCanvasPainter();
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void testThatWeCanCreateCanvas2x2AndShowItOnConsole() throws IllegalParametersException, UnknownCommandException {
        CreateCanvas command = new CreateCanvas(new Point(2, 2));
        command.execute(painter);

        String outputStr = "----\r\n" +
                           "|  |\r\n" +
                           "|  |\r\n" +
                           "----\r\n";

        assertThat(out.toString(), is(outputStr));
    }

    @Test
    public void testThatWeCanCreateCanvas5x6AndShowItOnConsole() throws IllegalParametersException, UnknownCommandException {
        CreateCanvas command = new CreateCanvas(new Point(5, 6));
        command.execute(painter);

        String outputStr = "-------\r\n" +
                           "|     |\r\n" +
                           "|     |\r\n" +
                           "|     |\r\n" +
                           "|     |\r\n" +
                           "|     |\r\n" +
                           "|     |\r\n" +
                           "-------\r\n";

        assertThat(out.toString(), is(outputStr));
    }

}
