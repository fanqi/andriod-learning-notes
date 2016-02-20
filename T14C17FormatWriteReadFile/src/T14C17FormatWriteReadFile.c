/*
 ============================================================================
 Name        : T14C17FormatWriteReadFile.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
//	格式化写入文件
	FILE *f = fopen("data.txt","w");

	if(f){
		int i = 0;
		for(i = 0;i<100;i++){
			fprintf(f,"item %d\n",i);
		}
		fclose(f);
	}else{
		printf("can not write file");
	}
	puts("write end");

	//读取文件
	FILE *fr = fopen("data.txt","r");
	if(fr){
		int a;
		fscanf(fr,"item %d\n",&a);
		fscanf(fr,"item %d\n",&a);
		printf("num read is %d\n",a);
		fclose(fr);
	}else{
		printf("can not read file");
	}
	puts("read end");

	return EXIT_SUCCESS;
}
