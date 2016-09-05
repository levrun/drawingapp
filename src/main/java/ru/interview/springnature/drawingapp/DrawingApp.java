package ru.interview.springnature.drawingapp;

import ru.interview.springnature.drawingapp.commands.Command;
import ru.interview.springnature.drawingapp.drawing.CanvasPainter;
import ru.interview.springnature.drawingapp.drawing.ConsoleCanvasPainter;
import ru.interview.springnature.drawingapp.drawing.ConsoleUtils;
import ru.interview.springnature.drawingapp.exceptions.IllegalParametersException;
import ru.interview.springnature.drawingapp.exceptions.NoCanvasCreated;
import ru.interview.springnature.drawingapp.exceptions.UnknownCommandException;
import ru.interview.springnature.drawingapp.io.CommandReceiver;
import ru.interview.springnature.drawingapp.io.ConsoleCommandReceiver;
import ru.interview.springnature.drawingapp.io.StringCommandParser;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public class DrawingApp {

    public static void main(String[] args) {

        ConsoleUtils.printLogo();
        ConsoleUtils.printHelper();

        StringCommandParser stringCommandParser = new StringCommandParser();
        CommandReceiver receiver = new ConsoleCommandReceiver(stringCommandParser);
        CanvasPainter painter = new ConsoleCanvasPainter();

        Command command;
        do {
            System.out.println("enter command:");
            command = receiver.receiveNextCommand();

            try {
                command.execute(painter);
            } catch (UnknownCommandException exception) {
                System.out.println("unknown command");
                ConsoleUtils.printHelper();
            } catch (IllegalParametersException exception) {
                System.out.println("wrong parameters provided");
                ConsoleUtils.printHelper();
            } catch (NoCanvasCreated exception) {
                System.out.println("can't draw without canvas created");
                ConsoleUtils.printHelper();
            }

        } while (!command.getName().equals(Command.EXIT));

        System.out.println("good bye!");
    }

}
