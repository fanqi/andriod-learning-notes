#include <string.h>
#include <stdint.h>
#include <stdio.h>

int main() {
    //定义字符串,可以是字符数组,也可以是字符指针
    char *str = "hello";
    char *str1 = "world";
    //字符缓冲区
    const uint32_t DIST_LEN = 100;
    char dist[DIST_LEN];
    memset(dist, 0, DIST_LEN);//清空字符串
    strcat(dist, str);
    strcat(dist, " ");
    //strcat(dist, str1);
    //只连接一部分
    strncat(dist, str1, 3);

    puts(dist);
    return 0;
}