#include<iostream>
#include<cstdio>
#include<stdlib.h>
#include<vector>
#include<string>
#include<fstream>
#include<sstream>
#include<utility> 
using namespace std;


int funct(vector<vector<string> > singleMenu,vector<string> itemList){
   int min_value=0;
   int len = singleMenu.size();
   int n=itemList.size();
   int count = itemList.size();
    vector<string> singleRow;
   for(int i=0;i<n;i++){
       for(int j=0;j<len;j++){
       	singleRow=singleMenu[j];
           for(int k=2;k<singleRow.size();k++){
                if(singleRow[k] == itemList[i])
                {   i++;
                	 v = singleRow[1];
                	min_value +=atoi(v);
                	break;
                	
                }
           }

       }

      }
      return min_value;
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
   int itemCount = argc-2;
   while(itemCount){
        itemList.push_back(argv[itemCount]);
        itemCount--;
   }
   
   vector<string> row;
   string line;
   ifstream csvFile(argv[1]);
   string word;
   

   vector<vector<string> > menuResturantById;   
   menuResturantById.clear();
    while(csvFile){
        getline(csvFile,line);
        stringstream lineStream(line);
        row.clear();

        while(getline(lineStream,word,','))
            row.push_back(word);

         
         menuResturantById.push_back(row);
         
    }
    vector<pair<string,string> > Result;
    vector<vector<string> > singleMenu;
    vector<string> singleRow;
    singleRow=menuResturantById[0];
    singleMenu.clear();
    int min_value=0;
    string key=singleRow[0];
    for(int i=0;i<menuResturantById.size();i++){
       singleRow=menuResturantById[i];
        if(key != singleRow[0])
        {
        	min_value=funct(singleMenu,itemList);
            if(min_vlaue !=0){
            	pair<string,string> a;
            	a.first = singleRow[0];
            	a.second = min_value;
            	Result.push_back(a);
            }
            singleMenu.clear();
            key=singleRow[0]; 
        }    	 
       singleMenu.push_back(singleRow); 
       singleRow.clear();
    }

}