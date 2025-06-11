#include<stdio.h>

int fact(int lastdigit){
	
	int fact1=1;
	
	for(int i = 2 ;   i<=lastdigit; i++){
		
		fact1 = fact1 * i;
	}
	return fact1;
	
}
int main(){
	
	int num;
	
	printf("Enter The Number : ");
	scanf("%d", &num);
	
	for(int i = 1; i<= num; i++){
		
		int sum = 0;
		int temp = i;
		
		for(;temp>0;){
			
			int lastdigit = temp % 10;
			
		    sum = sum + fact(lastdigit);
			
			temp = temp / 10;
		}
		
		if(i==sum){
			printf("%d\n",i);
		}
		
	}
}