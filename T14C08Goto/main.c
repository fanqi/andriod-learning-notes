#include <stdio.h>

int main() {
    //循环输出100 101 102
/*    label:
        printf("100\n");
        printf("101\n");
        printf("102\n");
    goto label;*/
    //

    //循环输出1-100
    int i = 1;
    label:
    printf("%d\n", i);
    i++;
    if (i < 101) {
        goto label;
    }
    return 0;
}