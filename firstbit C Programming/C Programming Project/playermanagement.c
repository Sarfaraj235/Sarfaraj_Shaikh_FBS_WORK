//Player Management System 

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int max_limit = 10;

typedef struct Cricket{
    int jersey_no;
    char name[20];
    int runs;
    int wickets;
    int match_played;   
} Cricket;

void menu_display();
void add_player(Cricket**,int*, int*);
int validatedup(Cricket* ,int ,int);
void get_valid_value(const char*, int*);
void get_valid_name( char*, int);
int get_valid_ch(char*);
void matchesPlayed_value(const char*, int*);
void displayRecords(Cricket* , int);
int searchby_jerseyno(Cricket*,int ,int);
void displayfoundrecord(Cricket*, int);
int searchbyname(Cricket*,char*);
int comparestr(char*, char*);
void removebyjerseyno(Cricket*, int*,int, int*);
void removebyname(Cricket*,int*, char*, int*);
void matches_played_upvalue(const char*, int*);
void updatebyjerseyno(Cricket*,int*, int);
void displaySortedRecords(Cricket*, int);
void display_based_on_runs(Cricket*,int);
void display_based_on_wickets(Cricket*,int);

void display_based_on_wickets(Cricket* temp, int no_of_players){
	for(int i = 0; i<no_of_players; i++){
		for(int j = 0; j<(no_of_players-i-1); j++){
			if(temp[j].wickets<temp[j+1].wickets){
				Cricket t = temp[j];
				temp[j] = temp[j+1];
				temp[j+1] = t;
				
			}
		}
	}
	displayRecords(temp, no_of_players);	
}


void display_based_on_runs(Cricket* temp, int no_of_players){
	for(int i = 0; i<no_of_players; i++){
		for(int j = 0; j<(no_of_players-i-1); j++){
			if(temp[j].runs<temp[j+1].runs){
				Cricket t = temp[j];
				temp[j] = temp[j+1];
				temp[j+1] = t;
			}
		}
	}
	displayRecords(temp, no_of_players);	
}


void displaySortedRecords(Cricket *total_players, int no_of_players){
	Cricket temp[no_of_players] ;
	
	for(int i = 0; i<no_of_players; i++){
		temp[i].jersey_no= total_players[i].jersey_no;
		strcpy(temp[i].name, total_players[i].name);
		temp[i].runs= total_players[i].runs;
		temp[i].wickets= total_players[i].wickets;
		temp[i].match_played= total_players[i].match_played;	
	}
	int choice;
    
	printf("\n=== Display Leading Performances Options ===\n");
	printf("\n1. Based on Runs\n");
	printf("2. Based on Wickets\n");
	printf("\nEnter your choice: ");
	scanf("%d", &choice);
    
	switch(choice){
		case 1:
			display_based_on_runs(temp, no_of_players);
			break;
			
		case 2 :
			display_based_on_wickets(temp, no_of_players);
			break;
			
		default :
			 printf("\nInvalid choice! Please enter 1 or 2.\n");
			 break;
	}
	
}

void matches_played_upvalue(const char *prompt, int *val){
    int value;
    while(1){	
        printf("%s", prompt);
        if(scanf("%d", &value) == 1 && value>=0) {
        	if(value==0){
        		printf("!! Warning: Matches played cannot be zero.\n");
         		continue;
			}
			else{
            *val += value;
             break;
        	}
		}
        else {
        	while (getchar() != '\n');
        	printf("!! Warning: Only positive digits are allowed; other characters are not permitted.\n");
            
        }
    }
}



void get_valid_upvalue(const char *prompt, int *val){
    int value;
    while(1){	
        printf("%s", prompt);
        if(scanf("%d", &value) == 1 && value>=0) {
            *val += value;
            break;
		}
        else {
        	while (getchar() != '\n');
        	printf("!! Warning: Only positive digits are allowed; other characters are not permitted.\n");
            
        }
    }
}

