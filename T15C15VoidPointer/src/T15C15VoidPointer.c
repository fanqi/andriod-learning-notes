/*
 ============================================================================
 Name        : T15C15VoidPointer.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : 无类型指针，可以指向任何类型的数据
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	void *data ="Hello Wolrd";
	printf("%s\n",data);

	void *data1 = malloc(8);
	int *intData1 = data1;
	intData1[0] = 10000;

	printf("%ld\n",sizeof(data1[0]));
	printf("%ld\n",sizeof(intData1[0]));
	printf("%d\n",intData1[0]);

	free(data);
	free(data1);
	free(intData1);
	return EXIT_SUCCESS;
}
