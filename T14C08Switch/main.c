#include <stdio.h>
#include <stdint.h>

#define UP 1
#define DOWN 2
#define LEFT 3
#define RIGHT 4

int main() {
    int32_t dir = 5;
    switch (dir) {
        case UP:
            printf("Go Up\n");
            break;
        case DOWN:
            printf("Go Down\n");
            break;
        case LEFT:
            printf("Go Left\n");
            break;
        case RIGHT:
            printf("Go Right\n");
            break;
        default://其他情况
            printf("Dir Unkown\n");
    }
    
    return 0;
}