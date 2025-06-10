#include<stdio.h>

int main(){
	
	int num = 5, fact = 1;
	
	int i = 1;
	
	while(i<=num){
		
		fact = fact * i;
		i++;
	}
	printf("%d",fact);
	
}