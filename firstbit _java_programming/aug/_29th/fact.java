package aug._29th;

class FactCalculate
{
   public static void main(String args[]){

       fact(4);

   }
   public static void fact(int num){
   int fact = 1;
   for(int i = 1; i <=num ; i++){

       fact = fact * i;
   }
      System.out.println("Factrorial of " + (num) + " is " + (fact)); 
  }
}