package br.com.guilherme.barros.CarsSystem.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UtilException {

    private static String tratarExceptionRegistroUtilizado(String message){
        if(message.contains(Constantes.ERROR_REGISTRO_UTILIZADO)){
            return Constantes.REGISTRO_UTILIZADO;
        }
        return message;
    }

    public static ResponseEntity mensagemExceptionTratada(Exception e){
        String message;
        if(e.getMessage().contains(Constantes.ERROR_SQL)) message = tratarExceptionRegistroUtilizado(e.getCause().getCause().getMessage());
        else message = e.getMessage();

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
