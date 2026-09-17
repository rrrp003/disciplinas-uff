#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

void merge(char *a1, char *a2, char *s);

int main(int argc, char **argv){
    if(argc != 4){
        printf("Erro: argumentos\n");
        exit(1);
    }
    merge(argv[1], argv[2], argv[3]);
    return 0;
}
void merge(char *a1, char *a2, char *s){
    FILE *fp1 = fopen(a1, "r"),
    
    *fp2 = fopen(a2, "r"),
    *fpo = fopen(s, "w");
    
    if((!fp1)||(!fp2)||(!fpo)) exit(1);
    
    int r1, n1, r2, n2;
    r1 = fscanf(fp1, "%d", &n1);
    r2 = fscanf(fp2, "%d", &n2);

    while((r1 == 1) || (r2 == 1)){
        if((r2 != 1) || (n1 <= n2)){
            fprintf(fpo, "%d\n", n1);
            r1 = fscanf(fp1, "%d", &n1);
            if(r1 != 1) n1 = INT_MAX;
        }
        else if((r1 != 1) || (n2 < n1)){
            fprintf(fpo, "%d\n", n2);
            r2 = fscanf(fp2, "%d", &n2);
            if(r2 != 1) n2 = INT_MAX;
        }
    }
    fclose(fp1);
    fclose(fp2);
    fclose(fpo);
}