#include<stdio.h>

int main(){
	
	int age;
	
	printf("Enter Your Age : ");
	scanf("%d", &age);
	
	if(age<12) printf("child");
	
	else if(age>12 && age<19) printf("Teenager");
	
	else if(age>20 && age<59) printf("Adult");
	
	else if(age>59) printf("Senior2");
}