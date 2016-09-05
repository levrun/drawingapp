package ru.interview.springnature.drawingapp.commands;

import ru.interview.springnature.drawingapp.drawing.CanvasPainter;
import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.exceptions.UnknownCommandException;

/**
 * Created by Eraskin Alexei on 04.09.2016.
 */
public class UnknownCommand implements Command {

    @Override
    public void execute(CanvasPainter painter) throws UnknownCommandException {
        throw new UnknownCommandException();
    }

    @Override
    public void validateParameters() throws IllegalParametersException {
    }

    @Override
    public String getName() {
        return UNKNOWN;
    }

}
