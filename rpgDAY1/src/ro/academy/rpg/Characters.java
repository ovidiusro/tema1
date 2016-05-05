package ro.academy.rpg;

/**
 * Created by hozan on 04.05.2016.
 */

public class Characters {
    int hp;
    int dmg;
    String name;

    Characters() {
        name = "unknown";
        hp = 1;
        dmg = 1;
    }

    public int getDmg() {
        return dmg;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public void printProp() {
        System.out.println("Monster stats: type = " + name + " hp = " + hp + " dmg = " + dmg);
    }
}

class Hero extends Characters {
    String artefact;
    int x;
    int y;

    Hero() {
        artefact = "unequipped";
        x = 5;
        y = 5;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void printProp() {
        System.out.println("Hero stats: type = " + name + " hp = " + hp + " dmg = " + dmg + " artefact = " + artefact);
    }
}

class Warrior extends Hero {
    Warrior() {
        name = "Warrior";
        artefact = "Sabia de plastelina";
        hp = 200;
        dmg = 30;
    }
}

class Archer extends Hero {
    Archer() {
        name = "Archer";
        artefact = "Arc din elastic si plastic";
        hp = 150;
        dmg = 40;
    }
}

class Wizard  extends Hero {
    Wizard() {
        name = "Wizard";
        artefact = "Acadea";
        hp = 150;
        dmg = 50;
    }
}
class Medic extends Hero {
    Medic () {
        name = "Medic";
        artefact = "Paracetamol";
        hp = 150;
        dmg = 50;
    }
}

class Garen extends Characters {
    Garen() {
        name = "Garen";
        hp = 100;
        dmg = 20;
    }

}

class Riven extends Characters {
    Riven() {
        name = "riven";
        hp = 50;
        dmg = 14;
    }

}

class Darius extends Characters {
    Darius() {
        name = "Darius";
        hp = 120;
        dmg = 15;
    }
}
class MansterYi extends Characters {
    MansterYi() {
        name = "MansterYi";
        hp = 120;
        dmg = 30;
    }
}

