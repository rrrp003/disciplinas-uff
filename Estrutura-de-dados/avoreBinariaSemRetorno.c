#include <stdio.h>
#include <stdlib.h>

typedef struct no{
    int valor;
    struct no *direita, *esquerda;
}Noarv;

Noarv* inserir_versao_1 (Noarv *raiz, int num){
    if (raiz == NULL){
        Noarv *aux = malloc(sizeof(Noarv));
        aux->valor = num;
        aux->direita = NULL;
        aux->esquerda = NULL;
        return aux;
    }
    else{
        if (num < raiz->valor){
            raiz->esquerda = inserir_versao_1(raiz->esquerda, num);
        }
        else{
            raiz->direita = inserir_versao_1(raiz->direita, num);
        }
        return raiz;
    }
}
void imprimir_versao_1 (Noarv *raiz){
    if (raiz != NULL){
        printf("%d ", raiz->valor);
        imprimir_versao_1(raiz->esquerda);
        imprimir_versao_1(raiz->direita);
    }
}
/*vai para a esquerda até o fim, imprime o valor e volta, 
vai para a direita até o fim, imprime o valor e volta*/
void imprimir_versao_2 (Noarv *raiz){ 
    if (raiz != NULL){
        imprimir_versao_2(raiz->esquerda);
        printf("%d ", raiz->valor);
        imprimir_versao_2(raiz->direita);
    }
}
int main (void){
    Noarv *raiz = NULL;
    
    int opcao;
    do{
        printf("1 - Inserir\n");
        printf("2 - Imprimir\n");
        printf("3 - Sair\n");
        scanf("%d", &opcao);
        switch(opcao){
            case 1:
                printf("Digite um numero: ");
                scanf("%d", &opcao);
                raiz = inserir_versao_1(raiz, opcao);
                break;
            case 2:
                imprimir_versao_1(raiz);
                printf("\n");
                imprimir_versao_2(raiz);
                printf("\n");
                break;
            case 3:
                break;
            default:
                printf("Opcao invalida!\n");
                
        }
    }while(opcao != 3);
    return 0;
}