/*
 ============================================================================
 Name        : T14C17FileSystem.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	//创建文件，并写文件
	FILE *f = fopen("data.txt", "w");
	if (f != NULL) {
//	fputc('A',f);
		fputs("Hello World", f);
		fclose(f);
	}else{
		puts("can not open file");
	}
	puts("End");
	return EXIT_SUCCESS;
}
