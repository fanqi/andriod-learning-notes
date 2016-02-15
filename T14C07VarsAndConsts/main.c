#include <stdio.h>
// 第1种方式定义常量,全部大写
// 程序在编译的时候会自动将所有MY_AGE替换为10000
#define MY_AGE 10000
// 第2种方式定义常量,明确知道常量的类型
// 在程序运行的时候再处理
const int MY_AGE1 = 20000;

int main() {
    //定义一个变量
    int a = 10;
    a = 11;
    printf("the number is %d\n", a);

    printf("My age is %d\n", MY_AGE);

    printf("My age1 is %d\n", MY_AGE1);
    return 0;
}