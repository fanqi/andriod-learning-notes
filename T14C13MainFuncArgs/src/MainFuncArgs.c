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
	 * cd /Users/fanqi/Documents/cdt/T14C13MainFuncArgs/Debug
	 * ./T14C13MainFuncArgs a b c
	 * arg index:0,value i:./T14C13MainFuncArgs
	 * arg index:1,value i:a
	 * arg index:2,value i:b
	 * arg index:3,value i:c
	 */
	return EXIT_SUCCESS;
}
