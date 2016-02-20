/*
 ============================================================================
 Name        : T14C16Union.c
 Author      : fanqi
 Version     :
 Copyright   : Your copyright notice
 Description : 共同体，成员共用内存
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

//成员共用内存，长度是最大成员的长度
typedef union _BaseData{
	char ch;
	uint8_t ch_num;
	uint32_t num;
} BaseData;

//结构体的长度,编译器会优化（内存对齐），长度是最大成员长度的倍数，更改顺序长度会变化
typedef struct _Data{
	uint8_t a;//1
	uint8_t b;//1
	uint32_t c;//4
	uint8_t d;//1
//} Data;
} __attribute__((__packed__)) Data;//内存压缩，7

//小端存储 低位字节放在前面，高位字节放在后面
//大端存储 低位字节放在后面，高位字节放在前面
//需要调整顺序
typedef struct _ColorARGB{
//	uint8_t alpha;
//	uint8_t red;
//	uint8_t green;
//	uint8_t blue;

	uint8_t blue;
	uint8_t green;
	uint8_t red;
	uint8_t alpha;
} ColorARGB;

typedef union _Color{
	uint32_t color; //0xFFFEED2B 小端存储：0x2B 0xED 0xEF 0xFF
	ColorARGB colorARGB;
} Color;

int main(void) {

	BaseData data;
	data.ch = 'B';

	printf("ch_num is %d\n",data.ch_num);

	printf("Length of BaseData is %ld\n",sizeof(BaseData));//1,add uint32_t num; sizeof(BaseData)=4
	printf("Length of Data is %ld\n",sizeof(Data));//1,2,8,12

	//通过结构体和共同体提取颜色通道
	Color c;
	c.color = 0xFFFE0000;//alpha red green blue
	printf("red = %X\n",c.colorARGB.red);
	printf("green = %X\n",c.colorARGB.green);
	printf("blue = %X\n",c.colorARGB.blue);
	printf("alpha = %X\n",c.colorARGB.alpha);

	return EXIT_SUCCESS;
}
