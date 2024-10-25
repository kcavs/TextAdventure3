import java.util.*;


public class TextAdventure
{
 FancyConsole console;
 Scanner inScanner;
 Player ourHero;


 public TextAdventure()
 {
   console = new FancyConsole("Great Text Adventure!", 800, 800);
   inScanner = new Scanner(System.in);


   // feel free to change the player's starting values
   ourHero = new Player("defult",false);
 }


 public void play()
 {
   String input;
   String instruct;
   String role;
   // start of adventure. You can change this if you like
   console.setImage("door.jpeg");


   // ask the user for their name.
   System.out.println("What is your name?: ");
   input = inScanner.nextLine();
   ourHero.setName(input);
   ourHero.setRole();
   if(ourHero.isIt()){
     role="hunter";
     instruct="someone here is dangerous. take them out";
   }
   else{
     role="civilian";
     instruct="survive and escape";
   }
   System.out.println("You wake up in a room alone\nAs you try to get a grip on your surroundings, you look up to see...\nthe word "+role+" and the instructions to "+instruct);
   System.out.println("You look around to see 5 doors, which route would you like to take?\n door 1 leades to a dark hallway\ndoor 2 leads to a big room\ndoor 3 leads to the kitchen\ndoor 4 leads to outside\ndoor 5 leaders to a small bedroom\n: ");
   input = inScanner.nextLine();
   if(input.equals("1")){
     enterZone1();
   }
   if(input.equals("2")){
     enterZone2();
   }
   if(input.equals("3")){
     enterZone3();
   }
   if(input.equals("4")){
     enterZone4();
   }
   if(input.equals("5")){
     enterZone5();
   }


 }


 private void enterZone1(){
  console.setImage("room1.jpg");
  // get character here
  System.out.println("watson: hi, im watson, whats your name... huh "+ourHero.getName()+" interesting..\nwatson: well nice to meet you");
  if(!ourHero.isIt()){
    boolean isWat=true;
    System.out.println("watson: this whole thing feels sort of weird you know?");
    System.out.println("what will you back:\na.yeah i guess\nb.what whole thing?\n: ");
    String res = inScanner.nextLine();
    if((res.equals("a"))||(res.equals("A"))){
      System.out.println("watson: well look at you all quiet, you better toughen up.... before you get hurt");
      System.out.println("suddenly he grabs your arm hard enough to make a bruise, and whispers\nwatson: don't you dare make a sound\nyou can either\na.scream anyway\nb.stay quiet but attack\nc.stay quiet and go along with him\n: ");
      String choice=inScanner.nextLine();
      if((choice.equals("a"))||(choice.equals("A"))){
        System.out.println("you open your mouth, but before any sound could come out you felt a small sensation and your world turned black");
        console.setImage("lose.png");
        gameEnd();
      }
      else if((choice.equals("c"))||(choice.equals("C"))){
        System.out.println("you try to stay silent to think of a plan, but before you can think, your world goes dark");
        console.setImage("lose.png");
        gameEnd();
      }
      else{
        System.out.println("you stay silent, letting him think he has won, but before he can do anything you bite down on his hand and kick his legs out, running back the way you came");
       enterZone6();
       }
     } 
     else{
       System.out.println("nothing kid, im just talking to myself...\nanyway, you should go run off and explore");
       enterZone6();
     }
   }
   else{
     System.out.println("you look at watson suddenly getting what you need to do\n he looks at you strangly too, and you brush of the feeling of discomfort\ndo you either want to \na.attack him\nb.spare him");
     System.out.println("it is a 50% you will suceed, so chose wisely: ");
     String x= inScanner.nextLine();
     if((x.equals("a"))||(x.equals("A"))){
       int iff=(int)(Math.random()*2);
       if(iff==0){
         console.setImage("win.jpeg");
         System.out.println("you attack watson, and sucessfully manage to win the game");
         console.setImage("win.jpeg");
         gameEnd();
       }
       else{
         System.out.println("you go to attack watson, but are detered by his screaming for help, as well as him fighting back. the others catch you");
         console.setImage("lose.png");
         gameEnd();
       }
     } 
   }
 }
 private void enterZone2()
 {
   console.setImage("dog.jpeg");
   System.out.println("you look around the large room to see..... a dog?\nwhat do you do?\na.pet it\nb.run away\n: ");
   String d=inScanner.nextLine();
   if(!((d.equals("b"))||(d.equals("B")))){
     System.out.println("you try to pet the dog, but suddenly it starts barking loudly and trying to bite you!\nscared,");
   }
   System.out.println("you quickly run out of the room");
   enterZone6();
 }


