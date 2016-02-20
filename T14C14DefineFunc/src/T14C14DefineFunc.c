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

//宏函数参数连接
void sayHi(){
	printf("hi c\n");
}

void sayHello(){
	printf("hello c\n");
}

#define call(NAME) say##NAME()

//宏函数，可变参数
#define LOG(LEVEL,FORMAT,...) printf(LEVEL);printf(FORMAT,__VA_ARGS__);
#define LOG_E(FORMAT,...) LOG("ERROR:",FORMAT,__VA_ARGS__);
#define LOG_W(FORMAT,...) LOG("WARN:",FORMAT,__VA_ARGS__);
#define LOG_I(FORMAT,...) LOG("INFO:",FORMAT,__VA_ARGS__);
#define LOG_D(FORMAT,...) LOG("DEBUG:",FORMAT,__VA_ARGS__);

int main(void) {
	printf("max number is %d\n", MAX(2, 5));

	LOOP(2, 100,
			printf("current index is %d\n", index);
	)

	call(Hi);
	call(Hello);

	LOG_E("Hello %s %d\n","World",100);
	LOG_W("Hello %s %d\n","World",100);
	LOG_I("Hello %s %d\n","World",100);
	LOG_D("Hello %s %d\n","World",100);

	puts("!!!Hello World!!!"); /* prints !!!Hello World!!! */
	return EXIT_SUCCESS;
}
