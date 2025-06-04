#include<stdio.h>

int main()
{
	int n = 345;
	
	int r1 = n % 10;
	
	int q1 = n / 10;
	
	int r2 = q1 % 10;
	
	  q1 = q1 / 10;
	
	
	int rev = r1 * 100 + r2 * 10 + q1;
	
    if(rev == n) printf("%d is palindrome",n);
    else printf("%d is not palindrome",n);
}