/*
 ============================================================================
 Name        : T14C13Include.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

/*
 * <和"在编译时没有区别
 * 约定如果引入的是库、第三方、程序里的头文件的用"
 * 在命令行中编译：
 * gcc T14C13Include.c hello.c
 * */
#include <stdio.h>
#include <stdlib.h>
#include "hello.h"

int main(void) {
	sayHello("fanqi");
	return EXIT_SUCCESS;
}
