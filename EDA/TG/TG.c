#include "TG.h"

TG* TG_inicializa(){
  return NULL;
}

void TG_imprime(TG *g){
  while(g){
    printf("Vizinhos do No %d:\n", g->id_no);
    TVIZ *v = g->prim_viz;
    while(v){
      printf("%d ", v->id_viz);
      v = v->prox_viz;
    }
    printf("\n");
    g = g->prox_no;
  }
}

void TG_imp_rec(TG *g){
  if(g){
    printf("%d:\n", g->id_no);
    TVIZ *v = g->prim_viz;
    while(v){
      printf("%d ", v->id_viz);
      v = v->prox_viz;
    }
    TG_imp_rec(g->prox_no);
  }
}

void TG_libera_viz(TVIZ *v){
  while(v){
    TVIZ *temp = v;
    v = v->prox_viz;
    free(temp);
  }
}

void TG_libera_viz_rec(TVIZ *v){
  if(!v) return;
  TG_libera_viz_rec(v->prox_viz);
  free(v);
}

void TG_libera(TG *g){
  while(g){
    TG_libera_viz(g->prim_viz);
    TG *temp = g;
    g = g->prox_no;
    free(temp);
  }
}

void TG_libera_rec(TG *g){
  if(g){
    TG_libera_viz(g->prim_viz);
    TG_libera_rec(g ->prox_no);
    free(g);
  }
}

TG* TG_busca_no(TG* g, int x){
  if((!g) || (g->id_no == x)) return g;
  return(TG_busca_no(g->prox_no, x));
}

TVIZ* TG_busca_aresta(TG *g, int no1, int no2){
  TG *p1 = TG_busca_no(g,no1), *p2 = TG_busca_no(g,no2);
  if((!p1) || (!p2)) return NULL;
  TVIZ *resp = p1->prim_viz;
  while((resp) && (resp->id_viz != no2)) resp = resp->prox_viz;
  return resp;
}

TG* TG_retira_no(TG *g, int no){
  TG *p = g, *ant = NULL;
  while((p)&& (p->id_no != no)){
    ant = p;
    p = p->prox_no;
  }
  if(!p) return g;
  while(p->prim_viz) TG_retira_aresta(g, no, p->prim_viz->id_viz);
  if(!ant) g = g->prox_no;
  else ant->prox_no = p->prox_no;
  free(p);
  return g;
}

TG* TG_ins_no(TG *g, int x){
  TG *p = TG_busca_no(g, x);
  if(!p){
    p = (TG*) malloc(sizeof(TG));
    p->id_no = x;
    p->prox_no = g;
    p->prim_viz = NULL;
    g = p;
  }
  return g;
}

void TG_ins_um_sentido(TG *g, int no1, int no2){
  TG *p = TG_busca_no(g, no1);
  TVIZ *nova = (TVIZ *) malloc(sizeof(TVIZ));
  nova->id_viz = no2;
  nova->prox_viz = p->prim_viz;
  p->prim_viz = nova;
}

void TG_ins_aresta(TG *g, int no1, int no2){
  TVIZ *v = TG_busca_aresta(g, no1, no2);
  if(v) return;
  TG_ins_um_sentido(g, no1, no2);
  TG_ins_um_sentido(g, no2, no1);
}

void TG_retira_um_sentido(TG *g, int no1, int no2){
  TG *p = TG_busca_no(g, no1);
  if(!p) return;
  TVIZ *ant = NULL, *atual = p->prim_viz;
  while((atual)&&(atual->id_viz != no2)){
    ant = atual;
    atual = atual->prox_viz;
  }
  if(!ant) p->prim_viz = atual->prox_viz;
  else ant->prox_viz = atual->prox_viz;
  free(atual);
}

void TG_retira_aresta(TG *g ,int no1, int no2){
  TVIZ* v = TG_busca_aresta(g,no1,no2);
  if(!v) return;
  TG_retira_um_sentido(g,no1,no2);
  TG_retira_um_sentido(g,no2,no1);
}

int nn(TG *g){
  int qtd_nos = 0;
  while(g){ 
    qtd_nos ++;
    g = g->prox_no;
  }
  return qtd_nos;
}

int na(TG *g){
  int qtd_a = 0;
  while(g){
    TVIZ *v = g->prim_viz;
    while(v){
      qtd_a ++;
      v = v->prox_viz;
    }
    g = g->prox_no;
  }
  return qtd_a;
}

int testek(TG *g, int k){
  while(g){
    int grau = 0;
    TVIZ *v = g->prim_viz;
    while(v){
      grau++;
      v = v->prox_viz; 
    }
    if (k != grau) return 0;
    g = g->prox_no;
  }
  return 1;
}

