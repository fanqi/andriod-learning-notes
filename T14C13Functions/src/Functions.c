/*
 ============================================================================
 Name        : T14C13Functions.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>


void printHelloWorld(){
	printf("hello world\n");
}

void hello(char *name){
	printf("hello %s\n",name);
}

void sayHello(char *name,int age){
	printf("hello %s,your age is %d\n",name,age);
}

int add(int a,int b){
	return a+b;
}

int main(void) {
	printHelloWorld();
	hello("fanqi");
	sayHello("fanqi",28);
	printf("%d+%d=%d\n",1,2,add(1,2));
	return EXIT_SUCCESS;
}
