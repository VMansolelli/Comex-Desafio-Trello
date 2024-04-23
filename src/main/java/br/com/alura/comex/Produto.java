package br.com.alura.comex;

public class Produto implements Comparable<Produto> {
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;

    public Produto(String nome, String descricao, double preco, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public int compareTo(Produto outroProduto) {
        if(outroProduto == null){ return 1; }
        int comparacao = 0;
        if(nome != null) {
            comparacao = this.nome.compareTo(outroProduto.nome);
        }
        double diferenca = preco - outroProduto.preco;
        if(diferenca < 0) {
            // Obtem o próximo menor inteiro e soma
            comparacao += Math.floor(diferenca);
        }else if(diferenca > 0) {
            // Obtem o próximo maior inteiro e soma
            comparacao += Math.ceil(diferenca);
        }
        return  comparacao;
    }
}
