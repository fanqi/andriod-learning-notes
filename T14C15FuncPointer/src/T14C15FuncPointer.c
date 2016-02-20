/*
 ============================================================================
 Name        : T14C15FuncPointer.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

void hello1(){
	printf("Hello World\n");
}

void hello2(int a,int b,char *c){
	printf("Hello World\n");
}

//函数指针类型别名
typedef void(*SimpleFunc)();

int main(void) {

	void(*fp1)() = &hello1;
	fp1();
	void(*fp2)(int,int,char*) = &hello2;
	fp2(1,1,"hello");

	SimpleFunc fp = &hello1;
	fp();


	return EXIT_SUCCESS;
}
