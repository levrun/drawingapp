# Drawing app - 0.0-RC1
Simple console drawing program created as a coding challenge to SpringerNature.

How to run 
----------

*   Java 8 has to be installed on your machine.
*   Unrar ```drawingapp.rar```.
*   Open terminal and go to ```drawingapp\target``` folder.
*   Enter: ```java -jar drawingapp-0.0-RC1.jar```.

program work as follows:

1. create a new canvas
2. start drawing on the canvas by issuing various commands
4. undo if need to remove previous commands
3. quit

Libraries
---------

* junit 4.12     for JUnit testing
* mockito 1.9.5  for JUnit testing
* maven          for build and packaging

Design
------
                                                           +------------------+
                                                           | CommandParser    |
                                                           +------------------+
                                                                    |
                                                                    |
                                    +----------------+    +-------------------+
                                    |  DrawingApp    +----+  CommandReceiver  |
                                    +----------------+    +-------------------+
                                            |
       +----------------+           +-----------------+
       |  CanvasPainter +-----------+   Command       |
       +----------------+           +-----------------+
               |
        +---------------+
        |  Shape        |
        +---------------+


Notes and considerations
------------------------
1. Need to move dependencies on system.out to module so we can easily move app 
   to GUI without rewriting everything from scratch
2. Add storage for commands so we could support UNDO and logging and more
3. Rethink about corner cases in Bucket refill
4. Fix some bugs and error-prone user input
5. Add messages to configuration properties
6. Get rid of spagetty in StringCommandParser with ChainOfResponsibility
7. Move code-base to server and make web-app from it :)
...

# The Challenge
You're given the task of writing a simple console version of a drawing program. At this time,
the functionality of the program is quite limited but this might change in the future. In a
nutshell, the program should work as follows:

1. create a new canvas
2. start drawing on the canvas by issuing various commands
3. quit

At the moment, the program should support the following commands:
C w h Should create a new canvas of width w and height h.
L x1 y1 x2 y2 Should create a new line from (x1,y1) to (x2,y2). Currently only
horizontal or vertical lines are supported. Horizontal and vertical lines
will be drawn using the 'x' character.
R x1 y1 x2 y2 Should create a new rectangle, whose upper left corner is (x1,y1) and
lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
using the 'x' character.
B x y c Should fill the entire area connected to (x,y) with "colour" c. The
behaviour of this is the same as that of the "bucket fill" tool in paint
programs.
Q Should quit the program.

# Sample I/O

Below is a sample run of the program. User input is prefixed with ’enter command:’.
enter command: C 20 4
```text
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------
```

enter command: L 1 2 6 2

```text
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------
```

enter command: L 6 3 6 4
```text
----------------------
|                    |
|xxxxxx              |
| x                  |
| x                  |
----------------------
```

enter command: R 16 1 20 3
```text
----------------------
|               xxxxx|
|xxxxxx         x   x|
|     x         xxxxx|
|     x              |
----------------------
```
enter command: B 10 3 o
```text
----------------------
|oooooooooooooooxxxxx|
|xxxxxxooooooooox   x|
|     xoooooooooxxxxx|
|     xoooooooooooooo|
----------------------
```
