#include<stdio.h>

int main(){
	
	int marks;
	
	printf("please Enter Your Marks : ");
	scanf("%d", &marks);
	
	if(marks>=75){
		
		printf("Distinction" );
	}
	else
	{
		if(marks>=65){
			
			printf("First Class");
		}
		else
		{
			if(marks>=55){
				
				printf("Second Class");
			}
			else
			{
				if(marks>=40){
					
					printf("pass class");
				}
				else
				{
					if(marks>=0 && marks<40){
						
						printf("fail");
					}
				}
			}
			
		}
		
	}
	
	
}