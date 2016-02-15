#include <stdio.h>

int main() {
    int i = 0;

    while (i < 100) {
        if (i % 2 == 1)//奇数
            printf("%d\n", i);
        i++;
    }

    i = 0;

    do {
        printf("%d\n", i);
        i++;
    } while (i < 100);

    i = 0;
    //先判断后执行
    while (i > 0) {
        printf("while-%d\n", i);
    }
    //先执行后判断
    do {
        printf("do-%d\n", i);
    } while (i > 0);
    
    return 0;
}