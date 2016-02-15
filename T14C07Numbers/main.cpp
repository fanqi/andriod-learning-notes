#include <iostream>

using namespace std;

int main() {

    //实数类型
    //计算机计算浮点类型会有误差,计算不建议采用实数类型
    float a = 3.1; //单精度,4个字节,32位
    double b = 3.1; //双精度,8个字节,64位
    long double c = 3.1;//长双精度,16个字节,128位
    //long double需要使用%Lf输出,否则会输出错误数据,可使用g++ main.cpp在terminal编译查看提醒
    printf("a=%f,b=%f,c=%Lf", a, b, c);

    return 0;
}