package com.example.TechNova.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produtos {
    // Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 250)
    private String textoDescritivo;

    @Column(nullable = false, length = 50)
    private String cor;

    @Column(nullable = false, length = 100)
    private String fabricante;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false)
    private int quantidade;

    // Relacionamento
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imagens_Produto> imagens;
}