void updatebyjerseyno(Cricket* total_players,int* no_of_players,  int ujersey_no){
	int size = *no_of_players;
	int i = searchby_jerseyno(total_players,size,ujersey_no);
	if(i == -1){
	
		printf("\n\nPlayer With Jersey Number %d Was Not Found In The System.\n",total_players[i].jersey_no);
			
	}
	else{
		get_valid_upvalue("\nEnter the new number of runs for the player : " , &total_players[i].runs);
		
		get_valid_upvalue("Enter the new number of wickets for the player : ", &total_players[i].wickets);
	
		matches_played_upvalue("Enter the new number of matches played for the player : ", &total_players[i].match_played);
	
		printf("\n\nRuns, wickets, and matches played for the player with jersey number %d were updated successfully.\n",total_players[i].jersey_no);	
	}	
}



void removebyname(Cricket* total_players,int* no_of_players, char* rname, int *count){
	
	int i = searchbyname(total_players,rname);
	if(i != -1){
		for(int j = i; j<(*no_of_players)-1; j++){

			total_players[j] = total_players[j+1];
		}
		printf("\nPlayer named %s was successfully removed from the system.\n",rname);
		*no_of_players-= 1;
		(*count) -= 1;
	
	}
	else{
		printf("\nPlayer Named %s Was Not Found In The System.\n",rname);
	}
}
	
	
 
void removebyjerseyno(Cricket *total_players, int* no_of_players,int rjno, int *count){
	
	int i =  searchby_jerseyno(total_players,*no_of_players,rjno);
	if(i == -1){
		printf("\nPlayer With Jersey Number %d Was Not Found In The System.\n",rjno);
		
	}
	else{
		for(int j = i; j<(*no_of_players)-1; j++){	
			total_players[j] = total_players[j+1];
		}
		printf("\nPlayer with jersey number %d was successfully removed from the system.\n",rjno);
		(*no_of_players) -= 1;
		(*count) -= 1;	
	}	
}




int comparestr(char *str, char *findname){
	int i = 0;
	while(str[i] != '\0' || findname[i] != '\0'){
		if(str[i] != findname[i]){
			return -1;
		}
		i++;
	}
	return 1;	
}



int searchbyname(Cricket *total_players, char* findname){
	
	int i = 0;
	while(total_players[i].name[0] != '\0'){
		int res = comparestr(total_players[i].name, findname);
		if(res==1) return i;
		i++;
	}
	return -1;
}

void displayfoundrecord(Cricket* total_players, int j_index){
		printf("\n1. Jersey Number : %d\n",total_players[j_index].jersey_no);
		printf("2. Name : %s\n",total_players[j_index].name);
		printf("3. Runs %d: \n",total_players[j_index].runs);
		printf("4. Wickets %d: \n",total_players[j_index].wickets);
		printf("5. Match Played : %d\n",total_players[j_index].match_played);	
}

int searchby_jerseyno(Cricket *total_players,int size,int j_no){
	for(int i = 0; i<size; i++){
		if(total_players[i].jersey_no == j_no){
			return i;
		}
		
	}
	return -1;
}




void displayRecords(Cricket *total_players, int no_of_players){
	for(int i = 0; i<no_of_players; i++){
		printf("\nDisplaying Player %d Records : \n\n",i+1);
		printf("1. Jersey Number : %d\n",total_players[i].jersey_no);
		printf("2. Name : %s\n",total_players[i].name);
		printf("3. Runs : %d \n",total_players[i].runs);
		printf("4. Wickets : %d \n",total_players[i].wickets);
		printf("5. Match Played : %d\n",total_players[i].match_played);

	}
}


int check_option1(){
	int option;
	printf("Enter your choice: ");
	if(scanf("%d",&option) == 1){
   		if(option == 1 || option == 2) return option;
		else return -1;
	}
	else{
		while (getchar() != '\n');
		return -1;
	}
}

void matchesPlayed_value(const char *prompt, int *val){
    int value;
    while(1){	
        printf("%s", prompt);
        if(scanf("%d", &value) == 1 && value>=0) {
        	if(value==0){
        		printf("!! Warning: Matches played cannot be zero.\n");
        		continue;
			}
			else
			{
            *val = value;
        	}
            break;
		}
        else {
        	while (getchar() != '\n');
        	printf("!! Warning: Only positive digits are allowed; other characters are not permitted.\n");
            
        }
    }
}


