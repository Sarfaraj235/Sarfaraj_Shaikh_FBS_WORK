#include<stdio.h>


int main(){
	
	int num1, num2,result;
	char op;
	
	printf("Enter Two Numbers : ");
	scanf("%d %d",&num1,&num2);
	
    printf("\nOperation : ");
	printf("\n\n1 Addition \n2 Substraction\n2 Multiplication\n2 Division\n5 Modulus");
	
    printf("\n");
	printf("\nChoose Your Choice : ");
	scanf( " %c", &op);
	
	if(op == '+') result = num1 + num2;	
		
	
    else if(op == '-') result = num1 - num2;	

	
	else if(op == '*') result = num1 * num2;	
		
	
	else if(op == '/') result = num1 / num2;	
	
	
	else if(op == '%') result = num1 % num2;	
		
	printf("\nResult Of The Operation Is : %d", result);
}
