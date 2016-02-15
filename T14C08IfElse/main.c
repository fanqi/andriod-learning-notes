#include <stdint.h>
#include <stdio.h>
int main() {

    int32_t a = 8;
    int32_t b = 6;

    if(a>b){
        printf("Max number is a,a=%d\n",a);
    } else{
        printf("Max number is b,b=%d\n",b);
    }

    int32_t score = 78;

    if(score>=80){
        printf("fine\n");
    }else if(score>=60){
        printf("ok\n");
    }else{
        printf("bad\n");
    }

    return 0;
}