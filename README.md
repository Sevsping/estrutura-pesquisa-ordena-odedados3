# Estrutura, Pesquisa e Ordenação de Dados II

## Simulação de War Room com Grafos

Este projeto foi desenvolvido para a disciplina de Estruturas de Dados II, com o objetivo de aplicar conceitos de grafos na resolução de um problema clássico da computação.

---

## Contexto

Uma rede de computadores foi comprometida e precisa ser analisada.  
Cada dispositivo da rede é representado como um vértice e cada conexão como uma aresta.

O objetivo é identificar um conjunto mínimo de vértices que consiga monitorar todas as conexões da rede.

---

## Problema

O problema abordado é o **Vertex Cover (Cobertura de Vértices)**.

Dado um grafo não direcionado, deseja-se encontrar o menor conjunto de vértices tal que todas as arestas estejam cobertas por pelo menos um vértice do conjunto.

---

## Relação com outros problemas

Existem outros problemas clássicos de grafos, como o Problema do Caixeiro Viajante.

Assim como o Vertex Cover, esses problemas envolvem encontrar soluções otimizadas em grafos e estão relacionados à complexidade computacional.

Neste trabalho, o foco principal é o problema de Cobertura de Vértices (Vertex Cover), conforme solicitado.

---

## Objetivo do Sistema

O sistema desenvolvido permite:

- Inserir vértices manualmente pelo terminal  
- Inserir arestas entre os vértices  
- Representar o grafo utilizando matriz de adjacência  
- Encontrar uma solução para o problema de Vertex Cover  
- Exibir:
  - Vértices selecionados  
  - Tamanho da cobertura  
  - Matriz de adjacência do grafo  

---

## Como executar

Compile o programa:

```bash
cd src
javac Main.java
```

Execute:

```bash
java Main
```

---

## Exemplo de uso

Entrada:

```
Quantidade de vertices: 3
Nome dos vertices:
A
B
C

Quantidade de arestas: 2

Aresta 1:
0 1
Aresta 2:
1 2
```

Saída esperada:

```
Vertices escolhidos para monitoramento: B
Tamanho da cobertura: 1
```
---

## Representação do Grafo

O grafo utilizado é **não direcionado**, ou seja, as conexões não possuem sentido.

Se existe uma aresta entre dois vértices A e B, então:

A — B = B — A

A representação é feita utilizando **matriz de adjacência**, onde:

- 1 indica que existe conexão entre dois vértices  
- 0 indica que não existe conexão  

Por se tratar de um grafo não direcionado, a matriz é **simétrica**.  

---

## Complexidade

O problema de Vertex Cover pertence à classe dos problemas NP-Completos.

A solução implementada testa diferentes combinações de vértices até encontrar a menor cobertura possível.

- Tempo (pior caso): O(2^V * V²)  
- Espaço: O(V²)  

---

## Observação

Este projeto foi desenvolvido com foco didático, utilizando:

- Entrada via terminal  
- Estrutura simples  
- Implementação direta do algoritmo  
