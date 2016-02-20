/*
 ============================================================================
 Name        : T14C14PrintHello.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 条件预处理
 * CDT会自动将使用不到的条件用灰色表示
 * 编译阶段进行预处理，只会编译用得到的程序
 * 预处理：gcc T14C14PrintHello.c -DPLATFORM=3
 * 运行：./a.out
 *
 */

#define WIN 1
#define LINUX 2
#define MAC 3

void sayHello(){
#if PLATFORM == WIN
	printf("Hello Windows\n");
#elif PLATFORM == LINUX
	printf("Hello Linux\n");
#elif PLATFORM == MAC
	printf("Hello MAC\n");
#else
	printf("Unknown Plateform\n");
#endif
}

int main(void) {
	sayHello();
	return EXIT_SUCCESS;
}
