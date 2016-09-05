package ru.interview.springnature.drawingapp.drawing;

/**
 * Created by Eraskin Alexei on 04.09.2016.
 */
public class ConsoleUtils {

    public static void printLogo() {
        System.out.println("  ________                        _____                    _______");
        System.out.println("  ___  __ \\____________ ___      ____(_)_____________ _    ___    |_______________");
        System.out.println("  __  / / /_  ___/  __ `/_ | /| / /_  /__  __ _  __ `/    __  /| |__  __ __\\  __ ");
        System.out.println("  _  /_/ /_  /  / /_/ /__ |/ |/ /_  / _  / / /  /_/ /     _  ___ |_  /_/ /_  /_/ /");
        System.out.println("   /_____/ /_/    __,_/ ____/|__/ /_/  /_/ /_/___, /      /_/  |_|  .___/_  .___/");
        System.out.println("                                             /____/              /_/     /_/");
        System.out.println("Drawing app 0.0-RC1");
    }

    public static void printHelper() {
        System.out.println("");
        System.out.println("> Type C w h to create new canvas");
        System.out.println("> Type L x1 y1 x2 y2 to draw a line");
        System.out.println("> Type R x1 y1 x2 y2 to draw a rectangle");
        System.out.println("> Type B x y c to use bucket fill");
        System.out.println("> Type Q to Exit");
        System.out.println("");
    }

}
