/*
 ============================================================================
 Name        : T14C14DefineFunc.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : 宏函数，直接由编译器进行替换编译
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

#define MAX(A,B) A>B?A:B

#define LOOP(FROM,TO,CONTENT) \
	for(int index = FROM;index<=TO;index++){\
		CONTENT \
	}\

//宏函数不需要指定类型
int _max(int a,int b){
	return a>b?a:b;
}

int main(void) {
	printf("max number is %d\n", MAX(2, 5));

	LOOP(2, 100,
			printf("current index is %d\n", index);
	)

	puts("!!!Hello World!!!"); /* prints !!!Hello World!!! */
	return EXIT_SUCCESS;
}
