#include<stdio.h>
void numcheck(int);

void numcheck(int num){
	
	if(num>0) printf("%d Is A Positive Number",num);	
	
	if(num<0) printf("%d Is A Negative Number",num);
	
	if(num==0) printf("%d Is A Neutral(0) Number",num);
	
	}
int main(){
	
	int num;
	
	printf("Enter The Number : ");
	scanf("%d",&num);
	
	numcheck(num);
	
	
}