import java.util.Scanner;

public class Main {

    static int quantidadeVertices;
    static String[] vertices;
    static int[][] matrizAdjacencia;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("WAR ROOM - SIMULACAO COM GRAFOS");
        System.out.println("Problema: Cobertura de Vertices");
        System.out.println();

        System.out.print("Digite a quantidade de vertices: ");
        quantidadeVertices = scanner.nextInt();
        scanner.nextLine();

        vertices = new String[quantidadeVertices];
        matrizAdjacencia = new int[quantidadeVertices][quantidadeVertices];

        for (int i = 0; i < quantidadeVertices; i++) {
            System.out.print("Nome do vertice " + (i + 1) + ": ");
            vertices[i] = scanner.nextLine();
        }

        System.out.print("Digite a quantidade de arestas: ");
        int quantidadeArestas = scanner.nextInt();

        for (int i = 0; i < quantidadeArestas; i++) {
            System.out.println();
            System.out.println("Aresta " + (i + 1));

            System.out.print("Informe o indice do primeiro vertice (0 a " + (quantidadeVertices - 1) + "): ");
            int origem = scanner.nextInt();

            System.out.print("Informe o indice do segundo vertice (0 a " + (quantidadeVertices - 1) + "): ");
            int destino = scanner.nextInt();

            matrizAdjacencia[origem][destino] = 1;
            matrizAdjacencia[destino][origem] = 1;
        }

        exibirVertices();
        exibirMatriz();

        boolean[] melhorCobertura = encontrarMenorCobertura();

        System.out.println();
        System.out.println("RESULTADO DO WAR ROOM");

        System.out.print("Vertices escolhidos para monitoramento: ");
        int tamanho = 0;

        for (int i = 0; i < quantidadeVertices; i++) {
            if (melhorCobertura[i]) {
                System.out.print(vertices[i] + " ");
                tamanho++;
            }
        }

        System.out.println();
        System.out.println("Tamanho da cobertura: " + tamanho);

        System.out.println();
        System.out.println("ANALISE DE COMPLEXIDADE");
        System.out.println("O problema Vertex Cover pertence a classe dos problemas NP-Completos.");
        System.out.println("A solucao testa diferentes combinacoes de vertices ate encontrar a menor cobertura.");
        System.out.println("Complexidade no pior caso: O(2^V * V^2), pois existem 2^V combinacoes e cada uma pode verificar a matriz.");
        System.out.println("Espaco utilizado: O(V^2), devido ao uso da matriz de adjacencia.");

        scanner.close();
    }

    public static void exibirVertices() {
        System.out.println();
        System.out.println("Vertices cadastrados:");

        for (int i = 0; i < quantidadeVertices; i++) {
            System.out.println(i + " - " + vertices[i]);
        }
    }

    public static void exibirMatriz() {
        System.out.println();
        System.out.println("Matriz de Adjacencia:");

        System.out.print("   ");
        for (int i = 0; i < quantidadeVertices; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < quantidadeVertices; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < quantidadeVertices; j++) {
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean[] encontrarMenorCobertura() {
        boolean[] melhorCobertura = null;
        int menorTamanho = quantidadeVertices + 1;

        int totalCombinacoes = (int) Math.pow(2, quantidadeVertices);

        for (int mascara = 0; mascara < totalCombinacoes; mascara++) {
            boolean[] combinacao = new boolean[quantidadeVertices];
            int tamanhoAtual = 0;

            for (int i = 0; i < quantidadeVertices; i++) {
                if ((mascara & (1 << i)) != 0) {
                    combinacao[i] = true;
                    tamanhoAtual++;
                }
            }

            if (tamanhoAtual < menorTamanho && cobreTodasArestas(combinacao)) {
                melhorCobertura = combinacao;
                menorTamanho = tamanhoAtual;
            }
        }

        return melhorCobertura;
    }

    public static boolean cobreTodasArestas(boolean[] cobertura) {
        for (int i = 0; i < quantidadeVertices; i++) {
            for (int j = i + 1; j < quantidadeVertices; j++) {
                if (matrizAdjacencia[i][j] == 1) {
                    if (!cobertura[i] && !cobertura[j]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