int get_valid_ch(char* name){

	int i = 0;
	while(name[i] != '\0'){
		
		if(!((name[i]>='a' && name[i] <='z') || (name[i]>='A' && name[i] <='Z') || name[i] == ' ')){
			return 0;	
		}
		i++;
	}
	return 1;
}



void get_valid_name( char* name, int size){
	while(1){
		printf("2. Name : ");
		fgets(name, size, stdin);
		name[strcspn(name, "\n")] = '\0';
		
		if(get_valid_ch(name)){
			break;
		}
		else{
        	printf("!! Warning: Invalid name! Digits and symbols are not allowed.\n"); 
		}	
	}		
}



void get_valid_value(const char *prompt, int *val){
    int value;
    while(1){	
        printf("%s", prompt);
        if(scanf("%d", &value) == 1 && value>=0) {
            *val = value;
            break;
		}
        else {
        	while (getchar() != '\n');
        	printf("!! Warning: Only positive digits are allowed; other characters are not permitted.\n");
            
        }
    }
}



int validatedup(Cricket* total_players, int jno,int added){
	int duplicate = 0;
	
	for(int i = 0; i<added;i++){
		
		 if(total_players[i].jersey_no==jno){
			duplicate = 1;
			return duplicate;
		}
	}
	return duplicate;
}
	
	

void add_player(Cricket **total_players, int *no_of_players,int *count){
	int added = *count;
	
	for(int i = 0; i<(*no_of_players); i++){
		printf("\nAdd Player %d Records : \n\n",added+1);
		
	    get_valid_value("1. Jersey Number : ",&(*total_players)[added].jersey_no);
	    
	   	int dup_check = validatedup(*total_players,(*total_players)[added].jersey_no, added);
		
		if(dup_check != 0){
			printf("\nDuplicate jersey numbers are not allowed.\n");
            printf("Please enter a unique jersey number.\n");
            i--;
            continue;
		}
		while(getchar() != '\n');
		get_valid_name((*total_players)[added].name, sizeof((*total_players)[added].name));
		
		get_valid_value("3. Runs : ", &(*total_players)[added].runs);
		
		get_valid_value("4. Wickets : ", &(*total_players)[added].wickets);
		
		matchesPlayed_value("5. Matches Played : ",&(*total_players)[added].match_played);
	
		added++;
		
		if(added >= max_limit){
   		max_limit *= 2; 
    	*total_players = (Cricket*)realloc(*total_players, max_limit * sizeof(Cricket));
    	}
	}

	*count = added;
	*no_of_players = added;
	
	if(added>1){
		printf("\n%d player records have been successfully added to the system.\n",added);
	}
	else
	{
		printf("\n%d player record has been successfully added to the system.\n",added);
	}
}



void menu_display(){

	printf("\nThe system supports the following operations:\n");

	printf("\n1. Add Player             -> Input and store new player information.");
	printf("\n2. Remove Player          -> Delete an existing player's record.");
	printf("\n3. Search Player          -> Find player details (e.g., by Name or Jersey Number).");
	printf("\n4. Update Player          -> Modify the details of an existing player.");
	printf("\n5. Display All Players    -> Show all player records in a structured format.");
	printf("\n6. Show Top Performers    -> Based on: (Runs scored  & Wickets taken)\n");
}


