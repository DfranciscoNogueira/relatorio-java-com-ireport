package br.com.estudo.util;

import java.io.File;

public class Utilitario {
    
    public String getResourceDoClasspath(String nomeArquivo) {
        File file = new File(getClass().getClassLoader().getResource(nomeArquivo).getFile());
        return file.toPath().toString();
    }

}
