#include <iostream>

using namespace std;

int main() {
    //字符常量
    //换行符:\n
    printf("hello\nworld");
    //回车符:\r,将输出指针移动到最开始的位置,从头开始输出
    printf("hello\rworld");
    //退格符:\b,backspace,需要中terminal中运行才能显示正常结果hellworld
    printf("hello\bworld\n");
    //制表符:\t
    printf("hello\tworld\nhello\tc++\n");
    //换页符:\f
    printf("hello\fworld\n");
    //转义字符
    printf("hello\\\n");
    //双引号
    printf("\"hello\"\n");
    //单引号
    printf("\'hello\'\n");

    //字符变量,字节数为1,即8位,最多能够存放的数据是255
    printf("length of char : %d \n", sizeof(char));
    char ch = 'a';
    printf("a=%d\n", ch);//输出97
    ch = 'A';
    printf("A=%d\n", ch);//输出65
    //将大写字符变成小写字符,只需要加上32
    printf("%c\n", ch + 32);
    return 0;
}