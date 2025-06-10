#include<stdio.h>
int divisiors(int);


void isperfect(int n){
	
	if(divisiors(n)==n){
		printf("\nperfect");
	}
	else{
		printf("\nNot Perfect");
	}
}

divisiors(int num){
	
	int factors = 0;
	int i = 1;
	int add=0;
	
	while(i<num){
		
		if(num%i==0){
		
		add = add + i;
		
		}
		
		i++;
	}
	  return add;
	
}
    int main(){
	
	int num = 6;

	isperfect(num);
}