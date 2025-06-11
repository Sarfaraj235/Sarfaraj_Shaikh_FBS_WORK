// print 1 to n perfect number

#include<stdio.h>     

int main(){
	
	int num;
	
	printf("Enter The Number : ");
	scanf("%d", &num);
	int i;
	int sum;
	
	for(i = 1; i<=num; i++){
		
		sum = 0;
			
		for(int j = 1; j < i; j++){
		
	   		if(i % j ==0){
	   		sum = sum + j;
	   	
	  		 }
	   
		}
	  if(i==sum){
	  	
	  	printf("%d\n",i);
	  }
	}
}