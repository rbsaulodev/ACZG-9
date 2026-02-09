package models

class Pessoa implements IPessoa {
    String nome, email, estado, cep, descricao
    List<String> competencias = []

    @Override
    void exibirDados() {
        println "--------------------------------------"
    }
}