#include<stdio.h>

int main(){
	
	int num;
	
	printf("Enter The Number : ");
	scanf("%d", &num);
	
	int i;
	int count;
	
	for(i = 2; i<=num; i++){
		
		count = 0;
		
		for(int j = 2; j<i; j++){
			
			if(i%j==0){
				
				count++;
				
			}
		}
		
		if(count==0){
			printf("%d\n",i);
		}
	}
}