int main(){
	
	// main method 
	
    printf("=============================================\n");
	printf(" Cricket Player Management System\n");
	printf(" Organizing Player Data with Precision and Ease\n");
	printf("=============================================\n");
	
	//to store in heap 
	
	Cricket* total_players = (Cricket*)malloc(max_limit * sizeof(Cricket));
    int choice;
    int no_of_players;
    int count = 0;
    char yes_no;
   
	do{   

        menu_display();
        printf("\n\nEnter your choice Between (1 to 6) from the options above: ");
        scanf("%d", &choice);
        
        
        switch(choice){
        	case 1 :                                                                             //inserting players's records
    			printf("\nEnter The Number Of Cricket Players To Add To The System: ");
    			scanf("%d",&no_of_players);
				if(no_of_players<=max_limit){
    				add_player(&total_players, &no_of_players,&count);
    				
    			}
    			else{
    				printf("\nNote: A maximum of 100 players can be added to the system.\n");
				}
				
				break;
    		
    		case 2 :
    		{ 
    			if(count==0){                                                                       // remove records by jersey no or Name
    				printf("\nNo player records found. Please add records to the system.\n");
    				break;
				}
			
				printf("\n=== Remove Player Options ===\n\n");
				printf("Press 1. Remove by Jersey Number\n");
				printf("Press 2. Remove by Name\n\n");
				int val;
				while(1){
					val = check_option1();
					if(val ==1 || val==2) break;
					if(val == -1) printf("\nIncorrect Option !!! Please, Choose Correct Option.\n\n");
				}
    		    if(val==1){
    		    	int rjno;
    		    	printf("\nEnter the jersey number of the player to be removed from the system: ");
    		    	scanf("%d", &rjno);
    		    	removebyjerseyno(total_players,&no_of_players,rjno, &count);
				}
				else if(val==2){
					char rname[20];
					printf("\nEnter the Name of the player to be removed from the system: ");
					while(getchar() != '\n');
					fgets(rname, sizeof(rname), stdin);
					rname[strcspn(rname, "\n")] = '\0';
					
					removebyname(total_players,&no_of_players,rname,&count);
				}
				break;
    		}
    		
			case 3 :	
			{
				if(count==0){                                                                       //searching player records
    				printf("\nNo player records found. Please add records to the system.\n");
    				break;
				}
				printf("\n=== Search Options ===\n\n");
				printf("Press 1. Search by Jersey Number\n");
				printf("Press 2. Search by Name\n\n");
				int val;
				while(1){
					val = check_option1();
					if(val ==1 || val==2) break;
					if(val == -1) printf("\nIncorrect Option !!! Please, Choose Correct Option.\n\n");
				}
				if(val==1){
					int j_no;
					printf("\nEnter the jersey number of the player you want to search for: ");
					scanf("%d",&j_no);
					
					int j_index = searchby_jerseyno(total_players,no_of_players,j_no);
					
					if(j_index>=0){
						
						printf("\nThe player's records were found at index %d:\n",j_index);
						displayfoundrecord(total_players,j_index);
					
					}
					else{
						printf("\nPlayer With Jersey Number %d Was Not Found In The System.\n",j_no);
					}
				}
				else if(val==2){
					
					char name[20];
					printf("\nEnter the name of the player you want to search for: ");
					while(getchar() != '\n');
					fgets(name, sizeof(name), stdin);
					name[strcspn(name, "\n")] = '\0';
					
					
					int n_index = searchbyname(total_players,name);
					
					if(n_index>=0){
						
						printf("\nThe player's records were found at index %d:\n",n_index);
						displayfoundrecord(total_players,n_index);	
					}
					else{
						printf("\nThe player named %s was not found in the system.\n",name);
					}
				}
			
				break;
			}
			case 4 :
			{
				if(count==0){                                                                      // updating player records
    				printf("\nNo player records found. Please add records to the system.\n");
    				break;
				}
				
				int ujersey_no;
				
				printf("\nEnter the jersey number of the player whose records you want to update: ");
				scanf("%d", &ujersey_no);
				updatebyjerseyno(total_players,&no_of_players,ujersey_no);	
		
				break;
			}
				
    		case 5 :
    			if(count==0){                                                                        // displaying player records
    				printf("\nNo player records found. Please add records to the system.\n");
    				break;
				}
    		
				displayRecords(total_players,no_of_players);
				break;
			
			case 6 :
				if(count==0){                                                                       //displaying records based on top run scorer and top wicket taker
    				printf("\nNo player records found. Please add records to the system.\n");
    				break;
				}
				displaySortedRecords(total_players,no_of_players);
				break;
		
			default :
				 printf("\n\nInvalid Choice! Please enter an option between 1 to 6.\n");
				 while (getchar() != '\n');
				 	
		}  
		
		
		while (1) {
   			 printf("\n\nDo You Want To Continue ? (Y or N) : ");
    		 yes_no = getchar();
   			 while (getchar() != '\n'); 

             if (yes_no == 'y' || yes_no == 'Y' || 	yes_no == 'n' || yes_no == 'N') {
        		break;
    		} 
			else {
        		printf("\nInvalid choice! Please enter 'Y' or 'N'");
   			 }
		}
		
	} while(yes_no == 'y' || yes_no == 'Y');
	
	free(total_players);
}