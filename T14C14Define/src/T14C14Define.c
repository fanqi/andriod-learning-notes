/*
 ============================================================================
 Name        : T14C14Define.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

//#define THE_NUM 1
//properties->C/C++ Build->settings->GCC C compiler->Symbols
//添加一个 Defined symbols(-D):THE_NUM=2
//gcc T14C14Define.c -DTHE_NUM=4
//./a.out

int main(void) {
	printf("the number is %d\n", THE_NUM);
	return EXIT_SUCCESS;
}
