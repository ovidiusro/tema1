package ro.academy.rpg;

import java.io.*;
import java.util.Scanner;

/**
 * Created by hozan on 04.05.2016.
 */

public class Map {

    char[][] map = new char[13][13];
    int nr;
    char character;
    Scanner in;
    String command;

    Map() {//load map
        in = new Scanner(System.in);
        try {
            FileReader file = new FileReader("input.txt");
            BufferedReader reader = new BufferedReader(file);

            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    nr = reader.read();
                    character = (char) nr;
                    if (character != '\n')
                        map[y][x] = character;  //citim fisierul
                    else {
                        x = 500;
                        y--;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Eroare:" + e.getMessage());
        }
    }

    public void display(Hero hero) {

        System.out.println("Hero: " + hero.getName() + " health :" + hero.getHp());

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++)
                System.out.print(map[y][x]);
            System.out.println();
        }

    }

    public String makeCommand() {
        System.out.print("Introduce the command (w,s,a,d/r,f): ");
        return in.next();
    }

    public boolean move(Hero hero) {
        command = makeCommand();
        if (command.equals("w") && map[hero.getY() - 1][hero.getX()] == ' ') {
            map[hero.getY() - 1][hero.getX()] = 'H';
            map[hero.getY()][hero.getX()] = ' ';
            hero.setY(hero.getY() - 1);
            return true;
        } else if (command.equals("s") && map[hero.getY() + 1][hero.getX()] == ' ') {
            map[hero.getY() + 1][hero.getX()] = 'H';
            map[hero.getY()][hero.getX()] = ' ';
            hero.setY(hero.getY() + 1);
            return true;
        } else if (command.equals("a") && map[hero.getY()][hero.getX() - 1] == ' ') {
            map[hero.getY()][hero.getX() - 1] = 'H';
            map[hero.getY()][hero.getX()] = ' ';
            hero.setX(hero.getX() - 1);
            return true;
        } else if (command.equals("d") && map[hero.getY()][hero.getX() + 1] == ' ') {
            map[hero.getY()][hero.getX() + 1] = 'H';
            map[hero.getY()][hero.getX()] = ' ';
            hero.setX(hero.getX() + 1);
            return true;
        } else
            return false;
    }
}
