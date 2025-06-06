#include<stdio.h>

int main(){
	
 int num1, num2, num3;

  printf("Enter The Three Numbers : ");	
  scanf("%d %d %d", &num1, &num2 , &num3);
  
  if(num1>num2){
  	
  		if(num1>num3){
  			
  			printf("%d Is The Greatest Number", num1);
		}
		else
		{
		  printf("%d Is The Greatest Number", num3);	
		}
  }
    else
   {
   	    if(num2>num3){
   	 	
   	 	printf("%d Is The Greatest Number", num2);
   	 	
		}
		else{
			printf("%d Is A Greatest Number", num3);
		}
  	
  	
	}	
}