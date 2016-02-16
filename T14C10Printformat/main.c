#include <stdio.h>

int main() {
    printf("Hello World\n");
    /*
     * 符号参数可以参考以下网址:
     * http://www.cplusplus.com/reference/cstdio/printf/
     *
     * */
    //有符号和无符号
    printf("num:%d,unsigned int:%u\n",-12,20);
    printf("%03d\n",7);//3位整数,不够补0,%3d则补空格
    //八进制
    printf("%o\n",8);
    //十六进制
    printf("%x\n",10);//小写
    printf("%X\n",10);//大写
    printf("red:%F\n",0xFFFF0000);
    //浮点类型
    printf("%f\n",3.14);//3.140000
    printf("%.2f\n",3.14);
    //字符,putchar一样
    printf("%c\n",'A');
    //字符串
    printf("%s\n","hello world");


    printf ("Characters: %c %c \n", 'a', 65);
    printf ("Decimals: %d %ld\n", 1977, 650000L);
    printf ("Preceding with blanks: %10d \n", 1977);
    printf ("Preceding with zeros: %010d \n", 1977);
    printf ("Some different radices: %d %x %o %#x %#o \n", 100, 100, 100, 100, 100);
    printf ("floats: %4.2f %+.0e %E \n", 3.1416, 3.1416, 3.1416);
    printf ("Width trick: %*d \n", 5, 10);
    printf ("%s \n", "A string");

    return 0;
}