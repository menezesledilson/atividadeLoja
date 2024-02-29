public class Main {
    public static void main(String[] args) {
        Produto camisaProduto = new Produto(" Camisas ", 10.0f, "Categoria  Roupa ", 100);

        Carrinho carrinho = new Carrinho();

        carrinho.adicionarProduto(camisaProduto, 15);
        System.out.println("Quantidade de"+camisaProduto.getNome()+":"+ camisaProduto.getEstoque());

        carrinho.alterarQuantidade(camisaProduto, 10);
        System.out.println("Alteração na quantidade de " +camisaProduto.getNome()+",nova quantidade: "+camisaProduto.getEstoque());

        System.out.println("Quantidade total " + carrinho.calcularTotal());

        boolean compraConfirmada = carrinho.confirmarCompra();
        if (compraConfirmada) {
            System.out.println("Compra confirmada!");
        } else {
            System.out.println("Não foi possível confirmar a compra.");
        }
    }
}