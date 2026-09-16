#include "TAB.h"

TAB *TAB_inicaliza(void){
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

  if (!a) return NULL; // caso base
  if(a->info == elem) return a; // achei

  TAB *x = TAB_busca(a->esq, elem);

  if (x) return x;

  return TAB_busca(a->dir, elem);
   
}

TAB *TAB_maior(TAB *a){
  if (!a) return NULL; // caso base

  TAB *maior = a;
  TAB *maior_esq = TAB_maior(a->esq);
  TAB *maior_dir = TAB_maior(a->dir);

  if((maior_esq) && (maior_esq->info > maior->info))
    maior = maior->esq;
  if((maior_dir) && (maior_dir->info > maior->info))
    maior = maior->dir;  

   return maior; 
 }

/*TAB* retira_pares (TAB* arv){
  if (!arv) return NULL;

  TAB *aux = arv;

  arv->esq = retira_pares(arv->esq);
  arv->dir = retira_pares(arv->dir);
  
  if (arv->info % 2 == 0) {
    if (!arv->esq && !arv->dir){
      free(arv);
      return NULL;
    }
    else if(!arv->esq){
      free(arv);
      return arv->dir;
    }
    else if(!arv->dir){
      free(arv);
      return arv->esq;
    }
  }
}*/

void imp_aux(TAB *a, int andar){
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

void TAB_imp_ident(TAB *a){
  imp_aux(a, 0);
}

void TAB_libera(TAB *a){

  if (!a) return;

  TAB_libera(a->esq);
  TAB_libera(a->dir);

  free(a);
 }

void TAB_imp_pre(TAB *a){
  if (a){
    printf("%d", a->info);
    TAB_imp_pre(a->esq);
    TAB_imp_pre(a->dir);
  }
 }

void TAB_imp_pos(TAB *a){
   if (a){
    TAB_imp_pos(a->esq);
    TAB_imp_pos(a->dir);
    printf("%d", a->info);
  }
}

void TAB_imp_sim(TAB *a){
  if(a){ 
  TAB_imp_sim(a->esq);
  printf("%d", a->info);
  TAB_imp_sim(a->dir);
  }
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
  return (igual(a1->esq, a2->esq) && igual(a1->dir, a2->dir));
}

int nf(TAB *a){
  if (!a) return 0;
  if (!a->dir && !a->esq) return 1;

  return nf(a->esq) + nf(a->dir);
}

int TAB_altura(TAB *a){
  if (!a) return -1;
  
  int alt_esq = TAB_altura(a->esq) + 1;
  int alt_dir = TAB_altura(a->dir) + 1;

  if(alt_esq >= alt_dir) return alt_esq;
  return alt_dir;
  
}

int aux_misc(TAB*a, int nv){
  int sum = 0;
  
  if (!a) return 0;

  if (nv % 2 == 0) {
    sum = - a->info;
  }
  else sum = a->info;

  return sum + aux_misc(a->esq, nv + 1) + aux_misc(a->dir, nv + 1);
}

int misc1(TAB *a){
  return aux_misc(a, 0);
}

int soma_caminho(TAB *a, int N){
  if (!a) return 0;

  int total = 0;

  if (a->info == N) {
      total++;
  }
  total += caminhos_a_partir_do_no(a->esq, N - a->info);
  total += caminhos_a_partir_do_no(a->dir, N - a->info);

  return total;
}

int quant_caminhos(TAB *a, int N){
  if (!a) return 0;

  int no_atual = soma_caminhos(a, N);

  int esq = quant_caminhos(a->esq, N);

  int dir = quant_caminhos(a->dir, N);

  return no_atual + esq + dir;
}

TAB *maior_nivel(TAB *a, int N, int M) { 

  if (!a) return NULL;

  if (a->info == N || a->info == M) return a;

  TAB *esq = maior_nivel(a->esq, N, M);
  TAB *dir = maior_nivel(a->dir, N, M);

  if (esq && dir ) {
      return a;
  }

  if (esq) {
      return esq;
  } else {
      return dir;
  }
}

void aux_TAB_media(TAB *a, int* qtd, float* soma, int nv){
  if(!a) return;

  soma[nv] += a->info;
  qtd[nv]++;

  aux_TAB_media(a->esq, qtd, soma, nv+1);
  aux_TAB_media(a->dir, qtd, soma, nv+1);
}

float *TAB_media(TAB *a, int *tam_vet){
  int len = TAB_altura(a) +1;
  *tam_vet = len;
  if (!a ||len == 0) return NULL;


  float *soma = (float*) malloc (sizeof(float)*len);
  int *qtd = (int*) malloc (sizeof(int)*len);
  float *resp = (float*) malloc (sizeof(float)*len);

  for(int i = 0; i < len; i++){
    soma[i] = 0;
    qtd[i] = 0;
  }

  aux_TAB_media(a, qtd, soma, 0);

  for(int i = 0; i < len; i++){
    resp[i] = soma[i] / (float)qtd[i];
  }
  free(soma);
  free(qtd);

  return resp;
}