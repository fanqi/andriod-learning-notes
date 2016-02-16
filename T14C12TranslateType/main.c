#include <stdio.h>
#include <stdlib.h>

int main() {
    //字符串转整型
    char *str = "100";
    int a;
    sscanf(str, "%d", &a);
    printf("int value is %d\n", a);
    printf("int value is %d\n", atoi(str));

    //字符串转浮点型
    double d = atof("3.14");
    printf("double value is %f\n", d);

    //把int转字符串
    int i = 1000;
    char buf[10];
    sprintf(buf, "%d", i);
    puts(buf);
    return 0;
}