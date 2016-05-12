package ro.academy.rpg;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by hozan on 04.05.2016.
 */

public class Characters implements Serializable {
    protected Random random;
    protected double lvl;
    protected int hp;
    protected int dmg;
    protected static int id = 0;
    protected int armor;
    protected String nameSkill;
    protected int percentageSkill;
    protected String name;

    Characters(int hp, int dmg, double lvl, int armor, int percentageSkill) {
        random = new Random();
        name = "unknown";
        this.hp = hp;
        this.dmg = dmg;
        this.lvl = lvl;
        this.armor = armor;
        this.percentageSkill = percentageSkill;
    }

   public void update(int hp, int dmg, int armor)
   {
       this.hp += hp;
       this.dmg += dmg;
       this.armor += armor;
       System.out.println("Item equipped successfully");
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
    public int getCompDmg() {return dmg;}
    
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

    public void setPercentageSkill(int percentageSkill) {
        this.percentageSkill = percentageSkill;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getDmg() {
        return dmg;
    }

    public String getnameSkill() {
        return nameSkill;
    }

    public int getArmor() {
        return armor;
    }
}


class Hero extends Characters {
    protected String artefact;
    protected String equippedItem;

    protected int  x;
    protected int y;

    Hero() {
        super(1,1,1,1,1);
        name = "hero";
        lvl = 1;
        x = 6;
        y = 6;
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
        return ("Hero stats: type = " + name + " hp = " + hp + " dmg = " + dmg + " skill: " + nameSkill + "(" + percentageSkill + "%)");
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
        percentageSkill = 40;
        nameSkill = "Ultimate";
        hp = 200000;
        dmg = 40;
        armor = 15;
        lvl = 0;
    }

    public int getCompDmg() {
        if (random.nextInt(101) <= percentageSkill) {
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
        percentageSkill = 30;
        nameSkill = "Head Shot";
        armor = 8;
        hp = 250;
        dmg = 40;
        lvl = 0;
    }

    public int getCompDmg() {
        if (random.nextInt(101) <= percentageSkill) {
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
        percentageSkill = 30;
        nameSkill = "Buff";
        armor = 0;
        hp = 350;
        dmg = 60;
        lvl = 0;
    }
    public int getDeff() {
        if (random.nextInt(101) <= percentageSkill) {
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
        percentageSkill = 50;
        nameSkill = "Healing";
        armor = 5;
        hp = 250;
        lvl = 0;
        dmg = 20;
    }
    public int getDeff() {
        if (random.nextInt(101) <= percentageSkill) {
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

    public double getDropExp() {
        return dropExp;
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
        itemNameDrop = "SwordofDamacia";
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
        itemNameDrop = "Paracetamol";
        this.percentageItemDrop = percentageItemDrop;
        this.dropExp = dropExp;
        id++;
    }


    public int getCompDmg() {
        if (random.nextInt(101) <= percentageSkill) {
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

    Darius(int hp, int dmg, double lvl, int armor, int percentageSkill, int percentageItemDrop, double dropExp){
        super(hp, dmg, lvl, armor, percentageSkill);
        name = "Darius";
        nameSkill = "Ghilotine";
        itemNameDrop = "BloodyAxe";
        id++;
        this.percentageItemDrop = percentageItemDrop;
        this.dropExp = dropExp;
    }

    public int getCompDmg() {
        if (random.nextInt(101) >= 80) {
            return dmg * 3;
        } else {
            return dmg;
        }
    }

    public String toString() {
        return (super.toString() + "\nDrop: " + itemNameDrop + ", skill: " + nameSkill + "(" + percentageSkill + "%" +")");
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
        itemNameDrop = "MachineGun";
        id++;
    }

    public int getCompDmg() {
        if (random.nextInt(101) <= percentageSkill) {
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

