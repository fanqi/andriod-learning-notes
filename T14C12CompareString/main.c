#include <stdio.h>
#include <string.h>

int main() {

    char *str = "Hello";
    char *str1 = "Hello";
    char str2[] = "Hello";

    //比较的是字符串的地址,而不是字符串的内容
    printf("pointer str is %p,\npointer str1 is %p,\npointer str2 is %p\n", str, str1, str2);
    printf("Result is %d\n", str == str1);//1相同
    printf("Result is %d\n", str == str2);//0不同

    //strcmp函数:比较字符串的内容
    //返回0则表示两个字符串相同,反之则不同
    printf("Result is %s\n", strcmp(str, str1) == 0 ? "equal" : "not equal");//相同
    printf("Result is %s\n", strcmp(str, str2) == 0 ? "equal" : "not equal");//不同

    //猜水果游戏
    char key[] = "apple";
    char buffer[80];
    do {
        printf("Guess my favorite fruit? ");
        fflush(stdout);
        scanf("%79s", buffer);
    } while (strcmp(key, buffer) != 0);
    puts("Correct answer!");
    return 0;
}