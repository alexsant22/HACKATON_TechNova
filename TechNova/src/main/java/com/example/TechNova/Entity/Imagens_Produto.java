package com.example.TechNova.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Imagens_Produto {
    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(nullable = false, length = 250)
    public String url_imagem;

    // Relacionamento
    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_imagens_produto_produto"))
    private Produtos produto;
}