 private void enterZone3()
 {
  console.setImage("kitchen.jpg");
  System.out.println("you walk into the room to see a bright kitchen. the oven is on and there is a woman who apears to be baking something");
  System.out.println("claire: hi, my names claire, you're " +ourHero.getName()+" right?\nclaire:why did I know that, well why not?\nclaire:i'm bakking a cake right now, might as well find something to do right?");
  System.out.println("what are you going to say:\na.you're not even concerned?\nb.i mean, whatever you want\nc.say nothing\n: ");
  String ask= inScanner.nextLine();
  if((ask.equals("a"))||(ask.equals("A"))){
    System.out.println("claire: well what is there to be concerned about?");
    System.out.println("a.i don't know, maybe the fact that we're stuck!!\nb. nothing, just wondering\n: ");
    String a= inScanner.nextLine();
    if((a.equals("a"))||(a.equals("A"))){
      System.out.println("claire: are you sure about that?\nshe pulls out a key from her pocket\nclaire: you seem nice, and im having fun here, so take this\nclaire: find where to use it, you will know when...");
      ourHero.setKey();
    }
    if((a.equals("b"))||(a.equals("B"))){
      System.out.println("claire: i see. well, I need to concentrate, so if you could leave now that'd be great");
    }
  }
  if((ask.equals("b")||(ask.equals("B")))){
    System.out.println("claire: whats that supposed to mean anyway");
    System.out.println("a.nothing, just a bit worried\nb.nothing,sorry\n: ");
    String g=inScanner.nextLine();
    if((g.equals("a"))||(g.equals("A"))){
      System.out.println("claire: well I have sonmething that might make you feel a little better\nshe pulls out a key\nclaire: here, take this");
      ourHero.setKey();
    }
    if(!((g.equals("a"))||(g.equals("A")))){
      System.out.println("claire: well if you're just going to stand there being annoying then scram");
    }
   }
   if((ask.equals("c"))||(ask.equals("C"))){
     System.out.println("claire: i see. well, I need to concentrate, so if you could leave now that'd be great");
   }
   System.out.println("you leave the room confused with who you just met");
   enterZone6();


  
 }


 private void enterZone4(){
  console.setImage("back.jpeg");
  System.out.println("you walk outside to see that it is dark and cold. \nyou pull your arms around you to warm youself up... \nwhen you see something in the corner");
  if(ourHero.getKey()){
    System.out.println("its a gate in the fence with a key hole!\n this must be what claire was talking about");
    System.out.println("do you want to:\na.try the key in the lock\nb.stay and explore more\n: ");
    String r=inScanner.nextLine();
    if((r.equals("a"))||(r.equals("A"))){
      System.out.println("it works!\nyou open the gate and escape, never coming back again");
      console.setImage("win.jpeg");
      gameEnd();
    }
    else{
      System.out.println("you turn away, going back to where you began");
      enterZone6();
    }
   }
   else{
     System.out.println("a gate with a key hole...\nwhat do you want to do?\na.try and pick the lock\n.b.give up and go back inside\n: ");
     String f=inScanner.nextLine();
     if((f.equals("a")||(f.equals("A")))){
       System.out.println("you find a stick on the ground and put it in the hole, moving it around wildy\nit seems like its working but.... nothing");
     }
     System.out.println("to bad you don't have a key\nyou turn and go back to where you began");
     enterZone6();
   }
 }   
 private void enterZone5()
 {
  console.setImage("bed.jpeg");
  System.out.println("you enter a small bedroom, half the size of the kitchen\nyou hear a sound that sounds like it is from the closet, but when you look in it is empty\n....weird");
  System.out.println("what do you do to fill the eerie silence\na.sing to yourself\nb.pace\nc.nothing\n: ");
  String next=inScanner.nextLine();
  if(ourHero.isIt()){
    System.out.println("...but wait whats that\n you reach down and pick up a note, with the words \"beware of wa-\" ending suddenly with a scrible");
  }
  System.out.println("you frantically run out the room, having learnt nothing from your time");
  enterZone6();
 }


 private void enterZone6()
 {
  console.setImage("door.jpeg");
  System.out.println("you are back at the start");
  System.out.println("You look around to see 5 doors, which route would you like to take?\n door 1 leades to a dark hallway\ndoor 2 leads to a big room\ndoor 3 leads to the kitchen\ndoor 4 leads to outside\ndoor 5 leaders to a small bedroom\n: ");
  String input = inScanner.nextLine();
   if(input.equals("1")){
     enterZone1();
   }
   if(input.equals("2")){
     enterZone2();
   }
   if(input.equals("3")){
     enterZone3();
   }
   if(input.equals("4")){
     enterZone4();
   }
   if(input.equals("5")){
     enterZone5();
   }
 }
 private void gameEnd()
 {
   // ADD CODE HERE


   inScanner.close();
 }
}
