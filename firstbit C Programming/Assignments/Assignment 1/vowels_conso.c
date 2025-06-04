#include<stdio.h>

int main(){
	
	char ch = 'B';
	
	int lowercase, upparcase;
	
	 lowercase = (ch== 'a'|| ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
	
	 upparcase = (ch== 'A'|| ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
		
    if(lowercase || upparcase){
    	
    	printf("%c Is The vowel",ch);
	}
   else
   {
	printf("%c The Consonant",ch);
	}
	
}