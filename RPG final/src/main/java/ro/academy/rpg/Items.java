package ro.academy.rpg;

/**
 * Created by hozan on 10.05.2016.
 */

public class Items {
        int     dmg;
        String  name;
        int     hp;
        int    armour;

    public int getDmg() {return dmg;}
    public int getArmour() {return armour;}
    public int getHp() {return hp;}
    public String getName(){return name;}
    public void setDmg(int dmg) {this.dmg = dmg;}
    public void setName(String name){this.name = name;}
    public void setArmour(int armour) {this.armour = armour;}
    public void setHp(int hp) {this.hp = hp;}
    public boolean equals(String nameItem) {
        if (name.equals(nameItem)) {
            return true;
        }else
            return false;
    }
}

///////////////////////////////////Archeritems/////////////////////
class ArcherItems extends  Items{
        ArcherItems()
        {
            dmg = -1;
            name = "unknown";
            armour = -1;
            hp = -1;
        }
}

class MachineGun extends  ArcherItems{
       MachineGun()
       {
           dmg = 10;
           name =  "MachineGun";
           armour = 10;
           hp = 0;
       }
}
class  Arrows extends ArcherItems{

    Arrows()
    {
        dmg = 10;
        name = "Arrows";
        hp = 0;
        armour = 15;
    }
}
//////////////////////////////////////////////////////////WariorItems//////////////
class WarriorItems extends Items{
    WarriorItems()
    {
        dmg = -1;
        name = "unknown";
        armour = -1;
        hp = -1;
    }
}
class Sword extends WarriorItems{
    Sword()
    {
        dmg = 20;
        name = "SwordofDamacia";
        armour = 20;
        hp = 0;
    }
}
class BloodyAxe extends WarriorItems{
    BloodyAxe()
    {
        dmg = 30;
        name = "BloodyAxe";
        armour = 20;
        hp = 0;
    }
}
/////////////////////////////////// Medic///////////////////////
class MedicItems extends Items{
   MedicItems()
   {
       dmg = -1;
       name = "unknown";
       armour = -1;
       hp = -1;
   }
}
class Paracetamol extends MedicItems{

    Paracetamol()
    {
        dmg = 0;
        name = "Paracetamol";
        armour = 0;
        hp = 30;
    }
}
class Poison extends MedicItems
{
    Poison()
    {
        dmg = 60;
        name = "Poison";
        armour = 0;
        hp = 0;
    }
}
//////////////////////////Wizard////////////////
class WizardItems extends Items{
    WizardItems()
    {
        dmg = -1;
        name = "unknown";
        armour = -1;
        hp = -1;
    }
}
class MagicGlobe extends WizardItems{

    MagicGlobe()
    {
        dmg = 20;
        name = "MagicGlobe";
        armour = 10;
        hp = 20;
    }
}
////////////////////////////comun///////////
class Boots extends Items{

    Boots()
    {
        dmg = 5;
        name = "Boots";
        armour = 20;
        hp = 5;
    }
}
class Hat extends Items{
    Hat()
    {
        dmg = 3;
        name = "Hat";
        armour = 25;
        hp = 5;
    }
}
class Gloves extends Items {
    Gloves() {
        dmg = 3;
        name = "Gloves";
        armour = 10;
        hp = 5;
    }
}
