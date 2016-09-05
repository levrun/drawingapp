package ru.interview.springnature.drawingapp;

import org.junit.Before;
import org.junit.Test;
import ru.interview.springnature.drawingapp.commands.CreateCanvas;
import ru.interview.springnature.drawingapp.commands.DrawLine;
import ru.interview.springnature.drawingapp.commands.Exit;
import ru.interview.springnature.drawingapp.commands.UnknownCommand;
import ru.interview.springnature.drawingapp.io.StringCommandParser;
import ru.interview.springnature.drawingapp.models.Line;
import ru.interview.springnature.drawingapp.models.Point;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Eraskin Alexei on 04.09.2016.
 */
public class StringCommandParserTests {

    private StringCommandParser parser;

    @Before
    public void initialize() {
        parser = new StringCommandParser();
    }

    @Test
    public void testThatQTranslatedToExitCommand() {
        String stringCommand = "Q ";
        Exit exitCommand = new Exit();

        assertThat(parser.parse(stringCommand).getName(), is(exitCommand.getName()));
    }

    @Test
    public void testWrongCommand() {
        String stringCommand = "Q blah blah blah";
        UnknownCommand unknownCommand = new UnknownCommand();

        assertThat(parser.parse(stringCommand).getName(), is(unknownCommand.getName()));
    }

    @Test
    public void testThatCTranslatedToCreateCanvasCommand() {
        String stringCommand = "C 1 10";
        CreateCanvas drawLineCommand = new CreateCanvas(new Point(10, 10));

        assertThat(parser.parse(stringCommand).getName(), is(drawLineCommand.getName()));
    }

    @Test
    public void testThatLTranslatedToDrawLineCommand() {
        String stringCommand = "L 1 1 10 2";
        DrawLine drawLineCommand = new DrawLine(new Line(new Point(1, 1), new Point(10, 2)));

        assertThat(parser.parse(stringCommand).getName(), is(drawLineCommand.getName()));
    }

}
