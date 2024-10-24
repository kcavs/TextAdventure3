import java.util.*;


public class Player
{
 String name;
 boolean it;
 boolean hasKey;
 public Player(String playerName,boolean guilt)
 {
   name=playerName;
   it=guilt;
   // ADD CODE HERE
 }


 public String getName()
 {
   return name;
 }
 public boolean isIt()
 {
   return it;
 }
 public void setName(String x)
 {
   name=x;
 }
 public void setRole()
 {
   int x= (int)(Math.random()*2);
   if(x==0){
     it=true;
   }
   else{
     it=false;
   }
 }
 public void setKey(){
   hasKey=true;
 }
 public boolean getKey(){
   return hasKey;
 }
}

