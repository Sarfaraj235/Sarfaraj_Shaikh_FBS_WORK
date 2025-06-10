#include<stdio.h>

int reverse(int num){
	
	int rev = 0;
	
	while(num>0){
		
		int lastdigit = num % 10;
		rev = rev * 10 + lastdigit;
		num = num/ 10;
	}
	
	return rev;
}


void ispalindrome(int num){
	
	if(reverse(num) == num){
		printf("palindrome");
	}
	else{
		printf("Not palindrome");
	}
	
}



int main(){
	
	int num = 121;
	
	ispalindrome(num);	
	
}