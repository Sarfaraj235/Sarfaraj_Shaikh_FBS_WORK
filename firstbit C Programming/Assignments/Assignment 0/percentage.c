#include<stdio.h>

int main(){


	float phy, chem, math, eng, bio, total_marks, percentage;

	phy = 79;
	math = 87;
	eng = 67;
	bio = 92;
	chem = 83;

	total_marks = phy + chem + eng + bio + math;

	percentage =( total_marks / 500 ) * 100;

	printf("percentage : %f", percentage);

}
