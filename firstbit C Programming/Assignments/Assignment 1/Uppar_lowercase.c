#include<stdio.h>

int main(){
	
	char ch = 'B';
		
	if(ch >= 'A' && ch <= 'Z'){
		
		printf("%c Is Upparcase Letter", ch);
	}
	else if(ch >= 'a' && ch <= 'b'){
		
		printf("%c Is Lowercase Letter", ch);
	
	}
	else
	{
		printf("%c Is Not A Albhabet", ch);
	}	
}