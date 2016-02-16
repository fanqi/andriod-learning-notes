#include <stdio.h>

int main() {
    /*
     * putchar:通过标准输出写字符
     * */
    //97 a
    putchar(97);
    char ch = 'b';
    putchar(ch);

    for(char c = 'A'; c<='z';c++){
        putchar(c);
    }
    return 0;
}