/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CoolRPG;

/**
 *
 * @author UGent
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Library
{
    protected List<Spell> librarybook;
    public Library()
    {
        librarybook = new ArrayList<Spell>();
    }
    public int libraryMenu()
    {

        System.out.println("* 1. Buy a spell.");
        System.out.println("* 2. Leave the library.");
        Scanner scanner3 = new Scanner(System.in);
        int output = 0;
        String input = "";
        while (output==0)
        {
            input = scanner3.nextLine();
            input = input.trim();
            if (input.equals("1")||input.equals("1.")||input.equals("one")) { scanner3.close(); output = 1; }
            else if (input.equals("2")||input.equals("2.")||input.equals("two")) { scanner3.close(); output = 2; }         // GEEF LETTER TERUG VAN OPTIE, 4 IS EEN FAAL
            else { System.out.println("* That's not a valid option!"); }
        }
        return output;
    }
    public static void writeSpellInventory(List<Spell> spells,boolean isAShop)
    {
        int i = 1;
        String elementname ="";
        for(Spell spell: spells)
        {
            if(spell.element==0) elementname = "Fire";
            if(spell.element==1) elementname = "Water";
            if(spell.element==2) elementname = "Earth";
            System.out.println("* " + i + ". " + spell.name + " : " + elementname);
            System.out.println("* " + spell.description);
            System.out.println("* Spell power : " + spell.power);
            if(isAShop) System.out.println("* Price : " + spell.price);
            System.out.println("* -------------------------------------------------");
            i++;
        }
    }
    public void libraryInterface(Character player,int choice) throws InterruptedException
    {
        if(choice==1)
        {
            for (int i=0; i<100; ++i) System.out.println();
            writeSpellInventory(librarybook,true);
            System.out.println("* --------------------------------");
            System.out.println("* Press 0 to exit");
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();
            inputString = inputString.trim();
            int inputInt = Integer.parseInt(inputString);
            // CHECK IF INPUT = AN EXISTING ITEM
            if(inputInt > 0 && inputInt <= librarybook.size())
            {
                inputInt--;
                Spell wantedSpell = librarybook.get(inputInt);
                if(player.money >= wantedSpell.price)
                {
                    player.money = player.money - wantedSpell.price;
                    player.spellbook.add(wantedSpell);
                    player.initializeEquipment();
                    System.out.println("* " + wantedSpell.incantation);
                    System.out.println("* Bless you.!");
                    Thread.sleep(1000);
                    librarybook.remove(inputInt);
                }
                else
                {
                    System.out.println("* You cannot afford that magic!");
                    Thread.sleep(1000);
                }
            }
            else if(inputInt==0)
            {
                for (int i=0; i<100; ++i) System.out.println();
                System.out.println("* Ok then.");
                Thread.sleep(1000);
            }
            else
            {
                System.out.println("* I do not know of what spell you speak!");
                Thread.sleep(1000);
            }
            for (int i=0; i<100; ++i) System.out.println();
        }                   // BUY       // SELL
        if(choice==2)
        {
            for (int i=0; i<100; ++i) System.out.println();
            System.out.println("Thank you, may our Gods be with you!");
            Thread.sleep(1000);
            for (int i=0; i<100; ++i) System.out.println();
        }                   // LEAVE
    }
}
