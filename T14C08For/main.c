#include <stdio.h>

int main() {
    for (int i = 0; i < 100; i++) {
        printf("Number : %d\n", i);

        for (int j = 0; j < 10; j++) {
            printf("%d,", j);
        }
        printf("\n");
        if (i > 50) {
            break;
        }
    }

    //乘法表
    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= i; j++) {
            printf("%d*%d=%d\t", i, j, i * j);
            //跳出当前循环
//            if(j>5){
//                break;
//            }

            //跳出多重循环
            if (i * j > 24) {
                goto end;
            }
        }
        printf("\n");
    }
    end :;


    for (int i = 0; i < 100; i++) {
        printf("Item %d\n", i);

        if (i == 50) {
//            break;//跳出循环
            continue;//跳过后续代码,继续执行
        }
        printf("Number %d\n", i);
    }


    return 0;
}