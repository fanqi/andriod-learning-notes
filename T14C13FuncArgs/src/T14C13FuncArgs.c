/*
 ============================================================================
 Name        : T14C13FuncArgs.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>

/*
 * n:指明可变参数的长度
 * ...:可变参数
 */
int sum(int n, ...) {
	int all = 0;
	va_list args;
	//开始获取可变参数
	va_start(args, n);
	//累加可变参数
	for (int i = 0; i < n; i++) {
		all += va_arg(args, int);
	}
	//结束可变参数获取
	va_end(args);
	return all;
}

int main(void) {
	printf("sum is %d\n", sum(5, 1, 2, 3, 4, 5));
	return EXIT_SUCCESS;
}
