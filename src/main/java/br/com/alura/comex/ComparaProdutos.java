package br.com.alura.comex;

public class ComparaProdutos {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Camisa A","Branca", 49.99, 1);
        Produto produto2 = new Produto("Camisa B","Preto", 59.99, 1);

        System.out.println("Comparando produto 1 com produto 2: " + produto1.compareTo(produto2));
    }
}
