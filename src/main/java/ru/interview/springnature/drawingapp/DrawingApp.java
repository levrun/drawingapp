package ru.interview.springnature.drawingapp;

import ru.interview.springnature.drawingapp.commands.Command;
import ru.interview.springnature.drawingapp.drawing.CanvasPainter;
import ru.interview.springnature.drawingapp.drawing.console.ConsoleCanvasPainter;
import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.exceptions.NoCanvasCreated;
import ru.interview.springnature.drawingapp.exceptions.UnknownCommandException;
import ru.interview.springnature.drawingapp.io.CommandReceiver;
import ru.interview.springnature.drawingapp.io.ConsoleCommandReceiver;
import ru.interview.springnature.drawingapp.io.StringCommandParser;

import static ru.interview.springnature.drawingapp.drawing.console.ConsoleUtils.*;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public class DrawingApp {

    public static void main(String[] args) {
        printLogo();
        printHelper();

        StringCommandParser stringCommandParser = new StringCommandParser();
        CommandReceiver receiver = new ConsoleCommandReceiver(stringCommandParser);
        CanvasPainter painter = new ConsoleCanvasPainter();

        Command command;
        do {
            enterCommandMessage();
            command = receiver.receiveNextCommand();

            try {
                command.execute(painter);
            } catch (UnknownCommandException exception) {
                unknownCommandMessage();
                printHelper();
            } catch (IllegalParametersException exception) {
                wrongParametersProvidedMessage(exception.getMessage());
                printHelper();
            } catch (NoCanvasCreated exception) {
                cantDrawWithoutCanvasMessage();
                printHelper();
            }

        } while (!command.getName().equals(Command.EXIT));

        exitMessage();
    }

}
