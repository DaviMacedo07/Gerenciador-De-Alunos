package br.com.academy.Enums;

public enum Curso {

    ADMINISTRACAO("Administracao"),
    CIENCIADACOMPUTACAO("Ciecia-da-Computacao"),
    MEDICINA("Medicina"),
    DIREITO("Direito"),
    PSICOLOGIA("Administracao");

    private String curso;

    private Curso(String curso) {
        this.curso = curso;
    }

}
