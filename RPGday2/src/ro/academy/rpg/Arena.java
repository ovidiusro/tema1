package ro.academy.rpg;

import java.rmi.MarshalledObject;
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
    String[] stringsArrayVillain;
    String command;
    Scanner in;

    Arena() {
        randomGenerator = new Random();
        stringsArrayVillain = new String[4];
        stringsArrayVillain[0] = "Garen";
        stringsArrayVillain[1] = "Riven";
        stringsArrayVillain[2] = "Darius";
        stringsArrayVillain[3] = "Jinx";
        indexRounds = 0;
        in = new Scanner(System.in);
    }

    private void pressAnnyKey()
    {
        System.out.print("Press anny key to continue : ");
        in.next();
    }
    public Villain generateVillain(String typeVillain)
    {
        if(typeVillain.equals("Garen")) {Garen garen = new Garen(); return garen;}
        else if(typeVillain.equals("Darus")) {Darius darius = new Darius(); return darius;}
       else  if(typeVillain.equals("Garen")) {Jinx jinx = new Jinx(); return jinx;}
        else if(typeVillain.equals("Garen")) {Riven riven = new Riven(); return riven;}
    }
    private void afisare(Characters you, Villain mob) {

        System.out.println("              Round : " + indexRounds);
        pressAnnyKey();
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
                    fight(you, arrayVillain[intRand]);
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
            System.out.println("You lose win the battle !");
            return false;
        }
    }
}


