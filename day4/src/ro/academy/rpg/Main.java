package ro.academy.rpg;
import java.util.Scanner;

/**
 * Created by hozan on 04.05.2016.
 */

class  ChoiceHero
{
    Scanner in;
    String command;
    Seri seri = new Seri();

    ChoiceHero()
    {
        in = new Scanner(System.in);
    }
    public    Hero choice()
    {
        seri = new Seri();

        while(true)
        {
            System.out.println("1: Warrior");
            System.out.println("2: Archer");
            System.out.println("2: Mage");
            System.out.println("4: Medic");
            System.out.println("5: Continue");

            System.out.print("Press '1,2,3,4 or 5' :");
            command = in.next();
            if(command.equals("1"))
            {
                Warrior warrior = new Warrior();
                return (warrior);
            }else if(command.equals("2"))
            {
                Archer archer = new Archer();
                return archer;
            }else if(command.equals("3"))
            {
                Wizard wizard = new Wizard();
                return wizard;
            }else if (command.equals("4"))
            {
                Medic medic = new Medic();
                return medic;
            }
            else if(command.equals("5"))
            {
              Hero hero;
                hero = seri.load();
                hero.setY(5);
                hero.setX(5);
                return hero;
            }
            else
                System.out.println("Try again");
        }
    }
}

public class Main {
    public static void main(String[] args) {


        Arena arena = new Arena(); // arena
        Map map = new Map(); // read map from file
        ChoiceHero choiceHero = new ChoiceHero();
        Hero hero;
        Seri seri = new Seri();


        hero = choiceHero.choice();
        System.out.println(hero.toString());

        map.display(hero);
        while (map.move(hero)) {
           arena.initFight(hero);
            map.display(hero);
            if (hero.getHp() <= 0)
                break;
        }
        seri.save(hero);
        if (hero.getHp() <= 0)
            System.out.println("Game over!");
        else

            System.out.println("You win the game!");
    }
}
