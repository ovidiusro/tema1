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
    Villain[] arrayVillain;
    String command;
    Scanner in;
    Seri seri;

    Arena() {

        seri = new Seri();
        arrayVillain = seri.readObjects();
        randomGenerator = new Random();
        indexRounds = 0;
        in = new Scanner(System.in);

    }

    private void pressAnnyKey()
    {
        System.out.print("Press anny key to continue : ");
        in.next();
    }
    private void afisare(Characters you, Villain mob) {

        System.out.println("              Round : " + indexRounds);
       // pressAnnyKey();
        System.out.println("You," + you.getName() + " hit :" + you.dmg);
        System.out.println(mob.getName() + " hit :" + mob.dmg);

        System.out.println("You," + you.getName() + " hp = " + you.getHp());
        System.out.println(mob.getName() + " hp = " + mobhp);
        mob.drop();
    }

    public void initFight(Characters you) {

        indexRounds = 0;

        if (randomGenerator.nextInt(100) >= 51) {
            intRand = randomGenerator.nextInt(4);
            System.out.println("You have meet a villain !!");
            System.out.println(arrayVillain[intRand]);

            while (true) {
                System.out.println("Press 'r' for run and 'f' for fight!!");
                command = in.next();

                if (command.equals("f")) {
                    fight(you,arrayVillain[intRand]);
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
                        fight(you, arrayVillain[intRand]);
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

    public boolean fight(Characters you, Villain mob) {
        mobhp = mob.hp;

        afisare(you, mob);

        while (true) {

            you.hp -= mob.dmg;
            mobhp -= you.dmg;
            System.out.println(mob.getCompDmg());

            indexRounds++;
            afisare(you, mob);

            if (mobhp <= 0 || you.hp <= 0)
                break;
        }

        if (you.hp > 0) {
            System.out.println("You win the battle !");
            if(mob.drop())
                System.out.println(mob.getItemDrop());
            return true;
        } else {
            System.out.println("You lose the battle !");
            return false;
        }
    }
}
