#include <iostream>

using namespace std;
//使用 typedef 关键字自定义数据类型
typedef int64_t fq_long;
typedef char fq_char;
typedef uint8_t fq_char1;

int main() {
    fq_long a =20;
    printf("%d\n",a);
    fq_char b = 'A';
    printf("%c\n",b);
    fq_char1 c = 'c';
    printf("%c\n",c);
    return 0;
}