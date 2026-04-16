package br.com.suporteSenai.suporte.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String handlerRunTimeExcpetion(RuntimeException ex, Model model){
        model.addAttribute("mensagemErro", ex.getMessage());
        return "erro";
    }
}