int nao_tem_mesma_cor(TG *g){
  TG *p = g;
  while(p){
    TVIZ *v = p->prim_viz;
    while(v){
      TG *viz = TG_busca_no(g, v->id_viz);
      
      if(viz && p->cor == viz->cor){
        return 0;
      }
      v = v->prox_viz;
    }
    p = p->prox_no;
  } 
  return 1;
}
 
TLSE *aux_caminho_rec(TG *g, int x, int y, TLSE **visitados){
  if (TLSE_busca(*visitados ,g->id_no)) return NULL;

  *visitados = TLSE_insere(*visitados, x);

  if (x == y) return TLSE_insere(NULL, y);

  TG *no = TG_busca_no(g, x);
  if (!no) return NULL;

  TVIZ* v = no->prim_viz;
  while(v){
    TLSE *cam = aux_caminho_rec(g, v->id_viz, y, visitados); // 
    if(cam) return TLSE_insere(cam, x); // inserção do final para o inicio 
    
    v = v->prox_viz;
  }

  return NULL;
}

TLSE *caminho(TG *g, int x, int y) {
    if (!g || !TG_busca_no(g,x) || !TG_busca_no(g, y)) return NULL;
    
  TLSE* visitados = NULL;

  TLSE* resp = aux_caminho_rec(g , x, y, &visitados);

  TLSE_libera(visitados);

  return resp;


}

int aux_conta_caminho(TG* g, int x,int y, TLSE ** visitados){
  if (TLSE_busca(*visitados, x)) return 0;

  *visitados = TLSE_insere(*visitados, x);

  if (x == y) {
    TLSE_retira(*visitados, x);
    return 1;
  }

  TG* no = TG_busca_no(g, x);
  if(!no) return 0;

  int total_cam = 0;

  TVIZ* v = no->prim_viz;
  while(v){
    total_cam += aux_conta_caminho(g, v->id_viz, y, visitados);
    
    v = v->prox_viz;
  }
  *visitados = TLSE_retira(*visitados, x);

  return total_cam;
}

int conta_caminho(TG *g, int x, int y){
  TLSE *visitados = NULL;

  int resp = aux_conta_caminho(g, x, y, &visitados);

  TLSE_libera(visitados);

  return resp;
}

int aux_eh_ciclico(TG *g, int atual, int pai, TLSE **visitados) {
    *visitados = TLSE_insere(*visitados, atual);
    TG *no = TG_busca_no(g, atual);
    if (!no) return 0;

    TVIZ *v = no->prim_viz;
    while (v) {
        if (v->id_viz != pai) {
            if (TLSE_busca(*visitados, v->id_viz)) {
                return 1;
            }
            if (aux_eh_ciclico(g, v->id_viz, atual, visitados)) {
                return 1;
            }
        }
        v = v->prox_viz;
    }
    return 0;
}

int eh_ciclico(TG *g) {
    if (!g) return 0;
    TLSE *visitados = NULL;
    TG *aux = g;

    while (aux) {
        if (!TLSE_busca(visitados, aux->id_no)) {
            if (aux_eh_ciclico(g, aux->id_no, -1, &visitados)) {
                TLSE_libera(visitados);
                return 1;
            }
        }
        aux = aux->prox_no;
    }

    TLSE_libera(visitados);
    return 0;
}

int valida_grau(TG* g){
  while(g){
    g = g->prox_no;
    TVIZ *v = g->prim_viz;
    int x = 0;
    while(v){
      x++;
      if(x > 3) return 0;
      v = v->prox_viz;
    }  
    g = g->prox_no;
  }
  
  return 1;
}

int teste (TG *g){
  if(!g) return 0;

  if(!valida_grau(g)) return 0;

  if ( eh_ciclico(g) ) return 0;

  return 1;
}

TG *busca_no_nome(TG *g, char* nome){
  if(!g) return NULL;

  TG* p = g;

  while(p){
    if (strcmp(nome, p->nome) == 0) return p;
    p = p->prox_no;
  }
  return NULL;
}

int conta_viz(TG *g){
  int viz = 0;
  TVIZ* v = g->prim_viz;
  while (v){
    viz++;
    v = v->prox_viz;
  }
  return viz;
}

int numero_seguidos(TG *g, char *nome){
  TG *p = busca_no_nome(g, nome);
  if (!p) return 0;

  return conta_viz(p);
}

int numero_seguidores(TG *g, char *nome) {
  TG *alvo = busca_no_nome(g, nome);
  if (!alvo) return 0; // Pessoa não existe no grafo

  int seguidores = 0;
  TG *p = g;

  while (p) {
    TVIZ *v = p->prim_viz;
    while (v) {
      if (v->id_viz == alvo->id_no) { 
        seguidores++;
        //printar
        break; 
      }
      v = v->prox_viz;
    }
    p = p->prox_no;
  }
  return seguidores;
}