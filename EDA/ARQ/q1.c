#include <stdio.h>
#include <stdlib.h>

void aux(FILE *fp1, FILE *fp2, FILE *fp3){
    int ini = 0, n = 0, fim1, fim2;
    
    char *vet = (char*) malloc(sizeof(char) * 23);
    
    fseek(fp1, 0L, SEEK_END);
    fim1 = ftell(fp1) - 11;
    fseek(fp2, 0L, SEEK_END);
    fim2 = ftell(fp2) - 11;
    
    fseek(fp1, 0L, SEEK_SET);
    fseek(fp2, 0L, SEEK_SET);
    fseek(fp3, 0L, SEEK_SET);

    while(ini <= fim1){
        fread(&vet[0], sizeof(char), 11, fp1);
        vet[11] = ','; 

        fseek(fp2, 0L, SEEK_SET);

        for (int i = 0; i <= fim2; i += 11){
            fread(&vet[12], sizeof(char), 11, fp2);
            fwrite(vet, sizeof(char), 23, fp3);
        }
        ini += 11; 
    }

    free(vet);
}

int main() {

    FILE *fp1 = fopen("a.bin", "rb");
    FILE *fp2 = fopen("b.bin", "rb");
    FILE *fp3 = fopen("c.bin", "wb");
    
    if(!fp1 || !fp2 || !fp3) exit(1);

     aux(fp1, fp2, fp3);
    
    fclose(fp1);
    fclose(fp2);
    fclose(fp3);

    FILE *fp_c = fopen("c.bin", "rb");
    if(!fp_c) exit(1);

    char par[24];
    par[23] = '\0';

while(fread(par, sizeof(char), 23, fp_c) == 23){
    printf("%s%c%s\n", &par[0], par[11], &par[12]);
}

    fclose(fp_c);

    return 0;
}