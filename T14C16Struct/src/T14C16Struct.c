/*
 ============================================================================
 Name        : T14C16Struct.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : 结构体
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

//file(name,size)
struct File{
	char *name;
	int size;
};

//通过typedef来声明一个结构体的类型
//typedef struct _File File
typedef struct File File1;

//也可以写在一行
//typedef struct _File{
//	char *name;
//	int size;
//} File;

int main(void) {

	struct File file;
	file.name = "file.txt";
	file.size = 100;

	printf("File name is %s\n",file.name);
	printf("File size is %d\n",file.size);

	//	int arr[10] = {1,2,3,4,5,6,7,0,0,0};
	struct File file1= {"file1",101};
	printf("File1 name is %s\n",file1.name);
	printf("File1 size is %d\n",file1.size);

	File1 file2 = {"file2",102};
	printf("File2 name is %s\n",file2.name);
	printf("File2 size is %d\n",file2.size);


	return EXIT_SUCCESS;
}
