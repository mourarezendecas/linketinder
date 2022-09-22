"use strict";
//---CLASSES---
//Classe candidato
class Candidato {
    constructor() {
        this.nome = '';
        this.cpf = '';
        this.idade = '';
        this.cep = '';
        this.estado = '';
        this.cidade = '';
        this.email = '';
        this.descricao = '';
        this.competencias = [];
    }
}
//Classe Empresa
class Empresa {
    constructor() {
        this.nome = '';
        this.email_corporativo = '';
        this.estado = '';
        this.cnpj = '';
        this.cep = '';
        this.descricao = '';
        this.competencias = [];
    }
}
//---VARIÁVEIS GLOBAIS---
//Variável que irá guardar os candidatos instanciados, é uma array do tipo Candidato, classe que criamos anteriormente.
let listaCandidatos = [];
//Variável que irá guardar as empresas instanciadas, é uma array do tipo Empresa, classe que criamos anteriormente.
let listaEmpresas = [];
//---GERADORES DE EMPRESAS E CANDIDATOS---
//Setando uma lista de candidatos e empresas para usarmos futuramente
geraCandidato();
geraEmpresa();
//Função que gera 5 candidatos para testes
function geraCandidato() {
    let c1 = new Candidato;
    c1.nome = 'Gabriel Rezende';
    c1.email = 'gabrielrezende@gmail.com';
    c1.idade = '25';
    c1.cpf = '000.000.000-00';
    c1.estado = 'GO';
    c1.cep = '74000-000';
    c1.descricao = 'Proativo e etc';
    c1.competencias = ['Python', 'Java', 'Spring Framework', 'Angular', 'Swift', 'Kotlin'];
    listaCandidatos.push(c1);
    let c2 = new Candidato;
    c2.nome = 'Alana Freitas';
    c2.email = 'alanafreitas@gmail.com';
    c2.idade = '23';
    c2.cpf = '000.000.000-00';
    c2.estado = 'SP';
    c2.cep = '74000-000';
    c2.descricao = 'Proativo e etc';
    c2.competencias = ['Python', 'Java', 'Swift', 'Kotlin'];
    listaCandidatos.push(c2);
    let c3 = new Candidato;
    c3.nome = 'Maria Eduarda';
    c3.email = 'mariaeduarda@gmail.com';
    c3.idade = '27';
    c3.cpf = '000.000.000-00';
    c3.estado = 'RJ';
    c3.cep = '74000-000';
    c3.descricao = 'Esforçada';
    c3.competencias = ['Python'];
    listaCandidatos.push(c3);
    let c4 = new Candidato;
    c4.nome = 'Paulo Ricardo';
    c4.email = 'pauloricardo@gmail.com';
    c4.idade = '54';
    c4.cpf = '000.000.000-00';
    c4.estado = 'GO';
    c4.cep = '74000-000';
    c4.descricao = 'Honesto';
    c4.competencias = ['Swift', 'Kotlin'];
    listaCandidatos.push(c4);
    let c5 = new Candidato;
    c5.nome = 'Mark Zuckeberg';
    c5.email = 'himark@gmail.com';
    c5.idade = '40';
    c5.cpf = '000.000.000-00';
    c5.estado = 'US';
    c5.cep = '74000-000';
    c5.descricao = 'Vai roubar a sua vaga';
    c5.competencias = ['Kotlin'];
    listaCandidatos.push(c5);
}
//Função que gera 5 empresas para testes
function geraEmpresa() {
    let e1 = new Empresa;
    e1.nome = 'Apple';
    e1.email_corporativo = 'jobs@apple.com';
    e1.cnpj = '00.000.0001/00';
    e1.estado = 'CA';
    e1.cep = '123123123';
    e1.descricao = 'One more thing...';
    e1.competencias = ['Java', 'Spring Framework', 'Angular', 'Kotlin'];
    listaEmpresas.push(e1);
    let e2 = new Empresa;
    e2.nome = 'ZG Soluções';
    e2.email_corporativo = 'jobs@zg.com';
    e2.cnpj = '00.000.0001/00';
    e2.estado = 'GO';
    e2.cep = '123123123';
    e2.descricao = 'Solucionando';
    e2.competencias = ['Python', 'Java', 'Spring Framework', 'Angular'];
    listaEmpresas.push(e2);
    let e3 = new Empresa;
    e3.nome = 'Amazon';
    e3.email_corporativo = 'jobs@amazon.com';
    e3.cnpj = '00.000.0001/00';
    e3.estado = 'SP';
    e3.cep = '123123123';
    e3.descricao = "Jeff Bezzos' little childs";
    e3.competencias = ['Python', 'Java', 'Spring Framework', 'Angular', 'Swift', 'Kotlin'];
    listaEmpresas.push(e3);
    let e4 = new Empresa;
    e4.nome = 'Roystar Royco';
    e4.email_corporativo = 'jobs@roystar.com';
    e4.cnpj = '00.000.0001/00';
    e4.estado = 'USA';
    e4.cep = '123123123';
    e4.descricao = 'Mantendo em família';
    e4.competencias = ['Python', 'Java', 'Spring Framework', 'Angular', 'Swift', 'Kotlin'];
    listaEmpresas.push(e4);
    let e5 = new Empresa;
    e5.nome = 'Nubank';
    e5.email_corporativo = 'jobs@nubank.com';
    e5.cnpj = '00.000.0001/00';
    e5.estado = 'SP';
    e5.cep = '123123123';
    e5.descricao = 'Pensando roxo';
    e5.competencias = ['Swift', 'Kotlin'];
    listaEmpresas.push(e5);
}
//--FUNÇÕES--
//Função que valida o nome do candidato.
function validaNome(nome) {
    let regexNome = /^[a-z ,.'-]+$/gi; //Regex que valida se o nome está inserido corretamente. 
    if (regexNome.test(nome)) {
        return true; //Caso seja válido, o sistema irá retornar true
    }
    else {
        window.alert('Nome incorreto!'); //Caso esteja incorreto, o sistema notificará o usuário.
        return false; // E retornarar false
    }
}
//Função que valida o CPF do candidato. 
function validaCPF(CPF) {
    let regexCPF = /\d{3}\d{3}\d{3}\d{2}/gi; //RegEx responsável por validar o CPF
    if (regexCPF.test(CPF)) {
        return true; //Caso seja válido, esta função irá retornar true.
    }
    else {
        window.alert('CPF Incorreto!'); //Caso esteja incorreto, o sistema notificará o usuário.
        return false;
    }
}
//Função que valida CEP.
function validaCEP(CEP) {
    let regexCEP = /^[0-9]{5}-?[0-9]{3}$/gi; //RegEx responsável por validar o CEP
    if (regexCEP.test(CEP)) {
        return true; //Caso seja válido, o sistema irá adicionar o CEP do candidato no objeto instanciado.
    }
    else {
        window.alert('CEP Incorreto!'); //Caso esteja incorreto, o sistema notificará o usuário.
        return false;
    }
}
//Função que valida email.
function validaEmail(email) {
    let regexEmail = /\S+@\w+\.\w{2,6}(\.\w{2})?/gi; //RegEx de validação do email
    if (regexEmail.test(email)) {
        return true; //Caso seja válido,a função retornará true.
    }
    else {
        window.alert('Email incorreto!'); //Caso negativa, o sistema apresenta uma mensagem de erro.
        return false; // E retorna false
    }
}
//Função que valida cidade.
function validaCidade(cidade) {
    let regexNome = /^[a-z ,.'-]+$/gi; //Regex que valida se o nome está inserido corretamente. 
    if (regexNome.test(cidade)) {
        return true; //Caso seja válido, o sistema irá retornar true
    }
    else {
        window.alert('Nome incorreto!'); //Caso esteja incorreto, o sistema notificará o usuário.
        return false; // E retornarar false
    }
}
//---BOTÕES---
//Botão para ir para a área de Cadastro de Candidato
const gotoCadastroCandidato = document.getElementById('button_candidato');
gotoCadastroCandidato === null || gotoCadastroCandidato === void 0 ? void 0 : gotoCadastroCandidato.addEventListener('click', function handleClick(event) {
    console.log('Cadastro candidato selecionado');
    window.location.assign('../pages/cadastro-candidato.html');
});
//Botão para ir para a área de Cadastro de Empresa
const gotoCadastroEmpresa = document.getElementById('button_empresa');
gotoCadastroEmpresa === null || gotoCadastroEmpresa === void 0 ? void 0 : gotoCadastroEmpresa.addEventListener('click', function handleClick(event) {
    console.log('Cadastro candidato selecionado');
    window.location.assign('../pages/cadastro-empresa.html');
});
//Botão para submeter um novo Candidato
const submitCandidato = document.getElementById('inputCandidato');
submitCandidato === null || submitCandidato === void 0 ? void 0 : submitCandidato.addEventListener('click', function handleClick(event) {
    //Instancia um candidato para setarmos os atributos 
    let candidato = new Candidato;
    //Coletando o nome do candidato
    const inputNomeCandidato = document.getElementById('inputName');
    const nomeCandidato = inputNomeCandidato.value;
    //Coletando o CPF e adicionando na instancia
    const inputCPFCandidato = document.getElementById('inputCPF');
    const CPFCandidato = inputCPFCandidato.value;
    //Coletando a data de nasc. e adicionando na instancia - Corrigir isso depois
    const inputIdade = document.getElementById('inputIdade');
    candidato.idade = inputIdade === null || inputIdade === void 0 ? void 0 : inputIdade.value;
    //Coletando o CEP e adicionando na instancia
    const inputCEPCandidato = document.getElementById('inputCEP');
    const CEPCandidato = inputCEPCandidato.value;
    //Coletando o Estado e adicionando na instancia
    const inputEstadoCandidato = document.getElementById('inputEstado');
    candidato.estado = inputEstadoCandidato === null || inputEstadoCandidato === void 0 ? void 0 : inputEstadoCandidato.value;
    //Coletando a cidade e adicionando na instancia
    const inputCidadeCandidato = document.getElementById('inputEstado');
    const cidadeCandidato = inputCidadeCandidato.value;
    //Coletando o e-mail e adicionado na instancia 
    const inputEmailCandidato = document.getElementById('inputEmail');
    const emailCandidato = inputEmailCandidato.value;
    //Coletando a descrição e adicionado na instancia 
    const inputDescricaoCandidato = document.getElementById('descricaoCandidato');
    candidato.descricao = inputDescricaoCandidato === null || inputDescricaoCandidato === void 0 ? void 0 : inputDescricaoCandidato.value;
    //Coletando as competências 
    var element = document.getElementById("pythonCheckbox");
    if (element.checked) {
        candidato.competencias.push(element.value);
    }
    var element = document.getElementById("javaCheckbox");
    if (element.checked) {
        candidato.competencias.push(element.value);
    }
    var element = document.getElementById("springCheckbox");
    if (element.checked) {
        candidato.competencias.push(element.value);
    }
    var element = document.getElementById("angularCheckbox");
    if (element.checked) {
        candidato.competencias.push(element.value);
    }
    var element = document.getElementById("swiftCheckbox");
    if (element.checked) {
        candidato.competencias.push(element.value);
    }
    var element = document.getElementById("kotlinCheckbox");
    if (element.checked) {
        candidato.competencias.push(element.value);
    }
    //Adiciona o candidato instânciado na lista de candidatos
    if (validaNome(nomeCandidato) && validaCPF(CPFCandidato) && validaCEP(CEPCandidato) && validaEmail(emailCandidato) && validaCidade(cidadeCandidato)) {
        candidato.nome = nomeCandidato;
        candidato.cpf = CPFCandidato;
        candidato.cep = CEPCandidato;
        candidato.email = emailCandidato;
        candidato.cidade = cidadeCandidato;
        listaCandidatos.push(candidato);
        console.log('Submeteu o Candidato!');
    }
    //Redireciona o candidato para a próxima página
    console.log(candidato);
    console.log(listaCandidatos);
});
//Botão para submeter uma nova Empresa
const submitEmpresa = document.getElementById('botao-cadastrar-empresa');
submitEmpresa === null || submitEmpresa === void 0 ? void 0 : submitEmpresa.addEventListener('click', function handleClick(event) {
    //Instancia um candidato para setarmos os atributos 
    let empresa = new Empresa;
    //Coletando o nome e adicionando na instância de Candidato
    const inputNomeEmpresa = document.getElementById('nome-empresa');
    empresa.nome = inputNomeEmpresa === null || inputNomeEmpresa === void 0 ? void 0 : inputNomeEmpresa.value;
    //Coletando o CPF e adicionando na instancia
    const inputCNPJEmpresa = document.getElementById('cnpj-empresa');
    empresa.cnpj = inputCNPJEmpresa === null || inputCNPJEmpresa === void 0 ? void 0 : inputCNPJEmpresa.value;
    //Coletando o CEP e adicionando na instancia
    const inputCEPEmpresa = document.getElementById('cep-empresa');
    empresa.cep = inputCEPEmpresa === null || inputCEPEmpresa === void 0 ? void 0 : inputCEPEmpresa.value;
    //Coletando o Estado e adicionando na instancia
    const inputEstadoEmpresa = document.getElementById('estado-empresa');
    empresa.estado = inputEstadoEmpresa === null || inputEstadoEmpresa === void 0 ? void 0 : inputEstadoEmpresa.value;
    //Coletando o e-mail e adicionado na instancia 
    const inputEmailEmpresa = document.getElementById('email-empresa');
    empresa.email_corporativo = inputEmailEmpresa === null || inputEmailEmpresa === void 0 ? void 0 : inputEmailEmpresa.value;
    //Coletando a descrição e adicionado na instancia 
    const inputDescricaoEmpresa = document.getElementById('descricao-empresa');
    empresa.descricao = inputDescricaoEmpresa === null || inputDescricaoEmpresa === void 0 ? void 0 : inputDescricaoEmpresa.value;
    //Adiciona o candidato instânciado na lista de candidatos
    listaEmpresas.push(empresa);
    window.location.assign('../pages/pagina-empresa.html');
    console.log(empresa);
    console.log(listaEmpresas);
    console.log('submeteu');
});
//---GERADORES DE HTML--- 
//Gerador de empresas na página de candidatos 
let i = 0;
const elementEmpresas = document.createElement('div');
listaEmpresas.forEach(function (value) {
    elementEmpresas.innerHTML +=
        elementEmpresas.innerHTML = `
    <br>
    <h2 id="titulo-empresa">Nome da empresa: ${listaEmpresas[i].nome}</h2>
    <p id="descricao-empresa">Descrição: ${listaEmpresas[i].descricao}</p>
    <p id="competencias-empresa">Competências: ${listaEmpresas[i].competencias}</p>
    <p id="email-empresa">E-mail: ${listaEmpresas[i].email_corporativo}</p>
    <button id='like'>LIKE</button>
    <button id='dislike'>DISLIKE</button>
  `;
    i++;
});
const empresasCandidato = document.getElementById('mostrar-empresa');
empresasCandidato === null || empresasCandidato === void 0 ? void 0 : empresasCandidato.appendChild(elementEmpresas);
//Gerador de candidatos na página de empresas
i = 0;
const elementCandidatos = document.createElement('div');
listaCandidatos.forEach(function (value) {
    elementCandidatos.innerHTML +=
        elementCandidatos.innerHTML = `
  <br>
  <h2 id="nome-candidato">Nome do candidato: ${listaCandidatos[i].nome}</h2>
  <p id="descricao-candidato">Descrição: ${listaCandidatos[i].descricao}</p>
  <p id="competencias-candidato">Competências: ${listaCandidatos[i].competencias}</p>
  <p id="email">E-mail: ${listaCandidatos[i].email}</p>
  <button id='like'>LIKE</button>
  <button id='dislike'>DISLIKE</button>
  `;
    i++;
});
const candidatoEmpresa = document.getElementById('mostrar-candidatos');
candidatoEmpresa === null || candidatoEmpresa === void 0 ? void 0 : candidatoEmpresa.appendChild(elementCandidatos);
