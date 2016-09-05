package ru.interview.springnature.drawingapp.io;

import ru.interview.springnature.drawingapp.commands.*;
import ru.interview.springnature.drawingapp.models.Line;
import ru.interview.springnature.drawingapp.models.Point;
import ru.interview.springnature.drawingapp.models.Rectangle;

import java.util.regex.Pattern;

/**
 * Created by Eraskin Alexei on 04.09.2016.
 */
public class StringCommandParser {

    private static final String CREATE_CANVAS_PATTERN = "(?i)C\\s+(\\d+)\\s+(\\d+)\\s?";
    private static final String DRAW_LINE_PATTERN = "(?i)L\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s?";
    private static final String DRAW_RECTANGLE_PATTERN = "(?i)R\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s?";
    private static final String EXIT_PATTERN = "(?i)Q\\s?";

    private static final String SPACE_SYMBOL = " ";
    private static final Pattern SPACE_PATTERN = Pattern.compile(SPACE_SYMBOL);

    public Command parse(String command) {

        if(Pattern.matches(EXIT_PATTERN, command)) {
            return new Exit();
        }

        if(Pattern.matches(DRAW_LINE_PATTERN, command)) {
            String[] arr = SPACE_PATTERN.split(command);
            Point start = new Point(Integer.valueOf(arr[1].trim()), Integer.valueOf(arr[2].trim()));
            Point end = new Point(Integer.valueOf(arr[3].trim()), Integer.valueOf(arr[4].trim()));
            return new DrawLine(new Line(start, end));
        }

        if(Pattern.matches(DRAW_RECTANGLE_PATTERN, command)) {
            String[] arr = SPACE_PATTERN.split(command);
            Point start = new Point(Integer.valueOf(arr[1].trim()), Integer.valueOf(arr[2].trim()));
            Point end = new Point(Integer.valueOf(arr[3].trim()), Integer.valueOf(arr[4].trim()));
            return new DrawRectangle(new Rectangle(start, end));
        }

        if(Pattern.matches(CREATE_CANVAS_PATTERN, command)) {
            String[] arr = SPACE_PATTERN.split(command);
            Point size = new Point(Integer.valueOf(arr[1].trim()), Integer.valueOf(arr[2].trim()));
            return new CreateCanvas(size);
        }

        return new UnknownCommand();
    }

}
