import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carrinho {
    private List<Produto> produtos;
    private Map<Produto, Integer> quantidades;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Map<Produto, Integer> getQuantidades() {
        return quantidades;
    }

    public void setQuantidades(Map<Produto, Integer> quantidades) {
        this.quantidades = quantidades;
    }

    public Carrinho() {
        this.produtos = new ArrayList<>();
        this.quantidades = new HashMap<>();

    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (produto.getEstoque() >= quantidade) {
            produtos.add(produto);
            quantidades.put(produto, quantidade);

            produto.subtrairDoEstoque(produto.getEstoque() - quantidade);

            System.out.println(quantidade + " unidades " + produto.getNome() + " adicionado no carrinho ");
        } else {
            System.out.println(" Não há estoque suficiente " + quantidade + "unidades" + produto.getNome() + " ao carrinho. Estoque disponível: " + produto.getEstoque());
        }
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public void alterarQuantidade(Produto produto, int novaQuantidade) {
        if (produto.getEstoque() >= novaQuantidade) {
            produtos.add(produto);
            quantidades.put(produto, novaQuantidade);
        }
        System.out.println("Estoque insuficiente de" + produto.getNome());
    }

    public float calcularTotal() {
        float calculartotal = 0;
        for (Map.Entry<Produto, Integer> entry : quantidades.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            float preco = produto.getPreco();

            calculartotal += quantidade * preco;
        }
        return calculartotal;
    }

    public boolean confirmarCompra() {
        boolean estoqueSuficiente = true;
        for (Map.Entry<Produto, Integer> entry : quantidades.entrySet()) {
            Produto produto = entry.getKey();
            int quantidadeComprada = entry.getValue();

            if (produto.getEstoque() >= quantidadeComprada) {
                int novoEstoque = produto.getEstoque() - quantidadeComprada;
                produto.setEstoque(novoEstoque);
            } else {

                estoqueSuficiente = false;
                break;
            }
        }
        return estoqueSuficiente;
    }
}
