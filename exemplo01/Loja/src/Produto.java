import com.sun.jdi.FloatType;

public class Produto {
    private Long id;
    private String nome;
    private Float preco;
    private String categoria;
    private int estoque;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
        if (estoque >= 0) {
            this.estoque = estoque;
        } else {
            System.out.println("Estoque vazio");
        }
    }

    public Produto(String nome, Float preco, String categoria, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.estoque = estoque;
    }

    public void subtrairDoEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println(" Quantidade invalida.");
            return;
        }
        if (quantidade > estoque) {
            System.out.println(" Quantidade insuficiente.");
            return;
        }
        estoque -= quantidade;
        System.out.println(quantidade + " unidades " + nome + " foram removidas do estoque.");
    }

    public void reporEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println(" Quantidade invalida.");
            return;
        }

        estoque += quantidade;
        System.out.println(quantidade + "unidades " + nome + "foram somadas do estoque.");
    }

}
