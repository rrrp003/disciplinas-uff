#include <stdio.h>
#include <stdlib.h>
#include "TABB.h"

int main(void){
    TABB *a = TABB_inicializa(); 
    int n, tam = 0;

    printf("Digite os valores da arvore (negativo para parar):\n");
    while(1){
        scanf("%d", &n);
        if(n < 0) break;
        a = TABB_insere(a, n);
    }

    printf("\n--- Arvore Montada ---\n");
    TABB_imp_ident(a);

    printf("\nDigite valores para remover (negativo para parar):\n");
    while(1){
        scanf("%d", &n);
        if(n < 0) break;
        a = TABB_retira(a, n);
        TABB_imp_ident(a);
    }
    
    // Captura o vetor retornado para imprimir
    int *vetor = maioresN(a, 5, &tam);

    printf("\n--- Elementos maiores que 5 (%d encontrados) ---\n", tam);
    if (vetor != NULL) {
        for (int i = 0; i < tam; i++) {
            printf("%d ", vetor[i]);
        }
        printf("\n");
        free(vetor);
    } else {
        printf("Nenhum elemento encontrado.\n");
    }

    TABB_libera(a);
    return 0;
}