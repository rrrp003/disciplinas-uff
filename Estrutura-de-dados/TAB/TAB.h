#include <stdio.h>
#include <stdlib.h>

typedef struct arvbin{
  int info;
  struct arvbin *esq, *dir;
}TAB;

typedef struct arvbin_colorida{
  int info;
  int cor;
  struct arvbin_colorida *esq, *dir;
}TAB_cor;

 
TAB *TAB_inicializa(void);
TAB *TAB_cria(int raiz, TAB *esq, TAB *dir);
TAB *TAB_busca(TAB *a, int elem);
TAB *TAB_copia(TAB *a);
TAB *TAB_espelho(TAB *a);
TAB *TAB_maior(TAB *a);
TAB *TAB_menor(TAB *a);

void TAB_imp_pre(TAB *a);
void TAB_imp_pos(TAB *a);
void TAB_imp_sim(TAB *a);
void TAB_imp_ident(TAB *a);
void TAB_libera(TAB *a);

int TAB_altura(TAB *a);
int igual (TAB* a1, TAB* a2);
int nf(TAB *a);
int nf_opt(TAB *a);
int ni(TAB *a);

//TAB_cor abaixo
void colore(TAB_cor *a); //0 sem cor //1 vermelho //2 preto