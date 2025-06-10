#include<stdio.h>
void isarmstrong(int);
int noofdigits(int);
int sumofdigits(int);
int power1(int,int);

void isarmstrong(int n){
	
	if(sumofdigits(n)==n){
		
		printf("\nArmstrong");
	}
	else
	{
		printf("\nNot Armstrong");
	}
}

int power1(int x ,int y){
	
	int result = 1;
	
	int i =1;
	
	while(i<=y){
		
         result = result * x;
        
	   	i++; 
	}

	return result;
		
}

int sumofdigits(int n){
	
	int sum = 0;
	int digits = noofdigits(n);
		
	while(n>0){
		
		
		int lastd = n % 10;
		sum = sum + power1(lastd,digits);
		n = n / 10;
	
	}
	
	return sum;
}


int noofdigits(int n){
	
	int digits = 0;
	
		while(n>0){
			
			n = n / 10;
			
			int ld = n % 10;
			
			digits++;	
		}
			return digits;
}

int main(){
	
	int num;
	printf("Please Enter The Number : ");
	scanf("%d", &num);
		
	isarmstrong(num);
	  
}

