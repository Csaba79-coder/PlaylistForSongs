package model;

import static java.lang.System.out;

public class Menu {

    public void printMenu() {
        out.println("Available actions:\npress");
        out.println("""
                0 - to quit
                1 - to play the next song
                2 - to play the previous song
                3 - to replay the current song
                4 - list of songs in the playlist
                5 - print available actions
                6 - delete current song""");
    }
}
