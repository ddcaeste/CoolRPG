import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Shop
{
    protected int shopMoney;
    protected List<Item> shopInventory;
    public Shop(int shopMoney)
    {
        this.shopMoney = shopMoney; 
        shopInventory = new ArrayList<Item>();
    }
    public int shopMenu()
    {

        System.out.println("* 1. Buy something.");
        System.out.println("* 2. Sell something.");
        System.out.println("* 3. Leave shop.");
        Scanner scanner3 = new Scanner(System.in);
        int output = 0;
        String input = "";
        while (output==0)
        {
            input = scanner3.nextLine();
            input = input.trim();
            if (input.equals("1")||input.equals("1.")||input.equals("one")) { scanner3.close(); output = 1; } 
            else if (input.equals("2")||input.equals("2.")||input.equals("two")) { scanner3.close(); output = 2; }
            else if (input.equals("3")||input.equals("3.")||input.equals("three")) { scanner3.close(); output = 3; }         // GEEF LETTER TERUG VAN OPTIE, 4 IS EEN FAAL
            else { System.out.println("* That's not a valid option!"); }
        }
        return output;
    }
    public void shopInterface(Character player,int choice) throws InterruptedException
    {
        if(choice==1)
        {
            for (int i=0; i<100; ++i) System.out.println();
            MenuPrints.printInventory(shopInventory); 
            System.out.println("* Shop money : " + shopMoney);
            System.out.println("* --------------------------------");
            System.out.println("* Press 0 to exit");
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();
            inputString = inputString.trim();
            int inputInt = Integer.parseInt(inputString);
            // CHECK IF INPUT = AN EXISTING ITEM
            if(inputInt > 0 && inputInt <= shopInventory.size())
            {
                inputInt--;
                Item wantedItem = shopInventory.get(inputInt);
                if(player.money >= wantedItem.itemPrice)
                {
                    player.money = player.money - wantedItem.itemPrice;
                    shopMoney = shopMoney + wantedItem.itemPrice;
                    player.inventory.add(wantedItem);
                    player.initializeEquipment();
                    System.out.println("* Thank you for your purchase!");
                    Thread.sleep(1000);
                    if(!(shopInventory.get(inputInt).shopRespawn))
                    { 
                        shopInventory.remove(inputInt);  
                    }
                }
                else
                {
                    System.out.println("* Don't waste my time! You can't afford that! Pfft.");
                    Thread.sleep(1000);
                }
            }
            else if(inputInt==0)
            {
                for (int i=0; i<100; ++i) System.out.println();
                System.out.println("* Ok.");  
                Thread.sleep(1000);
            }
            else
            {
                System.out.println("* I'm sorry, I ran out of nothing yesterday.");
                Thread.sleep(1000);
            }
            for (int i=0; i<100; ++i) System.out.println();
        }                   // BUY
        if(choice==2)
        {
            for (int i=0; i<100; ++i) System.out.println();
            MenuPrints.printInventory(player.inventory);
            System.out.println("* Press 0 to exit");
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();
            inputString = inputString.trim();
            int inputInt = Integer.parseInt(inputString);
            // CHECK IF INPUT = AN EXISTING ITEM
            if(inputInt > 0 && inputInt <= player.inventory.size())
            {
                inputInt--;
                Item sellingItem = player.inventory.get(inputInt);
                if( shopMoney >= (sellingItem.itemPrice/2))
                {
                    player.money = player.money + (sellingItem.itemPrice/2);
                    shopMoney = shopMoney - (sellingItem.itemPrice/2);
                    shopInventory.add(sellingItem);
                    player.initializeEquipment();
                    System.out.println("* Thank you for your merchandise!");
                    player.inventory.remove(inputInt);
                    Thread.sleep(1000);
                }
                else
                {
                    System.out.println("* I'm sorry, I can't afford that item.");
                    Thread.sleep(1000);
                }
            }
            else if(inputInt==0)
            {
                for (int i=0; i<100; ++i) System.out.println();
                System.out.println("* Ok.");  
                Thread.sleep(1000);
            }
            else 
            {
                System.out.println("* Are you trying to sell me something that doesn't exists?");
                Thread.sleep(1000);
            }
            for (int i=0; i<100; ++i) System.out.println();
        }                 // SELL
        if(choice==3)
        {
            for (int i=0; i<100; ++i) System.out.println();
            System.out.println("Thank you, please come again!");   
            Thread.sleep(1000);
            for (int i=0; i<100; ++i) System.out.println();
        }                   // LEAVE
    }
}
