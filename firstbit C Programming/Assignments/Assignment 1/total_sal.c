#include<stdio.h>

int main(){
	
	int basis = 16000;
	int da, ta, hra,total_salary;
	
	if(basis<=5000){
		
		da = basis * 0.10;
		ta = basis * 0.20;
		hra = basis * 0.25;
	}
	else
	{
		da = basis * 0.15;
		ta = basis * 0.25;
		hra = basis * 0.30;
	}
	
	total_salary = basis + da + ta + hra;
	printf("Total Salary Is %d", total_salary);

}