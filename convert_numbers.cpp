//convert number using bit operation
//Decimal to Octal, Hexa

#include <iostream>
#include <string>
using namespace std;

int N;

void toBinaryString()
{
	string binstr, temp;
	//calculate bits for int type - bytes * 8 (bits) 
	int shiftBits = (sizeof(int) * 8 ) - 1;  

	//remove leading zeros
	while(((N >> shiftBits) & 1 ) == 0 ) shiftBits--;

	//convert Decimal to Binary 
	for( ; shiftBits >= 0 ; shiftBits--)
	{
		//shift n bits and mask 
		temp = ((N >> shiftBits) & 1) + '0';

		binstr.append(temp);
	}

	cout << "bin: " << binstr << endl;
}

void toOctalString()
{
	string octstr,str;
	//calculate total bits for int type
	//for Octal number, group all bits taking 3 bits from left-to-right to get each OctDigit, 
	//and remaining bits are for last OctDigit
	//for example, (sizeof(int) * 8 ) is 4*8 = 32 bits, 
	//then 32 % 3 = 2 bits which are most significant bits to convert in OctDigit
	//so, first shift is 30 bits, and to get OctDigit from last 2 bits
	int shiftBits= (sizeof(int) * 8 );
	shiftBits -= shiftBits % 3;

	//remove leading zeros
	while( ((N >> shiftBits) & 7) == 0) shiftBits -= 3;

	//convert Decimal to Octal
	for( ; shiftBits >= 0 ; shiftBits -= 3)
	{
		str = ((N >> shiftBits) & 7) + '0';
		octstr.append(str);
	}

	cout << "oct: " << octstr << endl;
}

void toHexString()
{
	string hexstr, str;
	// 4bits for each HexDigit
	int nbits = ((sizeof(int) * 8) - 4);
	int temp;
	//remove leading zeros
	while( (( N >> nbits ) & 15 ) == 0 ) nbits -= 4;

	//convert to Hex string
	for( ; nbits >= 0 ; nbits -= 4)
	{
		temp = (N >> nbits) & 15;
		
		if(temp < 10) str = temp + '0';
		else str = (temp - 10) + 'A';

		hexstr.append(str);
	}

	cout << "hex: " << hexstr << endl;
}

int main()
{

	cin >> N;

	toBinaryString();
	toOctalString();
	toHexString();
	
	return 0;
}
