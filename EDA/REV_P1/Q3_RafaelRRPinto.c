#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "TAB.h"


int abeABB_aux(TAB *a, TAB *min, TAB *max) {
  if (!a) return 1;

  if (min && a->info <= min->info) return 0;

  if (max && a->info >= max->info) return 0;

  return abeABB_aux(a->esq, min, a) && abeABB_aux(a->dir, a, max);
}

int abeABB(TAB *a) {
  return abeABB_aux(a, NULL, NULL);
}
int main(void){
  int no, pai;
  printf("Digite a raiz da arvore... ");
  scanf("%d", &no);
  TAB *a = TAB_cria(no, NULL, NULL), *resp;
  char repete;
  do{
    char lado[2];
    printf("Quer continuar inserindo nos na árvore (digite N ou n para parar)? ");
    scanf(" %c", &repete);
    if((repete == 'N') || (repete == 'n')) break;
    printf("Digite o pai (que deve existir), o filho a ser inserido e a posição E(ESQ) ou D(DIR)... ");
    scanf("%d%d%s", &pai, &no, lado);
    resp = TAB_busca(a, pai);
    if(!resp){
      TAB_libera(a);
      return 0;
    }
    if(strcmp(lado, "E") == 0) resp->esq = TAB_cria(no, NULL, NULL);
    else resp->dir = TAB_cria(no, NULL, NULL);
  }while(1);
  TAB_imp_ident(a);
  printf("\n");
  
  printf("Arvore binaria e binaria de busca? %d\n", abeABB(a));
  TAB_libera(a);
  return 0;
}