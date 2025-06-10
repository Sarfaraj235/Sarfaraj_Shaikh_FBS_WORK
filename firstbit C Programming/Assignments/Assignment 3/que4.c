#include<stdio.h>

int main(){
	
	int n = 7;
	int i = 1;
	int count = 0;
	
	while(n>=i){
		
		if(n%i==0){
			
		count++;
			
		}
			
		i++;
	}
	
	if(count>2) printf("Not prime");
	else printf("Prime");
	
}