#include<iostream>
#include<cstdio>
#include<stdlib.h>
#include<vector>
#include<string>
#include<fstream>
#include<sstream>
#include<utility> 
using namespace std;

std::string::size_type sz;
float funct(vector<vector<string> > singleMenu,vector<string> itemList){
    float min_value=0;
	int flag;
     vector<string> singleRow;
     for(int i=0;i<singleMenu.size();i++){
	flag=0;	
	singleRow = singleMenu[i];
	for(int j=2;j<singleRow.size();j++){
		
		for(int k=0;k<itemList.size();k++){
                      
			if(itemList[k] !="found"){

				if(singleRow[j] == " "+itemList[k]){
					flag=1;
 					itemList[k]="found"; 
				//	cout<<"check";
					break;

												
				}
				
			}
		}	
	}
		
     	if(flag==1){
		min_value += atof(singleRow[1].c_str());
	}		
      } 
    
  for(int i=0;i<itemList.size();i++){
   if(itemList[i] !="found")
	return 0;
   }
   
  
  return min_value;
}

int main(int argc, char *argv[]){

  if(argc < 3){	
  	cout<<"Usage: "<<argv[0]<<" <csvfilename> <item> <item> ...\n";
    exit(0);
   }
   vector<string> itemList;
   itemList.clear();
   int itemCount = 2;
   while(itemCount<argc){
        itemList.push_back(argv[itemCount]);
        itemCount++;
   }
   

   vector<string> row;
   string line;
   ifstream csvFile(argv[1]);
   string word;
   

   vector<vector<string> > menuResturant;   
   menuResturant.clear();
    while(csvFile){
        getline(csvFile,line);
        stringstream lineStream(line);
        row.clear();

        while(getline(lineStream,word,','))
            row.push_back(word);

         
         menuResturant.push_back(row);
         
    }
 
     
    vector<pair<string,float> > Result;
    vector<vector<string> > singleMenu;
    vector<string> singleRow;
    singleRow=menuResturant[0];
    singleMenu.clear();
    float min_value=0;
    string key=singleRow[0];
    for(int i=0;i<menuResturant.size();i++){
       singleRow=menuResturant[i];

        if(key != singleRow[0])
        {  
        	
            min_value=funct(singleMenu,itemList);
            if(min_value !=0){
            	pair<string,float> a;
            	a.first = singleMenu[0][0];
            	a.second = min_value;
            	Result.push_back(a);
            }
            singleMenu.clear();
            key=singleRow[0]; 
        }    	 
       singleMenu.push_back(singleRow); 
       singleRow.clear();
    }
           min_value=funct(singleMenu,itemList);
            if(min_value !=0){
            	pair<string,float> a;
            	a.first = singleMenu[0][0];
            	a.second = min_value;
            	Result.push_back(a);
            }
        if(Result.empty()){
		cout<<"No Match Found\n";
	}
        else{
          string k=Result[0].first;
	  float v=Result[0].second;
        pair<string,float> a;
	for(int i=0;i<Result.size();i++){
		a=Result[i];
			if(v > a.second){
				k=a.first;
				v=a.second;			
			}
	}
           cout<<k<<", "<<v<<endl;
 	}	           
}
