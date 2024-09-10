package br.com.vitorgabrielti.teste_escriba.exception;

public class ErroNaoMapeadoException extends RuntimeException {
    public ErroNaoMapeadoException(String s) {
        super(s);
    }
}
