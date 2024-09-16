/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.de.mercado.simples;


import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeMercadoSimples {

   
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> nomesProdutos = new ArrayList<>();
    private static ArrayList<Double> precosProdutos = new ArrayList<>();
    private static ArrayList<Integer> carrinho = new ArrayList<>();
    
    public static void main(String[] args) {
       exibirMenu();
		selecionarSetor();
		exibirProdutosDisponiveis();
		adicionarProdutosAoCarrinho();
		double total = calcularTotalCompra();
		processarPagamento(total);

    }

    private static void exibirMenu() {
        System.out.println("Bem-vindo ao TitansMarket, selecione:\n");
        System.out.println("1.Setor de Alimentos");
        System.out.println("2.Setor de Bebidas");
        System.out.println("3.Setor de Limpeza");
        System.out.println("4.Açougue");
    }

    private static void selecionarSetor() {
        System.out.println("\nselecione o setor:");
        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1":
                adicionarProdutos("Arroz", 5.00);
                adicionarProdutos("Feijão", 4.50);
                adicionarProdutos("Sal", 1.50);
                adicionarProdutos("Óleo", 3.00);
                adicionarProdutos("Açúcar", 2.50);
                break;
            case "2":
                adicionarProdutos("Refrigerante", 6.00);
                adicionarProdutos("Leite", 4.20);
                adicionarProdutos("Suco", 5.00);
                adicionarProdutos("Água", 2.00);
                adicionarProdutos("Cerveja", 8.00);
                break;
            case "3":
                adicionarProdutos("Amaciante", 10.00);
                adicionarProdutos("Água Sanitária", 5.00);
                adicionarProdutos("Sabão em Pó", 7.00);
                adicionarProdutos("Papel Higiênico", 6.00);
                adicionarProdutos("Detergente", 2.50);
                break;
            case "4":
                adicionarProdutos("Picanha", 50.00);
                adicionarProdutos("Miolo de Acém", 30.00);
                adicionarProdutos("Fraldinha", 25.00);
                adicionarProdutos("Frango", 15.00);
                adicionarProdutos("Porco", 20.00);
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }
    }

    private static void adicionarProdutos(String nome, double preco) {
        nomesProdutos.add(nome);
        precosProdutos.add(preco);
    }

    private static void exibirProdutosDisponiveis() {
        System.out.println("Produtos disponíveis: ");
        for (int i = 0; i < nomesProdutos.size(); i++) {
            System.out.println((i + 1) + ". " + nomesProdutos.get(i) + " - R$ " + precosProdutos.get(i));
        }
    }

    private static void adicionarProdutosAoCarrinho() {
        System.out.println("\nDigite o número do produto para adicionar ao carrinho (0 para finalizar):");
        int produtoEscolhido;
        while ((produtoEscolhido = scanner.nextInt()) != 0) {
            if (produtoEscolhido >= 1 && produtoEscolhido <= nomesProdutos.size()) {
                carrinho.add(produtoEscolhido - 1);
                System.out.println(nomesProdutos.get(produtoEscolhido - 1) + " adicionado ao carrinho.");
            } else {
                System.out.println("Produto inválido.");
            }
            System.out.println("\nDigite o número do próximo produto ou 0 para finalizar:");
        }
    }

    private static double calcularTotalCompra() {
        double total = 0;
        for (int index : carrinho) {
            total += precosProdutos.get(index);
        }
        return total;
    }

    private static void processarPagamento(double total) {
         double restante = 0;
        System.out.println("Total da compra: R$ " + total);
        System.out.println("Digite a quantia de dinheiro que você tem:");
        double dinheiroUsuario = scanner.nextDouble();

        if (dinheiroUsuario >= total) {
            System.out.println("Compra realizada com sucesso! Seu troco é R$ " + (dinheiroUsuario - total));
        } else if(dinheiroUsuario < total) {
              restante = total - dinheiroUsuario;
             System.out.println("Dinheiro insuficiente. Faltam R$ " + restante);
             System.out.println("Digite a quantia de dinheiro que você tem:");
             dinheiroUsuario = scanner.nextDouble();
            while(dinheiroUsuario< restante){
              restante -= dinheiroUsuario;
             System.out.println("Dinheiro insuficiente. Faltam R$ " + restante);
            System.out.println("Digite a quantia de dinheiro que você tem:");
             dinheiroUsuario = scanner.nextDouble();
            
            }
            System.out.println("Compra realizada com sucesso! Seu troco é R$ " + (dinheiroUsuario - restante));
        }
          
    }
}
