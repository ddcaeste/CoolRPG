public class Texts
{
            public static void printIntro(Boss boss) throws InterruptedException
            {
            if(boss.race=="Pitlord") 
            {
                System.out.println("* You set out to a remote village. When you arrive, it seemed to have been burned to the ground...");
                Thread.sleep(3000);
                for (int i=0; i<100; ++i) System.out.println();
                System.out.println("* What happened here?");
                Thread.sleep(3000);
                for (int i=0; i<100; ++i) System.out.println();
                System.out.println("* It does not take long before you find the source of this damage. In the middle of the village, a demonic portal looms.");
                Thread.sleep(3000);
                for (int i=0; i<100; ++i) System.out.println();
                System.out.println("* You enter, and prepare for the worst...");
                Thread.sleep(3000);
                for (int i=0; i<100; ++i) System.out.println();
                System.out.println("* Mortal, you have come to your death. I am " + boss.bossFullName + " and I will take your soul.");
                Thread.sleep(3000);
                for (int i=0; i<100; ++i) System.out.println();
            }
            if(boss.race=="Orc Warlord")
            { 
                    System.out.println("* You set out to a remote village. When you arrive, it seemed to have been burned to the ground...");
                    Thread.sleep(3000);
                    for (int i=0; i<100; ++i) System.out.println();
                    System.out.println("* What happened here?");
                    Thread.sleep(3000);
                    for (int i=0; i<100; ++i) System.out.println();
                    System.out.println("* All of a sudden, a large looming figure steps out of the remains of the church.");
                    Thread.sleep(3000);
                    for (int i=0; i<100; ++i) System.out.println();
                    System.out.println("* His teeth are sharp, his stature mighty, and his skin green. This'll be one heck of a fight.");
                    Thread.sleep(3000);
                    for (int i=0; i<100; ++i) System.out.println();
                    System.out.println("* " + boss.bossFullName + " iz da biggest and meanest of all Orkz! WAAAAGH.");
                    Thread.sleep(3000);
                    for (int i=0; i<100; ++i) System.out.println();
           }
           if(boss.race=="Void Fiend") 
           {  
                    System.out.println("* You wake up in a strange place. You cannot see anything and you hear cackling all around you.");
                    Thread.sleep(3000);
                    for (int i=0; i<100; ++i) System.out.println();
                    System.out.println("* Voices whisper to you in an alien language. You feel dizzy and confused.");
                    Thread.sleep(3000);
                    for (int i=0; i<100; ++i) System.out.println();
                    System.out.println("* Then, the lights go on. A creature stands in front of you.");
                    Thread.sleep(3000);
                    for (int i=0; i<100; ++i) System.out.println();
                    System.out.println("* It swirves and floats in the air. Whatever this is, it deserves to get sent back to whatever god made it.");
                    Thread.sleep(3000);
                    for (int i=0; i<100; ++i) System.out.println();
                    System.out.println("* " + boss.bossFullName + " welcomes you to the void. Please, do stay here. Forever.");
                    Thread.sleep(3000);
                    for (int i=0; i<100; ++i) System.out.println();
         }
         if(boss.race=="Nightmare") 
         { 
                System.out.println("* As you travel, you come across a strange, deserted caravan.");
                Thread.sleep(3000);
                for (int i=0; i<100; ++i) System.out.println();
                System.out.println("* Just when you decide to move on, a horse appears from behind one of the carriages.");
                Thread.sleep(3000);
                for (int i=0; i<100; ++i) System.out.println();
                System.out.println("* You stumble back when it suddenly erupts in flames and charges at you.");
                Thread.sleep(3000);
                for (int i=0; i<100; ++i) System.out.println();
                System.out.println("* You brace yourself. Demonkind has sent a special gift for you today, it seems.");
                Thread.sleep(3000);
                for (int i=0; i<100; ++i) System.out.println();
        }
    }
}
        