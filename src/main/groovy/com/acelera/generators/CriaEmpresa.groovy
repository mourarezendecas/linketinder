package com.acelera.generators
import com.acelera.classes.Empresa

//String nome, email, CNPJ, pais, estado, CEP, descricao;

class CriaEmpresa {
    static def void cria(){
        def comp = 1
        Empresa e = new Empresa()

        printf("Digite o nome da empresa: ")
        e.setNome(System.in.newReader().readLine())
        printf("Digite o email institucional: ")
        e.setEmail(System.in.newReader().readLine())
        printf("Digite o CNPJ da empresa: ")
        e.setCNPJ(System.in.newReader().readLine())
        printf("Digite o país da empresa: ")
        e.setPais(System.in.newReader().readLine())
        printf("Digite o estado em que se localiza: ")
        e.setEstado(System.in.newReader().readLine())
        printf("Digite o CEP: ")
        e.setCEP(System.in.newReader().readLine())
        println("Escreva uma breve descrição")
        e.setDescricao(System.in.newReader().readLine())
        println("---COMPETÊNCIAS---")
        println("Escolha as competências ou digite 0 para sair")
        do
        {
            println("1 - Python")
            println("2 - Java")
            println("3 - Spring Framework")
            println("4 - Angular")
            println("5 - Swift")
            println("6 - Kotlin")
            println("0 - Sair")
            comp = System.in.newReader().readLine() as Integer

            switch (comp)
            {
                case 1:
                    e.competencias.add("Python")
                    println("Python adicionado as competências")
                    break;
                case 2:
                    e.competencias.add("Java")
                    println("Java adicionado as competências")
                    break;
                case 3:
                    e.competencias.add("Spring Framework")
                    println("Spring Framework adicionado as competências")
                    break;
                case 4:
                    e.competencias.add("Angular")
                    println("Angular adicionado as competências")
                    break;
                case 5:
                    e.competencias.add("Swift")
                    println("Swift adicionado as competências")
                    break;
                case 6:
                    e.competencias.add("Kotlin")
                    println("Kotlin adicionado as competências")
                    break;
            }
        }
        while(comp !=0)

        GeraCandidatoeEmpresa.addEmpresas(e)
    }
}
