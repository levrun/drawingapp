package ru.interview.springnature.drawingapp.io;

import ru.interview.springnature.drawingapp.commands.Command;
import ru.interview.springnature.drawingapp.commands.UnknownCommand;

import java.util.Scanner;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public class ConsoleCommandReceiver implements CommandReceiver {

    private StringCommandParser commandParser;

    public ConsoleCommandReceiver(StringCommandParser parser) {
        this.commandParser = parser;
    }

    public Command receiveNextCommand() {
        Scanner scanner = new Scanner(System.in);
        Command command;

        try {
            command = commandParser.parse(scanner.nextLine());
            if(command == null) {
                throw new Exception("Something went wrong");
            }
        } catch(Exception e) {
            command = new UnknownCommand();
        }

        return command;
    }

}
