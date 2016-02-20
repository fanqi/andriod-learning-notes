/*
 ============================================================================
 Name        : T14C15Pointer.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : 指针基本介绍
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	//字符指针
	char *str ="Hello";
	int a =10;
	int *pa = &a;//取得a的指针
	printf("%d\n",*pa);

	//分配内存函数malloc(stdlib.h)，标记内存的起始位置和结束位置
	//malloc(4) 分配4个字节
	int32_t *intP = malloc(4);
	intP[0] = 101;
//	*intP = 100;
	printf("%d\n",*intP);
	free(intP);

	//创建一个指针，存放一个系列的数据
	int len = 10;
	int32_t *intPs = malloc(len*sizeof(int32_t));
	intPs[0] = 101;
	intPs[1] = 102;
	printf("%d\n",intPs[0]);
	printf("%d\n",intPs[1]);

	printf("%d\n",*intPs);
	printf("%d\n",*(intPs+1));

	//释放指针所指向的内存,并没有清理内存，而是标记为可被其他程序使用
	//访问完了之后再用
	free(intPs);

	char *str1 = "Hello";
	printf("%ld\n",sizeof(str1));
	//不同的平台，指针的长度不一致 32 4个字节 64位的操作系统 8个字节

	//int64和指针可以项目转化
	char *str2 = "Hello";
	int64_t p = (int64_t)str;
	char *str3 = (char*)p;
	printf("%s\n",str3);

	puts("!!!Hello World!!!"); /* prints !!!Hello World!!! */
	return EXIT_SUCCESS;
}
