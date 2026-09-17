#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *fa = fopen("a.bin", "wb");
    FILE *fb = fopen("b.bin", "wb");

    if(!fa || !fb) exit(1);

    char palavras_a[2][11] = {"PALAVRA_A1", "PALAVRA_A2"};
    char palavras_b[3][11] = {"PALAVRA_B1", "PALAVRA_B2", "PALAVRA_B3"};

    fwrite(palavras_a, sizeof(char), 22, fa);
    fwrite(palavras_b, sizeof(char), 33, fb);

    fclose(fa);
    fclose(fb);

    return 0;
}