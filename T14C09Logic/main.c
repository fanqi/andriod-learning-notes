#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>


#define MALE 1
#define FEMALE 2

int main() {
    /*
     * &&   与
     * ||   或
     * !    非
     * */

    int32_t score = 80;
    //与运算
    if(score>=60 &&
            score<=100){
        printf("OK\n");
    }else{
        printf("Fail or invalid score\n");
    }

    //或运算
    if(score <60 ||
            score>100){
        printf("Fail or invalid score\n");
    }else{
        printf("OK\n");
    }

    //非运算
    int sex = FEMALE;
    if(sex == MALE){
        printf("the person is male\n");
    }else{
        printf("the person is female\n");
    }

    if(sex != MALE){
        printf("the person is female\n");
    }else{
        printf("the person is male\n");
    }
    return 0;
}