#include <iostream>
#include <exception>
#include <fstream>
#include <string>

using namespace std;


int main() {
	try {

		ifstream input;
		input.open("././input.txt");

		ofstream output;
		output.open("././output.txt");

		string temp;
		getline(input,temp);

		output << temp << endl;

	} catch (exception& e) {cout << "Exception: " << e.what();}
	return 0;
}
