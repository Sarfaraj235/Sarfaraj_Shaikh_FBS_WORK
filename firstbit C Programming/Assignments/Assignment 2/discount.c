#include<stdio.h>

int main(){
	
	float price,finalprice;
	float disc = 0;
	char choice;
	
	
	
	printf("Enter The Price : ");
	scanf("%f", &price);
	
	printf("Are you A Student ? (Y/N): ");
	scanf(" %c",&choice);
	
	if(choice == 'Y' || choice == 'y'){
		
		if(price>500){
			
			disc = price * 0.20;
			finalprice = price - disc;
		}
		else
		{
			disc = price * 0.10;
			finalprice = price - disc;
		}
	}
	else
	{
		if(price>600){
			
		  	disc = price * 0.15;
			finalprice = price - disc;	
		}
		else
		{
			finalprice = price;
		}
		
	}
	if(disc != 0)
	{
		printf("Your actual price was %.2f with total discount of %.2f you have to pay %.2f",price,disc,finalprice);
	}
	else
	{
		printf("finalprice is %.2f With No Discount",finalprice);
	}

}