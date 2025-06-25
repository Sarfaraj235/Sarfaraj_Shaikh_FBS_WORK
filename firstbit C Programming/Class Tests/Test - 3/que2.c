#include<stdio.h>

void sum(int start, int end){
	
	int sum = 0;
	
	while(start<=end){
		
		sum = sum + start;
		start = start + 2;
	}

	printf("%d", sum);
}
   
int main(){
	
	sum(1,10);
	
}