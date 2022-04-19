package carrinho;

import produto.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


@DisplayName("Classe para teste da classe carrinho")
public class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
	}

    // addItem
    @DisplayName("Deve adicionar produto ao carrinho")
	@Test
	public void testAddProdutoAoCarrinho() {
        int qtdAntes = carrinho.getQtdeItems();
        Produto prod = new Produto("teste", 100.00);
		carrinho.addItem(prod);
        int qtdDepois = carrinho.getQtdeItems();
        Assertions.assertEquals(0, qtdAntes);	
		Assertions.assertEquals(1, qtdDepois);	
	}
    
    // removeItem
    @DisplayName("Deve remover produto do carrinho")
	@Test
    public void testRemoveProdutoAoCarrinho() {
        Produto prod = new Produto("teste", 100.00);
        Produto prod2 = new Produto("teste2", 100.00);
		carrinho.addItem(prod);
        carrinho.addItem(prod2);
        int qtdAntes = carrinho.getQtdeItems();
        try {
            carrinho.removeItem(prod);
        } catch(ProdutoNaoEncontradoException e) {
            fail("Exce��o lan�ada");
        }
        int qtdDepois = carrinho.getQtdeItems();
        Assertions.assertEquals(2, qtdAntes);	
		Assertions.assertEquals(1, qtdDepois);	
	}

    @DisplayName("Deve jogar erro se produto não existir no carrinho")
	@Test
    public void testRemoveProdutoNaoPresenteNoCarrinho() {
        Produto prod = new Produto("teste", 100.00);
        Produto prod2 = new Produto("teste2", 100.00);
		carrinho.addItem(prod);
        try {
            carrinho.removeItem(prod2);
            fail("Exce��o não lan�ada");
        } catch(ProdutoNaoEncontradoException e) {
            assertThat(e, instanceOf(ProdutoNaoEncontradoException.class));
        }
	}

    // esvazia
    @DisplayName("Deve remover todos produtos do carrinho")
	@Test
    public void testEsvaziarCarrinho() {
        Produto prod = new Produto("teste", 100.00);
        Produto prod2 = new Produto("teste2", 100.00);
        Produto prod3 = new Produto("teste3", 100.00);
		carrinho.addItem(prod);
        carrinho.addItem(prod2);
        carrinho.addItem(prod3);
        int qtdAntes = carrinho.getQtdeItems();
        carrinho.esvazia();
        int qtdDepois = carrinho.getQtdeItems();
        Assertions.assertEquals(3, qtdAntes);	
		Assertions.assertEquals(0, qtdDepois);	
	}

    // getValorTotal
    @DisplayName("Deve remover todos produtos do carrinho")
	@Test
    public void testGetValorTotalCarrinho() {
        Produto prod = new Produto("teste", 100.00);
        Produto prod2 = new Produto("teste2", 110.00);
        Produto prod3 = new Produto("teste3", 120.00);
		carrinho.addItem(prod);
        carrinho.addItem(prod2);
        carrinho.addItem(prod3);
        double total = carrinho.getValorTotal();
        Assertions.assertEquals(330.00, total);	
	}
    
}
