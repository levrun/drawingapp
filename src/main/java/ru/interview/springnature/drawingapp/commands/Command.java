package ru.interview.springnature.drawingapp.commands;

import ru.interview.springnature.drawingapp.drawing.CanvasPainter;
import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.exceptions.NoCanvasCreated;
import ru.interview.springnature.drawingapp.exceptions.UnknownCommandException;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public interface Command {

    String EXIT = "ExitCommand";
    String UNKNOWN = "UnknownCommand";
    String CREATE_CANVAS = "CanvasCommand";
    String DRAW_LINE = "DrawLineCommand";
    String DRAW_RECTANGLE = "DrawRectangleCommand";
    String BUCKET_FILL = "BucketFillCommand";

    void execute(CanvasPainter canvasPainter) throws UnknownCommandException, IllegalParametersException, NoCanvasCreated;
    void validateParameters() throws IllegalParametersException, NoCanvasCreated;
    String getName();
}
