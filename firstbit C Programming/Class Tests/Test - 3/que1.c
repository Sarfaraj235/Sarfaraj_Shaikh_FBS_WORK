#include<stdio.h>

void printodd(int start , int end){


while(start<=end){
	
	if(start%2!=0){
		
		printf("%d ",start);	
     }
     start++;
}

}


void printeven(int start , int end){


while(start<=end){
	
	if(start%2==0){
		
		printf("%d ",start);	
     }
     start++;
}

}

int main(){
	
	printf("Even Numbers : ");
	printeven(1,50);
	
	printf("\nOdd Numbers : ");
	printodd(10,40);
	
	
}