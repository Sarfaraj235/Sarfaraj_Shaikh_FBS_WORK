#include<stdio.h>

int main(){
	
	int a,b,c;
	
	printf("Enter Three Sides Of Triangle : ");
	scanf("%d %d %d", &a,&b,&c);
	
	if(a==b && b==c){
		
		printf("Triabgle is Equilateral");
		
	}
	else if(a==b || b==c){
		
			printf("Triabgle is isosceles");
	}
	else
	{
	 	printf("Triabgle is Scalene");
			
    }

}