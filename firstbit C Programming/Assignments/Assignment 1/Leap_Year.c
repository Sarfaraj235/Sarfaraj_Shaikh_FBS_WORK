#include<stdio.h>

int main(){
	
	int year = 2012;
	
	if(year % 4 == 0){
		
		if( year % 100 != 0 || year % 400 == 0){
			
			printf("%d Is A Leap Year", year);
		}
		else
		{
		 	 printf("%d Is Not A Leap Year", year);	
		}
	
}
}