#include<stdio.h>

int main(){
	
	int num;
	
	printf("Enter The Number : ");
	scanf("%d", &num);
	
	if(num%3 == 0){
		
		if(num%5==0){
			
			printf("%d Is Divisible By Both",num);
		}
		else{
			printf("%d Is Divisible by 3 but not by 5",num);
		}
	}
	else
	{
		if(num%5==0){
			
			printf("%d Is Divisible by 5 but not by 3",num);
		}
		else
		{
			printf("%d Is Divisible by None",num);
		}
		
	}
	
}