#include <stdio.h>

int main() {
    //输入字符
    char dist;//声明变量,不赋值,一旦声明,系统就会在内存中开辟一块空间,通过用户来进行赋值
    printf("please input a char:\n");
    scanf("%c", &dist);//使用&符号,访问字符地址进行赋值
    printf("input char is:%c\n", dist);

    //输入整数
    int i;
    printf("please input a number:\n");
    scanf("%d", &i);
    printf("input number is:%d\n", i);

    //输入字符串
    char buf[100];
    printf("please input a string:\n");
    scanf("%s", buf);
    printf("input string is:%s\n", buf);

    return 0;
}