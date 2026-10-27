#include "TLSE.h"

TLSE* TLSE_ins_ini(TLSE* l, int elem){
  TLSE *novo = (TLSE *) malloc(sizeof(TLSE));
  novo->info = elem;
  novo->prox = l;
  return novo;
}

void TLSE_imprime(TLSE* l){
  while(l){
    printf("%d ", l->info);
    l = l->prox;
  }
}

void TLSE_libera(TLSE* l){
  TLSE *p = l, *q;
  while(p){
    q = p;
    p = p->prox;
    free(q);
  }
}

TLSE* TLSE_busca(TLSE* l, int elem){
  TLSE *resp = l;
  while((resp) && (resp->info != elem)) resp = resp->prox;
  return resp;
}

TLSE* TLSE_retira(TLSE* l, int elem){
  TLSE *p = l, *ant = NULL;
  while((p) && (p->info != elem)){
    ant = p;
    p = p->prox;
  }
  if(!p) return l;
  if(!ant) l = l->prox;
  else ant->prox = p->prox;
  free(p);
  return l;
}
