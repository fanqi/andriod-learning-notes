#include <stdio.h>
#include <string.h>

int main() {
    char *str = "hello world";
    printf("%s\n", str);

    printf("%s\n", strchr(str, 'o'));//从前面开始查找字符,截取到末尾
    printf("%s\n", strrchr(str, 'o'));//反向查找,从后面开始查找字符,截取到末尾
    printf("%s\n", strstr(str, "wo"));//查找字符串截取

    //从开始位置截取到指定位置
    char str1[10];
    memset(str1, 0, 10);
    strncpy(str1, str, 3);
    printf("%s\n", str1);

    //从指定位置截取到末尾
    char *str2 = str + 5;//从第5个位置开始
    printf("%s\n", str2);

    //从指定位置截取到指定位置
    char *str3 = str + 6;
    char str4[10];
    memset(str4, 0, 10);
    strncpy(str4, str3, 3);
    printf("%s\n", str4);

    return 0;
}