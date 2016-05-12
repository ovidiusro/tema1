package ro.academy.rpg;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by hozan on 04.05.2016.
 */

public class Arena {

    int intRand;
    int indexRounds;
    Random randomGenerator;
    Villain[] arrayVillain;
    String command;
    Scanner in;
    Seri seri;
    int youdmg;
    int mobdmg;
    int mobdeff;
    int youdeff;

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

    public void initFight(Characters you, Inventory inventory) {

        indexRounds = 0;

        if (randomGenerator.nextInt(100) >= 50) {
            arrayVillain = seri.readObjects();
            intRand = randomGenerator.nextInt(4);
            System.out.println("You  meet a villain !!");
            System.out.println(arrayVillain[intRand]);

            while (true) {
                System.out.println("Press 'r' for run and 'f' for fight!!");
                command = in.next();

                if (command.equals("f")) {
                    fight(you,arrayVillain[intRand], inventory);
                    break;
                }
                else if (command.equals("r")) {
                    if (randomGenerator.nextInt(100) >= 60) {
                        System.out.println("Success, you are free");
                        pressAnnyKey();
                        break;
                    }
                    else {
                        System.out.println("Fail, you are in a battle");
                        fight(you, arrayVillain[intRand], inventory);
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

    public boolean fight(Characters you, Villain mob, Inventory inventory) {
        while (true) {
            System.out.println("              Round : " + indexRounds);
            System.out.println("You," + you.getName() + " hp = " + you.getHp());
            System.out.println(mob.getName() + " hp = " + mob.getHp());

            youdmg = you.getCompDmg();
            if (youdmg > you.getDmg())
                System.out.println(you.getName() + " a lovit cu  lovitura  '" + you.getnameSkill() + "' dmg :" + youdmg);
            else
                System.out.println(you.getName() + " a lovit normal dmg: " + youdmg);

            mobdeff = mob.getDeff();
            if (mobdeff > mob.getArmor())
                System.out.println(mob.getName() + " sa ferit");
            else if (mobdeff < youdmg) {
                mob.hp = mob.hp - (youdmg - mobdeff);
            }
            if (mob.getHp() > 0) {
                mobdmg = mob.getCompDmg();
                if (mobdmg > mob.getDmg())
                    System.out.println(mob.getName() + " a lovit cu  lovitura '" + you.getnameSkill() + "' dmg :" + mobdmg);
                else
                    System.out.println(mob.getName() + " a lovit normal dmg:" + mobdmg);
                youdeff = you.getDeff();
                if (youdeff > you.getArmor())
                    System.out.println(you.getName() + " sa ferit");
                else if (youdeff < mobdmg) {
                    you.hp = you.hp - (mobdmg - youdeff);
                }
            } else {
                you.lvl += mob.getDropExp((Hero)you)/100;

                if (mob.drop()) {
                    System.out.println(mob.getName() + " dropped " + mob.getItemDrop());
                    inventory.addOrNot((Hero) you,mob.getItemDrop());
                }break;
            }
            indexRounds++;
            if(you.hp <= 0) break;
        }
            if (you.hp > 0) {
                System.out.println("You win the battle !");
                return true;
            } else {
                System.out.println("You lose the battle !");
                return false;
            }
        }
}
