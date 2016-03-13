#include <iostream>
#include <fstream>
#include <string>
using namespace std;


int main(){
	cout<<"-----------------------------------\n";
	cout<<"Spring 2016------------------------\n";
	cout<<"CSCI36200: Programming Assignment 3\n";
	cout<<"-----------------------------------\n";
	ifstream inputFile;
	inputFile.open ("triplets1.txt", ios::in | ios::binary);
	//Start reading the file
	string line;
	if(inputFile.is_open()){
		while(getline(inputFile, line)){
			cout<< line <<"\n";
		}
	}
	return 0;
}
