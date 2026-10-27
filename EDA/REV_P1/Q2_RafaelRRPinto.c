#include <stdio.h>
#include <stdlib.h>
#include "TG.h"
#include "TLSE.h"

void aux(TG *g, int x, TLSE **vis){
  *vis = TLSE_ins_ini(*vis, x);
  TG *no = TG_busca_no(g, x);
  if(!no) return;

  TVIZ *v = no->prim_viz;
  while(v){
    if(!TLSE_busca(*vis, v->id_viz)){
      aux(g, v->id_viz, vis);
    }   
    v = v->prox_viz;
  }
}

int contaCC(TG *g){
  if(!g) return 0;

  TLSE *vis = NULL;
  int resp = 0;

  TG *atual = g;
  while(atual){
    if(!TLSE_busca(vis, atual->id_no)){
      resp++;
      aux(g, atual->id_no, &vis);
    }
    atual = atual->prox_no;
  }
  TLSE_libera(vis);
  return resp;
}

int main(void){
  TG *g = TG_inicializa();
  int n;
  do{
    scanf("%d", &n);
    if(n <= 0) break;
    g = TG_ins_no(g, n);
  }while(1);
  
  int m;
  do{
    scanf("%d%d", &n, &m);
    if((n <= 0) || (m <= 0)) break;
    TG_ins_aresta(g, n, m);
  }while(1);
  TG_imprime(g);

  printf("Numero de componentes conexos? %d\n", contaCC(g));
    
  TG_libera(g);
  return 0;
}
