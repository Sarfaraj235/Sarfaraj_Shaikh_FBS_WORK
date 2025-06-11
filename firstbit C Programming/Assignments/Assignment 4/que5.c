// menu driven program to take a number for user and perform operations

#include<stdio.h>

void menu();
void choice(int);
void evenodd(int);
void prime(int);
void pallindrome(int);
void pos_neg(int);
void reverse(int);
void sumofdigits(int);

void sumofdigits(int num){
	
	int sum = 0;
	int temp = num;
	
	while(temp>0){
		
		int lastdigit = temp % 10;
		sum = sum + lastdigit;
		temp = temp / 10;
	}
	
	printf("Sum Of Digits Of Number %d Is : %d",num,sum);

}

void reverse(int num){
	
	int rev = 0;
	
	while(num>0){
		
		int lastdigit = num % 10;
		rev = rev * 10 + lastdigit;
		num = num / 10;
	}
	printf("After Reversed Number is : %d",rev);
}

void pos_neg(int num){
	
	if(num>0) printf("%d Is A Positive Number",num);
	else if(num<0) printf("%d Is A Negative Number",num);
    else if(num==0) printf("Zero");
}

void pallindrome(int num){
	
	int rev = 0;
	int temp = num;
	
	while(temp>0){
		
		int lastdigit = temp % 10;
		rev = rev * 10 + lastdigit;
		temp = temp / 10;
	}	
	if(rev == num) printf("%d Is A Pallindrome Number", num);
	else printf("%d Is Not A Pallindrome Number", num);
}

void prime(int num){
	
	int count = 0;
	
	for(int i = 2; i<num; i++){
		
		if(num % i == 0){
			
			count++;
			
		}
		
	}
	
    	if(count==0) printf("%d Is Prime Number",num);
		
		else printf("%d Is Not Prime Number",num);
}

void evenodd(int num){
	
	if(num%2==0) printf("%d Is Even Number",num);
	else
	printf("%d Is Odd Number",num);
}

void choice(int num){
	
	int choice;
	
	printf("Please, Enter Your Choice (1 to 6) : ");
	scanf("%d", &choice);
	printf("\n");
	
	
	if(choice>0 && choice<7){
		
		if(choice==1){
			
			evenodd(num);
		}
		
		else if(choice==2){
			
			prime(num);
		}
		
		else if(choice==3){
			
			pallindrome(num);
		}
		
		else if(choice==4){
			
			pos_neg(num);
		}
		else if(choice==5){
			
			reverse(num);
		}
		
		else if(choice==6){
			
			sumofdigits(num);
			
		}
			
	}
	else{
		
		printf("You Entered Incorrect Choice !\n");
		printf("Try Again !!!");
	}
	
}

void menu(){
	
	int num;
	
	printf("Please Enter The Number : ");
	scanf("%d", &num);
	
	printf("\nMenu : \n");
	printf("\n");
	
	printf("Press 1. To check number is even or odd.\n");
	printf("Press 2. To check number is prime or not.\n");
	printf("Press 3. To check number is pallindrome or not.\n");
	printf("Press 4. To check number is positive, negative or zero.\n");
	printf("Press 5. To reverse a number.\n");
	printf("Press 6. To find sum of digits.\n");
	printf("\n");
	
	choice(num);
	
}
int main(){
	
	menu();
	printf("\n");
	printf("\n            -- Developed By Sarfaraj Shaikh !");
		
}