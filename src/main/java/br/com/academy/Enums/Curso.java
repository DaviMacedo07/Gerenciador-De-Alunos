package br.com.academy.Enums;

public enum Curso {

    ADMINISTRAÇÃO("Administracao"),
    FILOSOFIA("Filosofia"),
    MEDICINA("Medicina"),
    DIREITO("Direito"),
    PSICOLOGIA("Psicologia");


    private String curso;

    private Curso(String curso) {
        this.curso = curso;
    }

}
