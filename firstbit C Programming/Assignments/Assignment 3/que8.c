#include<stdio.h>

int lastdigit(int);

void isstrong(int sum, int num){
	
	if(sum==num) printf("Strong");
	
	else printf("Not Strong");
}


int factorial(int lastdigit){
	
	int fact = 1;
    int i = 1;

	while(lastdigit>=i){
		
		fact = fact * i;
		
		i++;
	}
	return fact;
}


int main(){
	
	int num = 40585;
	
    int temp = num;
    
    int sum = 0;
    
    while(temp>0){
    	
    int lastdigit = temp % 10;
    
    sum = sum + factorial(lastdigit);	
     
     temp = temp / 10;
     
	}
	
	isstrong(sum,num);
	
}