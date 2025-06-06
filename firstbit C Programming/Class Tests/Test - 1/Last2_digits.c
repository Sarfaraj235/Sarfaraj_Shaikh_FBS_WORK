#include<stdio.h>

int main(){
	
	int num,ld;
	
	printf("Please , Enter The Number : ");
	scanf("%d", &num);
	
	ld = num % 100;
	
	printf("Last Two Digits Of %d Is : %d " ,num, ld);
	
}