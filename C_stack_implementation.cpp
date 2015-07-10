#include <stdio.h>


/**********************Stack****************************/
#define SIZE 100

struct stack_type
{
	int items[SIZE];
	int top;
};

typedef stack_type STACK;
STACK stack;

void push(int item)
{
	if(stack.top == (SIZE - 1)) 
	{
		printf("stack overflow\n");
		return;
	}

	stack.items[++stack.top] = item;
}

int pop()
{
	if(stack.top == -1) 
	{
		printf("empty stack\n");;
		return -1;
	}

	return stack.items[stack.top--];
}

int top()
{
	if(stack.top == -1) 
	{
		printf("empty stack\n");
		return -1;
	}

	return stack.items[stack.top];
}

/******************************************************/


int main()
{
	//stack 
	stack.top = -1;

	printf("stack push: 10 20 30\n");
	push(10);
	push(20);
	push(30);

	printf("stack pop: \n");
	printf("%d\n", pop() );
	printf("%d\n" , pop() ); 
	printf("%d\n" , pop() );
	//end stack

	//queue

	return 0;
}
