#include<iostream>
#include<cstdio>
#include<stdlib.h>
#include<vector>
#include<string>
#include<fstream>
#include<sstream>
#include<utility> 
using namespace std;

//getMenuListFromCSVFile start
vector<vector<string> > getMenuListFromCSVFile(const char * fileName){

	ifstream csvFile(fileName);
	vector<vector<string> > restaurantMenuList;	
	restaurantMenuList.clear();
    	vector<string> row;
   	string line;
	string word;
   	
	while(csvFile){
        	getline(csvFile,line);
        	stringstream lineStream(line);
        	row.clear();
	
		while(getline(lineStream,word,','))
            		row.push_back(word);
         
         	restaurantMenuList.push_back(row);
         }
 
	return restaurantMenuList;
}//getMenuListFromCSVFile end


//getminValueInSpecificrestaurant start
float getminValueInSpecificrestaurant(vector<vector<string> > singleMenu,vector<string> userItemList){
    	float min_value=0;
	int flag;
     	vector<string> singleRow;
     
	for(int i=0;i<singleMenu.size();i++){
		flag=0;	
		singleRow = singleMenu[i];
		for(int j=2;j<singleRow.size();j++){
		
			for(int k=0;k<userItemList.size();k++){
                      
				if(userItemList[k] !="found"){

					if(singleRow[j] == " "+userItemList[k]){
						flag=1;
 						userItemList[k]="found"; 
						break;

					}
				
				}
			}	
		}
		
     		if(flag==1){
		min_value += atof(singleRow[1].c_str());
		}		
      	} 
    
  	
	for(int i=0;i<userItemList.size();i++){
   		if(userItemList[i] !="found")
			return 0;
   	}
   
  
  	return min_value;

}//getminValueInSpecificrestaurant end

//getKeyValueList start
vector<pair<string,float> > getKeyValueList(vector<vector<string> > restaurantMenuList,vector<string> userItemList){
	vector<pair<string,float> > keyValueList;
    	vector<vector<string> > singleMenu;
    	vector<string> singleRow;
       	singleMenu.clear();    
	singleRow=restaurantMenuList[0];    
    	float min_value=0;
    	string key=singleRow[0];
    	for(int i=0;i<restaurantMenuList.size();i++){
       		singleRow=restaurantMenuList[i];

        	if(key != singleRow[0]){  
        		min_value=getminValueInSpecificrestaurant(singleMenu,userItemList);
            		if(min_value !=0){
            			pair<string,float> a;
            			a.first = singleMenu[0][0];
            			a.second = min_value;
            			keyValueList.push_back(a);
			}
            	
		singleMenu.clear();
            	key=singleRow[0]; 
         	}    	 
       		singleMenu.push_back(singleRow); 
       		singleRow.clear();
    	}
          

	min_value=getminValueInSpecificrestaurant(singleMenu,userItemList);
            
	if(min_value !=0){
        	pair<string,float> a;
            	a.first = singleMenu[0][0];
            	a.second = min_value;
            	keyValueList.push_back(a);
        }

	return keyValueList;

}//getKeyValueList end


//main start
int main(int argc, char *argv[]){

  
	if(argc < 3){	
		cout<<"Usage: "<<argv[0]<<" <csvfilename> <item> <item> ...\n";
    		exit(0);
  	}
   	
	
	vector<string> userItemList;
   	userItemList.clear();
   	int i = 2;
   	
	while(i<argc){
        	userItemList.push_back(argv[i]);
        	i++;
   	}
   

   	vector<vector<string> > restaurantMenuList=getMenuListFromCSVFile(argv[1]);   
   	
     
 	vector<pair<string,float> > keyValueList=getKeyValueList(restaurantMenuList,userItemList);
        


	if(keyValueList.empty()){
		cout<<"No Match Found\n";
	}
        else{
          	string k=keyValueList[0].first;
	  	float v=keyValueList[0].second;
        	pair<string,float> a;
		for(int i=0;i<keyValueList.size();i++){
			a=keyValueList[i];
			if(v > a.second){
				k=a.first;
				v=a.second;			
			}
		}
           	
		cout<<k<<", "<<v<<endl;
 	}
	           
}//main end
