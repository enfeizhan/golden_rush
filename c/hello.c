#include <stdio.h>

int main(void) {
    printf("Hello world");
    char l1, l2;
    printf("type in your two letters: ");
    scanf("%c%c", &l1, &l2);
    printf("Typed in %c and %c\n", l1, l2);
    return 0;
}
