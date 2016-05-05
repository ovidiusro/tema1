package ro.academy.rpg;

import java.util.Scanner;

/**
 * Created by hozan on 04.05.2016.
 */

class  ChoiceHero
{
    Scanner in;
    String command;

    ChoiceHero()
    {
    in = new Scanner(System.in);
    }
 public    Hero choice()
  {
      while(true)
      {
          System.out.println("1: Warrior");
          System.out.println("2: Archer");
          System.out.println("2: Mage");
          System.out.println("4: Medic");
          System.out.print("Press '1,2,3 or 4' :");
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
        Hero hero = new Hero();


        hero = choiceHero.choice();
        hero.printProp();
        map.display(hero);
        while (map.move(hero)) {
            arena.initFight(hero);
            map.display(hero);
            if (hero.getHp() <= 0)
                break;
        }
        if (hero.getHp() <= 0)
            System.out.println("Game over!");
        else
            System.out.println("You win the game!");
    }
}
