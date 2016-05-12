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

    Map() {//load map
        in = new Scanner(System.in);
        try {
            FileReader file = new FileReader("input.txt");
            BufferedReader reader = new BufferedReader(file);
            for (int y = 0; y < 12; y++) {
                for (int x = 0; x < 12; x++) {
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
        for (int y = 0; y < 12; y++) {
            for (int x = 0; x < 12; x++)
                System.out.print(map[y][x]);
            System.out.println();
        }

    }

    public boolean move(Hero hero, String command) {

        if(!command.equals("w") && !command.equals("s") && !command.equals("a") && !command.equals("d"))
            return true;
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

