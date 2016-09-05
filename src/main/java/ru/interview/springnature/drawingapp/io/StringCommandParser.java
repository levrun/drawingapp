package ru.interview.springnature.drawingapp.io;

import ru.interview.springnature.drawingapp.commands.*;
import ru.interview.springnature.drawingapp.models.Line;
import ru.interview.springnature.drawingapp.models.Point;

import java.util.regex.Pattern;

/**
 * Created by Eraskin Alexei on 04.09.2016.
 */
public class StringCommandParser {

    public static final String CREATE_CANVAS_PATTERN = "(?i)C\\s+(\\d+)\\s+(\\d+)\\s?";
    public static final String DRAW_LINE_PATTERN = "(?i)L\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s?";
    public static final String EXIT_PATTERN = "(?i)Q\\s?";

    public static final String SPACE_SYMBOL = " ";

    public Command parse(String command) {

        if(Pattern.matches(EXIT_PATTERN, command)) {
            return new Exit();
        }

        if(Pattern.matches(DRAW_LINE_PATTERN, command)) {
            Pattern pattern = Pattern.compile(SPACE_SYMBOL);
            String[] arr = pattern.split(command);
            Point start = new Point(Integer.valueOf(arr[1].trim()), Integer.valueOf(arr[2].trim()));
            Point end = new Point(Integer.valueOf(arr[3].trim()), Integer.valueOf(arr[4].trim()));
            Line line = new Line(start, end);
            return new DrawLine(line);
        }

        if(Pattern.matches(CREATE_CANVAS_PATTERN, command)) {
            Pattern pattern = Pattern.compile(SPACE_SYMBOL);
            String[] arr = pattern.split(command);
            Point size = new Point(Integer.valueOf(arr[1].trim()), Integer.valueOf(arr[2].trim()));
            return new CreateCanvas(size);
        }

        return new UnknownCommand();
    }

}
