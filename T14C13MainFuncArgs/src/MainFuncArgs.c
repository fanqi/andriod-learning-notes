/*
 ============================================================================
 Name        : MainFuncArgs.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 获取程序参数
 *
 * */
int main(int argc, char **argv) {

	printf("args count is %d\n", argc);
	printf("first arg value is %s\n", argv[0]);
	/*
	 * cd /Users/fanqi/Documents/cdt/T14C13MainFuncArgs/Debug
	 * ./T14C13MainFuncArgs a b c
	 * args count is 1
	 * first arg value is /Users/fanqi/Documents/cdt/T14C13MainFuncArgs/Debug/T14C13MainFuncArgs
	 */
	for (int i = 0; i < argc; i++) {
		printf("arg index:%d,value i:%s\n", i, argv[i]);
	}
	/*
	 * ./T14C13MainFuncArgs a b c
	 * arg index:0,value i:./T14C13MainFuncArgs
	 * arg index:1,value i:a
	 * arg index:2,value i:b
	 * arg index:3,value i:c
	 *
	 * ./T14C13MainFuncArgs "a b" c
	 * arg index:0,value i:./T14C13MainFuncArgs
	 * arg index:1,value i:a b
	 * arg index:2,value i:c
	 *
	 */

	/*
	 * 程序返回值
	 * 默认定义了以下两种：
	 * 正常退出 EXIT_SUCCESS	0
	 * 异常退出 EXIT_FAILURE	1
	 *
	 * 也可自定义返回值，例如通过守护进程实现程序异常退出状态的提示
	 *
	 */
	return EXIT_FAILURE;
}
