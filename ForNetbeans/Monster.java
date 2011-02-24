import java.util.Random;
import java.util.List;
import java.util.ArrayList;
public class Monster extends Alive
{
    protected String color;
    protected String trait;
    protected List<Item> loot;
    public Monster(Character player)
    {
        super();
        Random generator = new Random();
        boolean done = false;
         // BETWEEN 0 - 100
        while (!done)
        {
            int race = generator.nextInt(5);
            if(race==0) 
            { this.name = "Goblin"; 
                stats[0]=3; stats[1]=1; stats[2]=5; stats[3]=2; stats[4]=3; stats[5]=3; health = stats[4]*20;
                weakness[0]=80; weakness[1]=80; weakness[2]=50;
                int colour = generator.nextInt(5);
                if(colour==0) { color = "Black"; stats[0]++;}
                if(colour==1) { color = "Red"; stats[4]++;health = stats[4]*20;}
                if(colour==2) { color = "Green"; stats[4]--; health = stats[4]*20; stats[0]--;}
                if(colour==3) { color = "Brown"; }
                if(colour==4) { color = "Yellow"; stats[2]++;}
                int traitNum = generator.nextInt(2);
                if(traitNum==0) { trait = "Ugly";}
                if(traitNum==1) { trait = "Twitchy"; stats[2]++; health = stats[4]*20;}
                done = true;
            }
            if(race==1) 
            { this.name = "Wolf"; 
                stats[0]=4; stats[1]=1; stats[2]=7; stats[3]=1; stats[4]=4; stats[5]=1; health = stats[4]*20;
                weakness[0]=90; weakness[1]=70; weakness[2]=40;
                int colour = generator.nextInt(3);
                if(colour==0) { color = "Gray"; stats[0]++;                        }
                if(colour==1) { color = "White"; stats[4]++;health = stats[4]*20;  }
                if(colour==2) { color = "Black";                                   }
                int traitNum = generator.nextInt(2);
                if(traitNum==0) { trait = "Elder"; stats[4]++; stats[0]++; health = stats[4]*20; stats[2]--;}
                if(traitNum==1) { trait = ""; }
                done = true;
            }
            if(race==2&&player.level>=1) 
            { this.name=  "Gnoll";  
                stats[0]=5; stats[1]=3; stats[2]=5; stats[3]=2; stats[4]=6; stats[5]=3; health = stats[4]*20; 
                weakness[0]=60; weakness[1]=80; weakness[2]=70;
                int colour = generator.nextInt(5);
                if(colour==0) { color = "Brown"; }
                if(colour==1) { color = "Orange"; stats[4]++; health = stats[4]*20; }
                if(colour==2) { color = "Pink";  stats[0]--; stats[0]--; stats[4]--; health = stats[4]*20;} // -2 STR -1 END
                if(colour==3) { color = "White"; stats[2]++;}
                if(colour==4) { color = "Blue";  stats[2]++; stats[0]++;} 
                int traitNum = generator.nextInt(2);
                if(traitNum==0) { trait = "Ugly";}
                if(traitNum==1) { trait = "Sickly"; stats[4]--; health = stats[4]*20;}
                done = true;
            }
            if(race==3&&player.level>=3) 
            { this.name=  "Orc";    
                stats[0]=6; stats[1]=1; stats[2]=2; stats[3]=1; stats[4]=5; stats[5]=2; health = stats[4]*20;
                weakness[0]=70; weakness[1]=50; weakness[2]=50;
                int colour = generator.nextInt(3);
                if(colour==0) { color = "Black"; stats[0]++ ;stats[4]++; health = stats[4]*20; }
                if(colour==1) { color = "Red"; stats[0]++ ; stats[0]++ ;}
                if(colour==2) { color = "Green";}
                int traitNum = generator.nextInt(2);
                if(traitNum==0) { trait = "Frenzied"; stats[0]++;}
                if(traitNum==1) { trait = "Crazed";}
                done = true;
            } 
            if(race==4&&player.level>=5)
            { this.name =  "Troll";
                stats[0]=8; stats[1]=2; stats[2]=2; stats[3]=5; stats[4]=7; stats[5]=4; health = stats[4]*20;
                weakness[0]=90; weakness[1]=70; weakness[2]=30;
                int colour = generator.nextInt(3);
                if(colour==0) { color = "Brown"; }
                if(colour==1) { color = "Black"; stats[3]++; }
                if(colour==2) { color = "Green"; }
                int traitNum = generator.nextInt(2);
                if(traitNum==0) { trait = "Thick Skinned"; stats[3]++; stats[4]++; health = stats[4]*20;  }
                if(traitNum==1) { trait = "Crazed"; stats[2]--;                                           }
                done = true;  
            }
            // if(race==3&&player.level>=6)
            // { this.name =  "Duergar";                                                                                EQUIPMENT STUFFZ IMPLEMENT FIRST PLOX 
            //  stats[0]=8; stats[1]=2; stats[2]=2; stats[3]=5; stats[4]=9; stats[5]=4; health = stats[4]*20;
            //  int colour = generator.nextInt(3);
            //  if(colour==0) { color = "Brown"; }
            //  if(colour==1) { color = "Black"; stats[3]++; }
            //  if(colour==2) { color = "Green"; }
            //  int traitNum = generator.nextInt(2);
            //  if(traitNum==0) { trait = "Thick Skinned"; stats[3]++; stats[4]++; health = stats[4]*20;  }
            //  if(traitNum==1) { trait = "Crazed"; stats[2]--;                                           }
            //  done = true;  
            // }
    }
}
}
