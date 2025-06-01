#include<stdio.h>

int main(){
	
float phy, chem , bio, math , eng, total_marks, percentage;

phy = 78;
chem = 67;
bio = 87;
math = 90;
eng = 70;

total_marks= phy + chem + bio + math + eng;

percentage = (total_marks / 500) * 100;

printf("percentage : %.2f", percentage); 

}