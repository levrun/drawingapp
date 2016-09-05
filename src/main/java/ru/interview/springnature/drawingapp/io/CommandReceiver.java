package ru.interview.springnature.drawingapp.io;

import ru.interview.springnature.drawingapp.commands.Command;

/**
 * Created by Eraskin Alexei on 03.09.2016.
 */
public interface CommandReceiver {
    Command receiveNextCommand();
}
