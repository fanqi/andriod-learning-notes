/*
 * hello.c
 *
 *  Created on: 2016年2月17日
 *      Author: fanqi
 */
#include "hello.h"
#include <stdio.h>

void sayHello(char *name){
	printf("hello %s\n",name);
	sayHi("fanqi");
}

static void sayHi(char *name){
	printf("hi %s\n",name);

}
