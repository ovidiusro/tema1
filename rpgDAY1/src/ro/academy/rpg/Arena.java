package ro.academy.rpg;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by hozan on 04.05.2016.
 */

public class Arena {

    int mobhp;
    int intRand;
    int indexRounds;
    Random randomGenerator;
    Characters[] arrayCharacters;
    String command;
    Scanner in;

    Arena() {
        randomGenerator = new Random();
        arrayCharacters = new Characters[4];
        arrayCharacters[0] = new Garen();
        arrayCharacters[1] = new Riven();
        arrayCharacters[2] = new Darius();
        arrayCharacters[3] = new MansterYi();
        mobhp = 0;
        indexRounds = 0;
        in = new Scanner(System.in);
    }
    private void pressAnnyKey()
    {
        System.out.print("Press anny key to continue : ");
        in.next();
    }
    private void afisare(Characters you, Characters mob) {

        System.out.println("              Round : " + indexRounds);
        pressAnnyKey();
        System.out.println("You," + you.getName() + " hit :" + you.dmg);
        System.out.println(mob.getName() + " hit :" + mob.dmg);
        System.out.println("You," + you.getName() + " hp = " + you.getHp());
        System.out.println(mob.getName() + " hp = " + mobhp);
    }

    public void initFight(Characters you) {

        indexRounds = 0;

        if (randomGenerator.nextInt(100) >= 51) {
            intRand = randomGenerator.nextInt(4);
            System.out.println("You have meet a monster !!");
            arrayCharacters[intRand].printProp();

            while (true) {
                System.out.println("Press 'r' for run and 'f' for fight!!");
                command = in.next();

                if (command.equals("f")) {
                    fight(you, arrayCharacters[intRand]);
                    break;
                }
                else if (command.equals("r")) {
                    if (randomGenerator.nextInt(101) >= 60) {
                        System.out.println("Success, you are free");
                        pressAnnyKey();
                        break;
                    }
                    else {
                        System.out.println("Fail, you are in a battle");
                        fight(you, arrayCharacters[intRand]);
                        pressAnnyKey();
                        break;
                    }
                } else {
                    System.out.println("Unknown commands !!, You know how to read?");
                    pressAnnyKey();
                }
            }
        }
    }

    public boolean fight(Characters you, Characters mob) {
        mobhp = mob.hp;

        afisare(you, mob);

        while (true) {
            you.hp -= mob.dmg;
            mobhp -= you.dmg;

            indexRounds++;
            afisare(you, mob);

            if (mobhp <= 0 || you.hp <= 0)
                break;
        }

        if (you.hp > 0) {
            System.out.println("You win the battle !");
            return true;
        } else {
            System.out.println("You lose win the battle !");
            return false;
        }
    }
}
