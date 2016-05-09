package ro.academy.rpg;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by hozan on 04.05.2016.
 */

public class Characters implements Serializable {
    Random random;
    double lvl;
    int hp;
    int dmg;
    static int id = 0;
    int armor;
    String nameSkill;
    int percentageSkill;
    String name;

    Characters(int hp, int dmg, double lvl, int armor, int percentageSkill) {
        random = new Random();
        name = "unknown";
        this.hp = hp;
        this.dmg = dmg;
        this.lvl = lvl;
        this.armor = armor;
        this.percentageSkill = percentageSkill;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Nothing";
    }

    public int getDeff() {
        return armor;
    }

    public int getCompDmg() {
        return dmg;
    }

    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Characters) { //
            Characters characters = (Characters) anObject;
            if (characters.getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}


class Hero extends Characters {
    String artefact;
    String equippedItem;

    int x;
    int y;

    Hero() {
        super(-1, -1, -1, -1, -1);
        name = "hero";
        artefact = "unequipped";
        equippedItem = "unequipped";
        x = 5;
        y = 5;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getLvl() {
        return lvl;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return ("Hero stats: type = " + name + " hp = " + hp + " dmg = " + dmg + " skill: " + nameSkill + "(" + percentageSkill + "%)" + " artefact: " + artefact + " item: " + equippedItem);
    }

    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Hero) { //
            Hero hero = (Hero) anObject;
            if (hero.getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}

class Warrior extends Hero implements java.io.Serializable {

    Warrior() {
        name = "Warrior";
        equippedItem = "unequipped";
        artefact = "unequipped";
        percentageSkill = 40;
        nameSkill = "Ultimate";
        hp = 200;
        dmg = 40;
        armor = 20;
    }

    public int getCompDmg() {
        if (random.nextInt(101) <= percentageSkill) {
            System.out.println(nameSkill);
            return dmg * 3;
        } else {
            return dmg;
        }
    }

    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Warrior) { //
            Warrior warrior = (Warrior) anObject;
            if (warrior.getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}

class Archer extends Hero implements java.io.Serializable {
    Archer() {
        name = "Archer";
        equippedItem = "unequipped";
        artefact = "unequipped";
        percentageSkill = 30;
        nameSkill = "Head Shot";
        armor = 10;
        hp = 100;
        dmg = 40;
    }

    public int getCompDmg() {
        if (random.nextInt(101) <= percentageSkill) {
            System.out.println(nameSkill);
            return dmg * dmg;
        } else {
            return dmg;
        }
    }

    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Archer) { //
            Archer archer = (Archer) anObject;
            if (archer.getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}

class Wizard extends Hero implements java.io.Serializable {

    Wizard() {
        name = "Wizard";
        equippedItem = "unequipped";
        artefact = "unequipped";
        percentageSkill = 70;
        nameSkill = "Buff";
        armor = 0;
        hp = 150;
        dmg = 50;
    }

    public int getDeff() {
        if (random.nextInt(101) <= percentageSkill) {
            System.out.println(nameSkill);
            return 10000;
        } else {
            return armor;
        }
    }

    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Wizard) { //
            Wizard wizard = (Wizard) anObject;
            if (wizard.getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}

class Medic extends Hero implements java.io.Serializable {
    Medic() {
        name = "Medic";
        equippedItem = "unequipped";
        artefact = "unequipped";
        percentageSkill = 50;
        nameSkill = "Healing";
        armor = 5;
        hp = 150;
        dmg = 50;
    }

    public int getDeff() {
        if (random.nextInt(101) <= percentageSkill) {
            System.out.println(nameSkill);
            hp += dmg;
            return armor;
        } else {
            return armor;
        }
    }

    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Warrior) { //
            Medic medic = (Medic) anObject;
            if (medic.getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Villain!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


class Villain extends Characters {
    int percentageItemDrop;
    String itemNameDrop;
    double dropExp;

    Villain(int hp, int dmg, double lvl, int armor, int percentageSkill) {
        super(hp, dmg, lvl, armor, percentageSkill);
    }


    public void setDropExp(double dropExp) {
        this.dropExp = dropExp;
    }

    public void setPercentageItemDrop(int percentageItemDrop) {
        this.percentageItemDrop = percentageItemDrop;
    }

    public void setItemNameDrop(String itemNameDrop) {
        this.itemNameDrop = itemNameDrop;
    }

    boolean drop() {
        if (random.nextInt(101) <= percentageItemDrop)
            return true;
        else
            return false;
    }

    public String getItemDrop() {
        return itemNameDrop;
    }

    public String toString() {
        return ("Villain stats: type = " + name + " hp = " + hp + " dmg = " + dmg + " lvl: " + lvl + " dropExp: " + dropExp);
    }

    public double getDropExp(Hero hero) {
        return dropExp / hero.getLvl();
    }

    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Characters) {
            Villain villain = (Villain) anObject;
            if (villain.getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}

class Garen extends Villain {

    Garen(int hp, int dmg, int lvl, int armor, int percentageSkill, int percentageItemDrop, double dropExp) {
        super(hp, dmg, lvl, armor, percentageSkill);
        nameSkill = "Block";
        name = "Garen";
        itemNameDrop = "Sowrd of Damacia";
        this.percentageItemDrop = percentageItemDrop;
        this.dropExp = dropExp;
        id++;
    }

    public int getDeff() {
        if (random.nextInt(101) <= percentageSkill)
            return (percentageSkill * percentageSkill);
        else return armor;
    }

    public String toString() {
        return (super.toString() + "\nDrop: " + itemNameDrop + ", skill: " + nameSkill + "(" + percentageSkill + "%)");

    }

    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Villain) {
            Garen garen = (Garen) anObject;
            if (garen.getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}

class Riven extends Villain implements java.io.Serializable {


    Riven(int hp, int dmg, double lvl, int armor, int percentageSkill, int percentageItemDrop, double dropExp) {
        super(hp, dmg, lvl, armor, percentageSkill);
        nameSkill = "Critical";
        name = "Riven";
        itemNameDrop = "Red Potion";
        this.percentageItemDrop = percentageItemDrop;
        this.dropExp = dropExp;
        id++;
    }


    public int getCompDmg() {
        if (random.nextInt(101) <= percentageSkill) {
            System.out.println(nameSkill);
            return dmg * 2;
        } else {
            return dmg;
        }
    }

    public String toString() {
        return (super.toString() + "\nDrop: " + itemNameDrop + ", skill: " + nameSkill + "(" + percentageSkill + "%)");
    }

    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Villain) {
            Riven riven = (Riven) anObject;
            if (riven.getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}

class Darius extends Villain implements java.io.Serializable {
    int decapitationPercentage;
    String nameSkill2;

    Darius(int hp, int dmg, double lvl, int armor, int percentageSkill, int percentageItemDrop, double dropExp){
        super(hp, dmg, lvl, armor, percentageSkill);
        name = "Darius";
        nameSkill = "Block";
        nameSkill2 = "Decapitation";
        itemNameDrop = "Bloody Axe";
        id++;
        this.percentageItemDrop = percentageItemDrop;
        this.decapitationPercentage = percentageSkill;
        this.dropExp = dropExp;
    }

    public int getCompDmg() {
        if (random.nextInt(101) <= decapitationPercentage) {
            System.out.println(nameSkill2);
            return dmg * decapitationPercentage;
        } else {
            return dmg;
        }
    }

    public int getDeff() {
        if (random.nextInt(101) <= percentageSkill) {
            System.out.println(nameSkill);
            return (percentageSkill * percentageSkill);
        } else return armor;
    }

    public String toString() {
        return (super.toString() + "\nDrop: " + itemNameDrop + ", skill1: " + nameSkill + "(" + percentageSkill + "%), skill2: " + nameSkill2 + "(" + decapitationPercentage + "%)");
    }

    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Villain) { //
            Darius darius = (Darius) anObject;
            if (darius.getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}

class Jinx extends Villain implements java.io.Serializable {

    Jinx(int hp, int dmg, double lvl, int armor, int percentageSkill, int percentageItemDrop, double dropExp) {
        super(hp, dmg, lvl, armor, percentageSkill);

        this.percentageItemDrop = percentageItemDrop;
        this.dropExp = dropExp;

        nameSkill = "Headshot";
        name = "Jinx";
        itemNameDrop = "Machine Gun";
        id++;
    }

    public int getCompDmg() {
        if (random.nextInt(101) <= percentageSkill) {
            System.out.println(nameSkill);
            return dmg * percentageSkill;
        } else return dmg;
    }

    public String toString() {
        return (super.toString() + "\nDrop: " + itemNameDrop + ", skill: " + nameSkill + "(" + percentageSkill + "%)");
    }

    public boolean equals(Object anObject) {
        if (anObject == null) {
            return false;
        }
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof Villain) {
            Jinx jinx = (Jinx) anObject;
            if (jinx.getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}

