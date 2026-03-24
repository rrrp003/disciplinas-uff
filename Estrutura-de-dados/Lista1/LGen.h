#include <stdio.h>
#include <stdlib.h>

// inicializar, cria, inserir, remover, buscar, liberar, imprimir, conta

typedef struct NO_gen{
    void *info;
    struct NO_gen *prox;
}lGen;

LGen *LGen_inic(void);

LGen *LGen_cria(LGen *l, void *info);
LGen *LGen_ins(LGen *l, void *info);
LGen *LGen_rm(LGen *l, void *info);

LGen *LGen_busca(LGen *l, void *info, LGen **pre);
LGen *LGen_busca_rec(LGen *l, void *info, LGen **pre);


void LGen_imp(LGen *l);
void LGen_cont(LGen *l);
void LGen_libera(LGen *l);


