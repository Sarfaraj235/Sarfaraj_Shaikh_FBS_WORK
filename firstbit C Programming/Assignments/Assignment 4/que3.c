// Print armstrong numbers in the given range 1 to n. 

#include<stdio.h>
#include<math.h>

int countdigits(int);

int countdigits(int i){
	
	int j,ls,digits = 0;
	
	for(; i>0;){
		
		ls = i % 10;
	    i = i/10;
	   	
		digits++;
	}
  
	return digits;
}
int main(){
	
	int num;
	
	printf("Enter The Number : ");
	scanf("%d", &num);

	for(int i = 1; i<=num; i++){
		
		int temp = i;
	    int sum = 0;
	     
		for(;temp>0;){
				
			int countd = countdigits(i);
			
			int lastdigit = temp % 10;
			
			sum = sum + pow(lastdigit,countd);
			
			temp = temp / 10;
		}
	
		if(i==sum){
			
			printf("%d\n", i);
		}
		
	}
	
}

