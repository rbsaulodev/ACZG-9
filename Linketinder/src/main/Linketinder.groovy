package main

import models.Candidato
import models.Empresa

class Linketinder {
    static List<Candidato> candidatos = []
    static List<Empresa> empresas = []

    static void main(args) {
        // Desenvolvedor: Saulo Brilhante
        popularDados()
        menu()
    }

    static void popularDados() {
        candidatos << new Candidato(
                nome: "Saulo Brilhante",
                email: "saulo@email.com",
                estado: "GO", cep: "74000",
                descricao: "Dev Groovy",
                competencias: ["Java", "Groovy"],
                cpf: "123",
                idade: 25)

        candidatos << new Candidato(
                nome: "Ana Souza",
                email: "ana@email.com",
                estado: "SP",
                cep: "01000",
                descricao: "Frontend",
                competencias: ["Angular", "CSS"],
                cpf: "222",
                idade: 28
        )

        candidatos << new Candidato(
                nome: "Bruno Lima",
                email: "bruno@email.com",
                estado: "RJ", cep: "20000",
                descricao: "Backend",
                competencias: ["Python", "Docker"],
                cpf: "333",
                idade: 22
        )

        candidatos << new Candidato(
                nome: "Carla Dias",
                email: "carla@email.com",
                estado: "MG",
                cep: "30000",
                descricao: "Mobile",
                competencias: ["Flutter"],
                cpf: "444",
                idade: 30
        )

        candidatos << new Candidato(
                nome: "Daniel Silva",
                email: "daniel@email.com",
                estado: "SC", cep: "88000",
                descricao: "Data Science",
                competencias: ["Python", "Pandas"],
                cpf: "555",
                idade: 26
        )

        empresas << new Empresa(
                nome: "Arroz-Gostoso",
                email: "contato@arrozgostoso.com.br",
                cnpj: "12.345.678/0001-01",
                pais: "Brasil",
                estado: "GO",
                cep: "74000-100",
                descricao: "Líder no setor alimentício, buscando automatizar nossa linha de produção.",
                competencias: ["Java", "SQL", "Spring Framework"]
        )

        empresas << new Empresa(
                nome: "Império do Boliche",
                email: "vagas@imperioboliche.com",
                cnpj: "23.456.789/0001-02",
                pais: "Brasil",
                estado: "GO",
                cep: "74000-200",
                descricao: "O maior centro de lazer de Goiás, expandindo nosso sistema de reservas digital.",
                competencias: ["Angular", "TypeScript", "Node.js"]
        )

        empresas << new Empresa(
                nome: "Zup Innovation",
                email: "talents@zup.com.br",
                cnpj: "34.567.890/0001-03",
                pais: "Brasil",
                estado: "SP",
                cep: "04538-132",
                descricao: "Consultoria tecnológica focada em transformação digital e Open Banking.",
                competencias: ["Groovy", "Java", "AWS", "Docker"]
        )

        // Referência ao meu Projeto "Osteria Brilhante" em um contexto corporativo
        empresas << new Empresa(
                nome: "Brilhante Tech Solutions",
                email: "contato@brilhante.io",
                cnpj: "45.678.901/0001-04",
                pais: "Brasil",
                estado: "GO",
                cep: "74123-456",
                descricao: "Fábrica de software especializada em soluções modernas para CNH e educação.",
                competencias: ["Groovy", "Flashcards Engine", "PostgreSQL"]
        )

        empresas << new Empresa(
                nome: "Global Tech Inc",
                email: "hr@globaltech.com",
                cnpj: "56.789.012/0001-05",
                pais: "EUA",
                estado: "NY",
                cep: "10001",
                descricao: "Multinacional focada em soluções de escalabilidade global.",
                competencias: ["Python", "Django", "Kubernetes", "React"]
        )
    }

    static void menu() {
        def scanner = new Scanner(System.in)
        def opcao = -1

        while (opcao != 0) {
            println "\n=== LINKETINDER (GROOVY STYLE) ==="
            println "1. Listar Candidatos | 2. Listar Empresas | 0. Sair"
            print "Escolha: "

            def entrada = scanner.nextLine()
            if (entrada.isInteger()) {
                opcao = entrada.toInteger()
                switch (opcao) {
                    case 1: candidatos.each { it.exibirDados() }; break
                    case 2: empresas.each { it.exibirDados() }; break
                    case 0: println "Até mais!"; break
                    default: println "Opção inválida!"
                }
            }
        }
    }
}