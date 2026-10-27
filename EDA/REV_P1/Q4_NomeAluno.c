#include <string.h>
#include "TABB.h"

int aux_diametro(TABB *a, int *max_d) {
  if (!a) return 0;

  int alt_esq = aux_diametro(a->esq, max_d);
  int alt_dir = aux_diametro(a->dir, max_d);

  if (alt_esq + alt_dir + 1 > *max_d) {
    *max_d = alt_esq + alt_dir + 1;
  }

  if (alt_esq > alt_dir) return 1 + alt_esq;
  return 1 + alt_dir;
}

int diametro(TABB *a) {
  int max_d = 0;
  aux_diametro(a, &max_d);
  return max_d;
}

int main(void){
  int n;
  TABB *a = NULL;
  while(1){
    scanf("%d", &n);
    if(n < 0) break;
    a = TABB_insere(a, n);
  }
  TABB_imp_ident(a);
  printf("Diametro da arvore: %d\n", diametro(a)); 
  TABB_libera(a);
  return 0;
}

