#include<stdio.h>

int main(){
	
	int minutes, hours;
	
	minutes = 170;
	
	hours = minutes * 1 / 60;
	
	minutes = minutes % 60;
	
	printf("After Converting Minutes to Hours is : %d hour & %d minutes" , hours, minutes);
		
}