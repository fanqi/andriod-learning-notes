#include <stdio.h>
#include <string.h>

int main() {
    //创建格式化字符串
    char *str = "item";
    int a = 100;
    char dist[100];
    float b = 3.14;
    memset(dist, 0, 100);
    sprintf(dist, "%s %d,MATH_PI=%.2f", str, a, b);
    puts(dist);

    //分解格式化字符串
    char *str1 = "item 100";
    char buf[10];
    memset(buf, 0, 10);
    int a1;
    sscanf(str1, "%4s %d", buf, &a1);
    printf("String is %s,int value is %d\n", buf, a1);
    return 0;
}