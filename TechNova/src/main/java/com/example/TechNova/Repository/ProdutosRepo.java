package com.example.TechNova.Repository;

import com.example.TechNova.Entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepo extends JpaRepository<Produtos, Integer> {
}
