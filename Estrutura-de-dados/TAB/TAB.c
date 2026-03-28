#include "TAB.h"

TAB *TAB_inicializa(void){
  return NULL;
}

TAB *TAB_cria(int raiz, TAB *esq, TAB *dir){
  TAB *novo = (TAB *) malloc(sizeof(TAB));
  novo->info = raiz;
  novo->esq = esq;
  novo->dir = dir;
  return novo;
}

TAB *TAB_busca(TAB *a, int elem){
  if((!a) || (a->info == elem)) return a;
  TAB *resp = TAB_busca(a->esq, elem);
  if(resp) return resp;
  return TAB_busca(a->dir, elem);
}

TAB *TAB_copia(TAB *a){
  if(!a) return NULL;
  return(TAB_cria(a->info, TAB_copia(a->esq), TAB_copia(a->dir)));
}

TAB *TAB_espelho(TAB *a){
    if(!a) return NULL;
    return (TAB_cria(a->info, TAB_espelho(a->dir), TAB_espelho(a->esq)));
}

TAB* retira_pares (TAB* a){
}

TAB *TAB_maior(TAB *a) {

  if (!a) return a;

  TAB *maior = a;

  TAB *maior_esq = TAB_maior(a->esq);
  TAB *maior_dir = TAB_maior(a->dir);

  if (maior_esq != NULL && maior_esq->info > maior->info) {
      maior = maior_esq;
  }
  if (maior_dir != NULL && maior_dir->info > maior->info) {
      maior = maior_dir;
  }
  return maior;
}

TAB *TAB_menor(TAB *a){
  if (!a) return a;

  TAB *menor = a;

  TAB *menor_esq = TAB_menor(a->esq);
  TAB *menor_dir = TAB_menor(a->dir);

  if ((menor_esq != NULL ) && (menor_esq->info < menor->info)) {
      menor = menor_esq;
  }
  if ((menor_dir != NULL) && (menor_dir->info < menor->info)) {
      menor = menor_dir;
  }
  return menor;
}

void TAB_imp_pre(TAB *a){
  if(a){
    printf("%d ", a->info);
    TAB_imp_pre(a->esq);
    TAB_imp_pre(a->dir);
  }
}

void TAB_imp_pos(TAB *a){
  if(a){
    TAB_imp_pos(a->esq);
    TAB_imp_pos(a->dir);
    printf("%d ", a->info);
  }
}

void TAB_imp_sim(TAB *a){
  if(a){
    TAB_imp_sim(a->esq);
    printf("%d ", a->info);
    TAB_imp_sim(a->dir);
  }
}

void imp_aux(TAB *a, int andar){
  int j;
  if(a){
    imp_aux(a->esq, andar + 1);
    for(j = 0; j <= andar; j++) printf("\t"); //printf("   ");
    printf("%d\n", a->info);
    imp_aux(a->dir, andar + 1);
  }
  else{
   for(j = 0; j <= andar; j++) printf("\t");
   printf("N\n");
  }
}

void TAB_imp_ident(TAB *a){
  imp_aux(a, 0);
}

void TAB_libera(TAB *a){
  if(a){
    TAB_libera(a->esq);
    TAB_libera(a->dir);
    free(a);
  }
}

int maior(int x, int y){
  if(x >= y) return x;
  return y;
}

int TAB_altura(TAB *a){
  if(!a) return -1;
  return maior(TAB_altura(a->esq), TAB_altura(a->dir)) + 1;
}

int igual (TAB* a1, TAB* a2){
  if (a1 == NULL && a2 == NULL) {
        return 1;
  }
  if (a1 == NULL || a2 == NULL) {
      return 0;
  }
  if (a1->info != a2->info) {
      return 0;
  }
  return (igual(a1->esq, a2->esq) && (a1->dir, a2->dir));
}

int nf(TAB *a){
  if(!a) return 0;

  if((!a->esq) && (!a->dir)) return 1;

  return (nf(a->esq) + nf(a->dir));
}

int nf_opt(TAB *a){
  if(!a) return 0;

  if((!a->esq) && (!a->dir)) return 1;

  int total_folhas = 0;

  if (a->esq){
    total_folhas += nf_opt(a->esq);
  }
  if (a->dir){
    total_folhas += nf_opt(a->dir);
  }
  return total_folhas;
}
