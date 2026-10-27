#include <stdio.h>
#include <stdlib.h>

typedef struct lse{
  int info;
  struct lse *prox; 
}TLSE;

TLSE* TLSE_ins_ini(TLSE* l, int elem);
void TLSE_imprime(TLSE* l);
void TLSE_libera(TLSE* l);
TLSE* TLSE_busca(TLSE* l, int elem);
TLSE* TLSE_retira(TLSE* l, int elem);

