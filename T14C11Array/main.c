#include <stdio.h>
#include <stdint.h>
#include <string.h>

int main() {

    //一维数组
    int32_t len = 10;
    int32_t arr[len];//整型数组,长度为10,arr[0] 访问数组第一个元素
    //clear array
    for (int32_t j = 0; j < len; j++) {
        arr[j] = 0;
    }

    for (int32_t i = 0; i < len; i++) {
        printf("index %d,and value is %d\n", i, arr[i]);
    }

    //定义时初始化
    int32_t arr1[] = {1, 3, 5, 7, 9};
    int32_t arr1_len = sizeof(arr1) / sizeof(arr1[0]);//计算数组长度
    for (int32_t i = 0; i < arr1_len; i++) {
        printf("index %d,and value is %d\n", i, arr1[i]);
    }

    //二维数组
    int32_t arr2[3][4];
    //清零
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
            arr2[i][j] = 0;
        }
    }

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
            printf("index(%d,%d)=%d\n", i, j, arr2[i][j]);
        }
    }
    int32_t arr3[3][4] = {
            {1, 2,  3,  4},
            {5, 6,  7,  8},
            {9, 10, 11, 12},
    };
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 4; j++) {
            printf("index(%d,%d)=%d\n", i, j, arr3[i][j]);
        }
    }

    //字符数组
    // char str[10]="hello";
    char str[10] = {'h', 'e', '\0', 'l', 'l', 'o', '\0'};//\0表示字符串的结尾
    memset(str, 0, 10);//清零
    printf("string length :%d,string is %s\n", strlen(str), str);

    char str1[] = "hello world";
    for (int k = 0; k < 11; ++k) {
        printf("[index:%d]%c\n", k, str1[k]);
    }
    return 0;
}