package ro.academy.rpg;
import java.util.*;
/**
 * Created by hozan on 11.05.2016.
 */

public class Inventory {
   static ArrayList inventar;
    Scanner scanner;
    String command;
    int  maxSize;
    Paracetamol paracetamol;
    Poison poison;
    Sword sword;
    MachineGun machineGun;
    MagicGlobe magicGlobe;
    Boots boots;
    Hat hat;
    Gloves gloves;
    Arrows arrows;
    BloodyAxe bloody;

    Inventory() {
        inventar = new ArrayList();
        maxSize = 0;
        scanner = new Scanner(System.in);
        poison = new Poison();
        paracetamol = new Paracetamol();
        poison = new Poison();
        sword = new Sword();
        magicGlobe = new MagicGlobe();
        arrows = new Arrows();
        machineGun = new MachineGun();
        boots = new Boots();
        hat = new Hat();
        gloves = new Gloves();
       bloody = new BloodyAxe();
        inventar.add("Boots");
        inventar.add("MachineGun");
        inventar.add("Hat");
        inventar.add("Paracetamol");
    }
    void    addItem(Hero hero,String name) {
        maxSize = (int) hero.lvl + 3;

        System.out.println(maxSize + " " + inventar.size());
        if (inventar.size() < maxSize){
            inventar.add(name);
        }
        else {
            System.out.println("Full inventory");
        }
        displayInventroy(hero);
    }
    void    addOrNot(Hero hero,String nameItem){
        System.out.println("Press 'c' for keep / 'd' for drop:");
        command = scanner.next();
        if(command.equals("c"))
            addItem(hero,nameItem);
    }
    void displayInventroy(Hero hero)
    {
        if(inventar.size() == 0)
            System.out.println("Empty inventory");
        for(int i = 0; i < inventar.size(); i++)
            System.out.println(i + 1 + " " + inventar.get(i));
    }

    public void equipItem(Hero hero, String nameItem) {

        if (gloves.equals(nameItem))
            hero.update(gloves.hp, gloves.dmg, gloves.armour);
        else if (boots.equals(nameItem))
            hero.update(boots.hp, boots.dmg, boots.armour);
        else if (hat.equals(nameItem))
            hero.update(hat.hp, hat.dmg, hat.armour);
        else if (hero.equals(new Medic())) {
            if (paracetamol.equals(nameItem))
                hero.update(paracetamol.hp, paracetamol.dmg, paracetamol.armour);
            else if (poison.equals(nameItem))
                hero.update(poison.hp, poison.dmg, paracetamol.armour);
            System.out.println("You can't equip this item");
        } else if (hero.equals(new Warrior())) {
            if (sword.equals(nameItem))
                hero.update(sword.hp, sword.dmg, sword.armour);
            else if(bloody.equals(nameItem))
                hero.update(bloody.hp, bloody.dmg, bloody.armour);
            System.out.println("You can't equip this item");
        } else if (hero.equals(new Wizard())) {
            if (magicGlobe.equals(nameItem))
                hero.update(magicGlobe.hp, magicGlobe.dmg, magicGlobe.armour);
            System.out.println("You can't equip this item");
        } else if (hero.equals(new Archer())){
            if (arrows.equals(nameItem))
                hero.update(arrows.hp, arrows.dmg, arrows.armour);
            else if (machineGun.equals(nameItem))
                hero.update(machineGun.hp, machineGun.dmg, machineGun.armour);
            System.out.println("You can't equip this item");
        }else
            System.out.println("You can't equip this item");
        inventar.remove(nameItem);
    }
    void   mainInventory(Hero hero)
    {
        while(true) {
            displayInventroy(hero);
            System.out.println("Enter the name of item which you want to equip,/'q' for quit");
            command = scanner.next();
            equipItem(hero, command);
            if(command.equals("q"))
                break;
        }
    }
}

