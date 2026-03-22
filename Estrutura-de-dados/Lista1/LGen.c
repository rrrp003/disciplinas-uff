#include "No_gen.h"

LGen *LGen_inic(void){
    return NULL;
}
LGen *LGen_cria(LGen *l, void *info){
    LGen *novo = (LGen*) malloc(sizeof(LGen));
    novo->info = info;
    novo->prox = l;
    return novo;
}
LGen *LGen_rm(LGen *l, void *info){
    if (!l) return NULL;
    if (*p = LGen_busca(l, info)){
        
    }
    return NULL;
}
LGen *LGen_busca(LGen *l, void *info_buscada){
    LGen *p = l;
    while (p) { 
        if (p->info == info_buscada) { 
            return p; 
        }    
        p = p->prox; 
        }
    return NULL;
}
LGen *LGen_busca_rec(LGen *l, void *info){
    if (!l) return NULL;

    if(l->info == info) return l;
    
    return(l->prox, info);
}

void LGen_imp(LGen *l);
void LGen_cont(LGen *l);
void LGen_libera(LGen *l);