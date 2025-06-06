#include<stdio.h>

int main(){
	
	int hr, min, sec;
	
	printf("Please Enter Hours : ");
	scanf("%d", &hr);
	
	printf("Please Enter Minutes : ");
	scanf("%d", &min);
	
	printf("Please Enter Seconds : ");
	scanf("%d", &sec);	
	
	int total_sec = (hr * 3600) + (min * 60) + sec;
	
	printf("Total Seconds Is : %d", total_sec);
	
}