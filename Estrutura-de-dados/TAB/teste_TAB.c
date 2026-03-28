#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "TAB.h"

/*
Dada uma árvore binária, preencha os elementos dessa árvore num vetor em pós-ordem: int* ab2vet_pos(TAB *a)
*/

int conta(TAB* a){
  if(!a) return 0;
  return 1 + conta(a->esq) + conta(a->dir);
}

void aux(TAB* a, int* vet, int* apos){
  if(!a) return;
  aux(a->esq, vet, pos);
  aux(a->dir, vet, pos);
  vet[(*pos)] = a->info;
  (*pos)++;
}
 
int* ab2vet_pos(TAB *a, int *tam){
  (*tam) = 0;
  if(!a) return NULL;
  int *vet;
  int n = conta(a), pos = 0;
  vet = (int *)malloc(sizeof(int) * n);
  (*tam) = n;
  aux(a, vet, &pos);
  return vet;
}

// Nova função para exibir o menu de forma limpa
void exibe_menu() {
    printf("\n================================================\n");
    printf("              MENU ARVORE BINARIA               \n");
    printf("================================================\n");
    printf(" 1. Inserir no na arvore\n");
    printf(" 2. Imprimir arvore (Identada)\n");
    printf(" 3. Imprimir em Pre-ordem\n");
    printf(" 4. Imprimir em Pos-ordem\n");
    printf(" 5. Imprimir em Ordem Simetrica\n");
    printf(" 6. Preencher vetor em pos-ordem (ab2vet_pos)\n");
    printf(" 7. Exibir Maior e Menor no\n");
    printf(" 8. Exibir Altura da arvore\n");
    printf(" 9. Exibir numero de folhas\n");
    printf(" 0. Sair\n");
    printf("================================================\n");
    printf("Escolha uma opcao: ");
}

int main(void){
  TAB *a = NULL;
  TAB *resp = NULL;
  int opcao, no, pai;
  char lado[2];

  do {
      exibe_menu();
      if (scanf("%d", &opcao) != 1) {
          while (getchar() != '\n'); // Limpa o buffer se o usuario digitar letra
          continue;
      }

      switch(opcao) {
          case 1:
              if (a == NULL) {
                  printf("\nA arvore esta vazia. Digite o valor da RAIZ: ");
                  scanf("%d", &no);
                  a = TAB_cria(no, NULL, NULL);
                  printf("=> Raiz [%d] inserida com sucesso!\n", no);
              } else {
                  printf("\nDigite o valor do PAI (deve existir na arvore): ");
                  scanf("%d", &pai);
                  resp = TAB_busca(a, pai);
                  
                  if (!resp) {
                      printf("=> Erro: Pai [%d] nao encontrado na arvore!\n", pai);
                  } else {
                      printf("Digite o valor do NO a ser inserido: ");
                      scanf("%d", &no);
                      printf("Inserir a Esquerda (E) ou Direita (D)? ");
                      scanf("%1s", lado);
                      
                      if (strcmp(lado, "E") == 0 || strcmp(lado, "e") == 0) {
                          if (resp->esq != NULL) {
                              printf("=> Erro: O no [%d] ja possui um filho a esquerda.\n", pai);
                          } else {
                              resp->esq = TAB_cria(no, NULL, NULL);
                              printf("=> No [%d] inserido a ESQUERDA de [%d]!\n", no, pai);
                          }
                      } else if (strcmp(lado, "D") == 0 || strcmp(lado, "d") == 0) {
                          if (resp->dir != NULL) {
                              printf("=> Erro: O no [%d] ja possui um filho a direita.\n", pai);
                          } else {
                              resp->dir = TAB_cria(no, NULL, NULL);
                              printf("=> No [%d] inserido a DIREITA de [%d]!\n", no, pai);
                          }
                      } else {
                          printf("=> Opcao invalida. Use E para esquerda ou D para direita.\n");
                      }
                  }
              }
              break;

          case 2:
              printf("\n--- Arvore Identada ---\n");
              TAB_imp_ident(a);
              break;

          case 3:
              printf("\n--- Pre-ordem ---\n");
              TAB_imp_pre(a);
              printf("\n");
              break;

          case 4:
              printf("\n--- Pos-ordem ---\n");
              TAB_imp_pos(a);
              printf("\n");
              break;

          case 5:
              printf("\n--- Ordem Simetrica ---\n");
              TAB_imp_sim(a);
              printf("\n");
              break;

          case 6:
              if (!a) {
                  printf("\nA arvore esta vazia!\n");
              } else {
                  int tam;
                  int *vet = ab2vet_pos(a, &tam);
                  printf("\n--- Vetor em Pos-ordem ---\n");
                  for(int i = 0; i < tam; i++) {
                      printf("vet[%d] = %d\n", i, vet[i]);
                  }
                  free(vet);
              }
              break;

          case 7:
              if (!a) {
                  printf("\nA arvore esta vazia!\n");
              } else {
                  TAB *maior = TAB_maior(a);
                  TAB *menor = TAB_menor(a);
                  if(maior) printf("\n=> Maior no: %d\n", maior->info);
                  if(menor) printf("=> Menor no: %d\n", menor->info);
              }
              break;

          case 8:
              printf("\n=> Altura da arvore: %d\n", TAB_altura(a));
              break;

          case 9:
              printf("\n=> Numero de folhas: %d\n", nf(a));
              break;

          case 0:
              printf("\nSaindo e liberando a memoria...\n");
              break;

          default:
              printf("\n=> Opcao invalida! Tente novamente.\n");
      }

  } while (opcao != 0);

  // Libera a memória antes de encerrar o programa
  TAB_libera(a);
  return 0;
}