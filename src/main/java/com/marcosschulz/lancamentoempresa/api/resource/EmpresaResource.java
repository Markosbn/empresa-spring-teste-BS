package com.marcosschulz.lancamentoempresa.api.resource;

import com.marcosschulz.lancamentoempresa.domain.model.Empresa;
import com.marcosschulz.lancamentoempresa.domain.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/empresas")
public class EmpresaResource {

    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> buscaTodos(){
        List<Empresa> empresaList = empresaService.buscaTodas();
        return ResponseEntity.ok(empresaList);
    }

    @GetMapping("/{empresaId}")
    public ResponseEntity<Empresa> buscaPorId(@PathVariable Long empresaId){
        return ResponseEntity.ok(empresaService.buscaPorId(empresaId));
    }

    @GetMapping("/razaoSocial")
    public ResponseEntity<List<Empresa>> buscaRazao(@RequestParam String razaoSocial){
        List<Empresa> empresaList = empresaService.buscaPorRazaoSocial(razaoSocial);
        return ResponseEntity.ok(empresaList);
    }

    @GetMapping("/razaoSocialParcial")
    public ResponseEntity<List<Empresa>> buscaRazaoParcial(@RequestParam String razaoSocialParcial){
        List<Empresa> empresaList = empresaService.buscaPorRazaoSocialParcial(razaoSocialParcial);
        return ResponseEntity.ok(empresaList);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa insereEmpresa(@RequestBody Empresa empresa){
        return empresaService.insertEmpresa(empresa);
    }

    @PutMapping("/{}")
    public ResponseEntity<Empresa> alteraEmpresa(@RequestBody Empresa empresa, @PathVariable Long id){
        return ResponseEntity.ok(empresaService.updateEmpresa(id, empresa));
    }

    @DeleteMapping("/{}")
    public ResponseEntity<Void> deletaEmpresa(@PathVariable Long id){
        empresaService.deleteEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}