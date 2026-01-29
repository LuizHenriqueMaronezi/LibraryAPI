package io.github.LuizHenriqueMaronezi.libraryapi.repository;

import io.github.LuizHenriqueMaronezi.libraryapi.service.TransacaoService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransacoesTest {

    @Autowired
    TransacaoService transacaoService;

    /**
     * Commit -> confirmar alterações
     * Rollback -> desfazer alterações
     */

    @Test
    void transacaoSimples(){
        transacaoService.executar();
    };

    @Test
    void transacaoEstadoManaged(){
        transacaoService.atualizacaoSemAtualizar();
    }
}
