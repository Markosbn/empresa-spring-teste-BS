package com.marcosschulz.lancamentoempresa.domain.repository;

import com.marcosschulz.lancamentoempresa.domain.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    List<Empresa> findByRazaoSocial(String razaoSocial);
    List<Empresa> findByRazaoSocialContaining(String razaoSocial);
    List<Empresa> findByCnpjContaining(String cnpjBusca);
    List<Empresa> findByCnpj(String cnpjBusca);
}
