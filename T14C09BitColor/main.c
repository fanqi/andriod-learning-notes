#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    // ARGB(Alpha,Red,Green,Blue)
    // 每两位代表一个通道
    // 每个值有256个梯度,0-255
    uint32_t  color = 0xFFFEFAFB;
    // 提取颜色
    // 0x00000000 0x11111110 0x00000000 0x00000000
    // 提取红色
    uint32_t temp = color & 0x00FF0000;
    uint8_t red = temp>>16;
    // 提取绿色
    temp = color & 0x0000FF00;
    uint8_t green = temp>>8;
    // 提取蓝色
    temp = color & 0x000000FF;
    uint8_t blue = temp;
    printf("red=%d,green=%d,blue=%d\n",red,green,blue);
    return 0;
}