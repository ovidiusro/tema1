package ro.academy.rpg;

import java.io.*;
import java.util.Scanner;

/**
 * Created by hozan on 06.05.2016.
 */



public class Seri {
    static Villain[] arrayVillain;

    public void save(Object object)
    {
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("output.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
    public Hero load()
    {
        Hero  e = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("output.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e =  (Hero)in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
            return e;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return e;
        }
        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.hp);
        return e;
    }
    public  Villain[] readObjects () {

        arrayVillain = new Villain[4];
        File file = new File("imputVillain.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        scanner.nextLine();
        arrayVillain[0] = new Garen(
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                (double) Integer.parseInt(scanner.nextLine())
        );
        scanner.nextLine();
        arrayVillain[1] = new Riven(
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                (double) Integer.parseInt(scanner.nextLine())
        );
        scanner.nextLine();
         arrayVillain[2] = new Jinx(
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                (double) Integer.parseInt(scanner.nextLine())
        );
        scanner.nextLine();
        arrayVillain[3] = new Darius(
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()),
                (double) Integer.parseInt(scanner.nextLine())
        );
       return arrayVillain;
    }
}
