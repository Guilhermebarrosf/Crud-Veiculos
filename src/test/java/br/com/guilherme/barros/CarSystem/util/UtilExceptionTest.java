package br.com.guilherme.barros.CarSystem.util;

import br.com.guilherme.barros.CarsSystem.util.Constantes;
import br.com.guilherme.barros.CarsSystem.util.UtilException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilExceptionTest {

    @Test
    public void tratar_exception_deve_retornar_string_tratada_se_exception_sql(){
        Exception erroPrimario = new Exception(Constantes.ERROR_SQL);
        Exception causaIntermediaria = new Exception("Causa intermediária");
        causaIntermediaria.initCause(new Exception(Constantes.ERROR_REGISTRO_UTILIZADO));
        erroPrimario.initCause(causaIntermediaria);

        assertEquals(new ResponseEntity<>(Constantes.REGISTRO_UTILIZADO, HttpStatus.INTERNAL_SERVER_ERROR), UtilException.mensagemExceptionTratada(erroPrimario));
    }
    @Test
    public void tratar_exception_deve_retornar_string_tratada_se_outra_exception(){
        Exception erro = new Exception(Constantes.LIST_ERROR);
        assertEquals(new ResponseEntity<>(Constantes.LIST_ERROR, HttpStatus.INTERNAL_SERVER_ERROR), UtilException.mensagemExceptionTratada(erro));
    }

}
