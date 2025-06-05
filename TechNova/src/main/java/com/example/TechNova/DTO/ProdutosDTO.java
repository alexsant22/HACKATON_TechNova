package com.example.TechNova.DTO;

import com.example.TechNova.Entity.Imagens_Produto;
import com.example.TechNova.Entity.Produtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutosDTO {
    // Atributos
    private int id;
    private String nome;
    private String textoDescritivo;
    private String cor;
    private String fabricante;
    private BigDecimal preco;
    private int quantidade;
    private List<String> imagens; // Lista de URLs

    // Transformação de Entidade para DTO
    public static ProdutosDTO toDTO(Produtos produto) {
        List<String> urls = produto.getImagens().stream()
                .map(Imagens_Produto::getUrl_imagem)
                .toList();

        return new ProdutosDTO(
                produto.getId(),
                produto.getNome(),
                produto.getTextoDescritivo(),
                produto.getCor(),
                produto.getFabricante(),
                produto.getPreco(),
                produto.getQuantidade(),
                urls
        );
    }

    // Transformação de DTO para Entidade
    public Produtos toEntity() {
        Produtos produto = new Produtos();
        produto.setId(this.id);
        produto.setNome(this.nome);
        produto.setTextoDescritivo(this.textoDescritivo);
        produto.setCor(this.cor);
        produto.setFabricante(this.fabricante);
        produto.setPreco(this.preco);
        produto.setQuantidade(this.quantidade);

        List<Imagens_Produto> imagens = this.imagens.stream()
                .map(url -> {
                    Imagens_Produto img = new Imagens_Produto();
                    img.setUrl_imagem(url);
                    img.setProduto(produto);
                    return img;
                })
                .toList();

        produto.setImagens(imagens);
        return produto;
    }
}