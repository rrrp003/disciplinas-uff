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
    LGen *pre = NULL; 
    LGen *lixo = LGen_busca(l, info, &pre);
    if (lixo){
        if(!pre) l = l->prox;
        else pre->prox = lixo->prox;
        
        free(lixo);
    }
    return l;
}
LGen *LGen_busca(LGen *l, void *info_buscada, LGen **pre){
    if (!l) return NULL;
    LGen *aux = l;
    LGen *pre_aux = NULL;
    while ((aux) && (aux->info != info_buscada)) { 
        pre_aux = aux;
        aux = aux->prox;
    }
    (*pre) = pre_aux;
    return aux; //algoritmo prof aline nascimento
}
LGen *LGen_busca_rec(LGen *l, void *info, LGen **pre){
    if(!l) return NULL;

    if(l->info == info) return l;

    if(pre) *pre = l;
    return LGen_busca_rec(l->prox, info, &l);
}

void LGen_imp(LGen *l);
void LGen_cont(LGen *l);
void LGen_libera(LGen *l);