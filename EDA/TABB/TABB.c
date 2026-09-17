#include "TABB.h"

TABB *TABB_inicializa(void){
  return NULL;
}

TABB *TABB_cria(int raiz, TABB *esq, TABB *dir){
  TABB *novo = (TABB *) malloc(sizeof(TABB));
  novo->info = raiz;
  novo->esq = esq;
  novo->dir = dir;
  return novo;
}

void TABB_imp_pre(TABB *a){
  if(a){
    printf("%d ", a->info);
    TABB_imp_pre(a->esq);
    TABB_imp_pre(a->dir);
  }
}

void TABB_imp_pos(TABB *a){
  if(a){
    TABB_imp_pos(a->esq);
    TABB_imp_pos(a->dir);
    printf("%d ", a->info);
  }
}

void TABB_imp_sim(TABB *a){
  if(a){
    TABB_imp_sim(a->esq);
    printf("%d ", a->info);
    TABB_imp_sim(a->dir);
  }
}

void imp_aux(TABB *a, int andar){
  int j;
  if(a){
    imp_aux(a->dir, andar + 1);
    for(j = 0; j <= andar; j++) printf("\t"); //printf("   ");
    printf("%d\n", a->info);
    imp_aux(a->esq, andar + 1);
  }
  else{
   for(j = 0; j <= andar; j++) printf("\t");
   printf("N\n");
  }
}

void TABB_imp_ident(TABB *a){
  imp_aux(a, 0);
}

void TABB_libera(TABB *a){
  if(a){
    TABB_libera(a->esq);
    TABB_libera(a->dir);
    free(a);
  }
}

TABB *TABB_busca(TABB *a, int elem){
  if((!a) || (a->info == elem)) return a;
  if(a->info > elem) return TABB_busca(a->esq, elem);
  return TABB_busca(a->dir, elem);
}

TABB *TABB_insere(TABB *a, int elem){
  if(!a) return TABB_cria(elem, NULL, NULL);
  if(a->info > elem) a->esq = TABB_insere(a->esq, elem);
  else if (a->info < elem) a->dir = TABB_insere(a->dir, elem);
  return a;
}

TABB *TABB_retira(TABB *a, int info){
  if(!a) return a;

  if(info < a->info) 
    a->esq = TABB_retira(a->esq, info);
  else if(info > a->info) 
    a->dir = TABB_retira(a->dir, info);
  else{ //info encontrada
    if((!a->esq) && (!a->dir)){ //CASO (1)
      free(a);
      a = NULL;
    }
    else if((!a->esq) || (!a->dir)){ //CASO (2)
      TABB *temp = a;
      if(!a->esq) a = a->dir;
      else a = a->esq;
      free(temp); 
    }
    else{ //CASO (3)
      TABB *filho = a->esq;
      while(filho->dir) filho = filho->dir;
      a->info = filho->info;
      filho->info = info;
      a->esq = TABB_retira(a->esq, info);
    }
  }
  return a; 
}

TABB *Menor_rec(TABB *a){
  if (!a) return NULL;
  if (!a->esq) return a;

  Maior_rec(a->esq);
}

TABB *Maior_rec(TABB *a){
  if (!a) return NULL;
  if (!a->dir) return a;

  Maior_rec(a->dir);
}

TABB *Maior(TABB *a){
  if (!a) return NULL;
  
  while(a->dir) a = a->dir;
  
  return a;
}

TABB *retira_impares_v2(TABB *a) {
    if (!a) return NULL;

    a->esq = retira_impares(a->esq);
    a->dir = retira_impares(a->dir);

    if (a->info % 2 != 0) {
        a = TABB_retira(a, a->info); 
      }
    return a;
}

TABB *retira_impares(TABB *a) {
    if (!a) return NULL;

    a->esq = retira_impares(a->esq);
    a->dir = retira_impares(a->dir);

    if (a->info % 2 != 0) {
        if (!a->esq && !a->dir) {
            free(a);
            return NULL;
        }
        else if (!a->esq) {
            TABB *temp = a->dir; 
            free(a);
            return temp;
        }
        else if (!a->dir) {
            TABB *temp = a->esq; 
            free(a);  
            return temp;
        }
        else {
          
        }
    }
    return a;
}

int conta_maioresN(TABB *a, int n){
  if(!a) return 0;
  if (a->info > n) return 1 + conta_maioresN(a->esq, n) + conta_maioresN(a->dir, n);
  else return 1 + conta_maioresN(a->dir, n);
}

void preenche_vet(TABB *a, int n, int *resp,int *pos){
  if (!a) return;
  
  if(a->info > n) {
    preenche_vet(a->esq, resp, n, pos);
    resp[(*pos)] = a->info;
    (*pos) ++;
    preenche_vet(a->dir, resp, n, pos);
  }
  else {
    preenche_vet(a->dir, resp, n, pos);
  }
}

int *maioresN(TABB *a, int n, int *tam_vet){
  int len = conta_maioresN(a, n);
  if (!a || len == 0) return NULL;
  *tam_vet = len;

  int *resp = (int*)malloc(sizeof(int) * len);

  int pos = 0;
  preenche_vet(a, n, resp, &pos);
}