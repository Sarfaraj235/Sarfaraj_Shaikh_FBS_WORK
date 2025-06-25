#include<stdio.h>

double billcal(double);


double billcal(double units){
	
	double bill;
	
	if(units<=50 && units>0) return bill = units * 30;
	else if(units>=51 && units<=150) return bill = units * 40;
 	else if(units>=151) return bill = units * 50;
 	
}
	
int main(){

 double units;
 
 printf("Enter Total Units : ");
 scanf("%lf", &units);
 
 double total_bill = billcal(units);
 
 printf("Total Bill Is : %.2lf",total_bill);
 
}