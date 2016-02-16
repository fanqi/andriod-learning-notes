#include <iostream>
#include "math.h"

using namespace std;

int main() {

    /*
     * 四则运算
     * + 加
     * - 减
     * * 乘
     * / 除
     *
     * */
    int32_t  a = (10+2-8)*9/3;
    printf("%d\n",a);

    /*
     * 复杂运算
     * 添加math.h头文件
     * 可访问http://www.cplusplus.com/reference/cmath/查看具体方法
     * 如三角函数等
     * */
    //正弦函数
    printf("%f\n",sin(M_PI/2));
    return 0;
}