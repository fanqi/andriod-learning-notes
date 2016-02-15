#include <iostream>

using namespace std;

int main() {
    //整型,长度是4个字节
    int a = 10;
    int b = -10;
    //长整型,长度受限于系统环境,32位是4个字节,64位是8个字节
    //通常为了不受系统限制,将长整型定义为long long,统一占8个字节
    long long c = 20;
    printf("a=%d,b=%d,c=%ld\n", a, b, c);
    //二进制方式,以0b开头
    int d = 0b100;//4
    //八进制,以0开头
    int e = 010;
    //十六进制方式,以0x开头
    int f = 0xB;//11
    printf("d=%d,e=%d,f=%d\n", d, e, f);

    //无符号整型数据
    unsigned int g = 12;
    printf("g=%d\n", g);

    //C11标准的stdint,数据类型以_t结尾,每个平台长度一样
    //常用的int其实就是int32,8位一个字节
    int32_t h = 10;
    //默认包含符号,范围-128-127
    int8_t i = 127;
    uint8_t j = 255;//无符号8位整型,范围0-255
    //long long 可以使用 int64_t
    int64_t k = 1000;
    printf("h=%d,i=%d,j=%d,k=%d\n", h, i, j, k);

    return 0;
}