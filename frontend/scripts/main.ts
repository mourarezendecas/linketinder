//---CLASSES---
//Classe candidato
class Candidato{ 
    nome: string = ''
    cpf: string = ''
    idade: string = ''
    cep: string = ''
    estado: string = ''
    email: string = ''
    descricao: string = ''
    competencias: Array<string> = []
}
//Classe Empresa
class Empresa{ 
  nome: String = ''
  email_corporativo: String = ''
  estado: String = ''
  cnpj: String = ''
  cep: String = ''
  descricao: String = ''
  competencias: Array<string> = []
}

//---VARIÁVEIS GLOBAIS---
//Variável que irá guardar os candidatos instanciados, é uma array do tipo Candidato, classe que criamos anteriormente.
let listaCandidatos: Array<Candidato> = [];
//Variável que irá guardar as empresas instanciadas, é uma array do tipo Empresa, classe que criamos anteriormente.
let listaEmpresas: Array<Empresa> = []; 

//---GERADORES DE EMPRESAS E CANDIDATOS---
//Setando uma lista de candidatos e empresas para usarmos futuramente
geraCandidato();
geraEmpresa();
//Função que gera 5 candidatos para testes
function geraCandidato (){
  let c1 = new Candidato
  c1.nome = 'Gabriel Rezende'
  c1.email = 'gabrielrezende@gmail.com'
  c1.idade = '25'
  c1.cpf = '000.000.000-00'
  c1.estado = 'GO'
  c1.cep = '74000-000'
  c1.descricao = 'Proativo e etc'
  c1.competencias = ['Python','Java','Spring Framework','Angular','Swift','Kotlin']
  listaCandidatos.push(c1)

let c2 = new Candidato
c2.nome = 'Alana Freitas'
c2.email = 'alanafreitas@gmail.com'
c2.idade = '23'
c2.cpf = '000.000.000-00'
c2.estado = 'SP'
c2.cep = '74000-000'
c2.descricao = 'Proativo e etc'
c2.competencias = ['Python','Java','Swift','Kotlin']
listaCandidatos.push(c2)

let c3 = new Candidato
c3.nome = 'Maria Eduarda'
c3.email = 'mariaeduarda@gmail.com'
c3.idade = '27'
c3.cpf = '000.000.000-00'
c3.estado = 'RJ'
c3.cep = '74000-000'
c3.descricao = 'Esforçada'
c3.competencias = ['Python']
listaCandidatos.push(c3)

let c4 = new Candidato
c4.nome = 'Paulo Ricardo'
c4.email = 'pauloricardo@gmail.com'
c4.idade = '54'
c4.cpf = '000.000.000-00'
c4.estado = 'GO'
c4.cep = '74000-000'
c4.descricao = 'Honesto'
c4.competencias = ['Swift','Kotlin']
listaCandidatos.push(c4)

let c5 = new Candidato
c5.nome = 'Mark Zuckeberg'
c5.email = 'himark@gmail.com'
c5.idade = '40'
c5.cpf = '000.000.000-00'
c5.estado = 'US'
c5.cep = '74000-000'
c5.descricao = 'Vai roubar a sua vaga'
c5.competencias = ['Kotlin']
listaCandidatos.push(c5)
}
//Função que gera 5 empresas para testes
function geraEmpresa (){ 
  let e1 = new Empresa
  e1.nome = 'Apple'
  e1.email_corporativo = 'jobs@apple.com'
  e1.cnpj='00.000.0001/00'
  e1.estado = 'CA'
  e1.cep = '123123123'
  e1.descricao = 'One more thing...'
  e1.competencias = ['Java','Spring Framework','Angular','Kotlin']
  listaEmpresas.push(e1)

  let e2 = new Empresa
  e2.nome = 'ZG Soluções'
  e2.email_corporativo = 'jobs@zg.com'
  e2.cnpj='00.000.0001/00'
  e2.estado = 'GO'
  e2.cep = '123123123'
  e2.descricao = 'Solucionando'
  e2.competencias = ['Python','Java','Spring Framework','Angular']
  listaEmpresas.push(e2)

  let e3 = new Empresa
  e3.nome = 'Amazon'
  e3.email_corporativo = 'jobs@amazon.com'
  e3.cnpj='00.000.0001/00'
  e3.estado = 'SP'
  e3.cep = '123123123'
  e3.descricao = "Jeff Bezzos' little childs"
  e3.competencias = ['Python','Java','Spring Framework','Angular','Swift','Kotlin']
  listaEmpresas.push(e3)

  let e4 = new Empresa
  e4.nome = 'Roystar Royco'
  e4.email_corporativo = 'jobs@roystar.com'
  e4.cnpj='00.000.0001/00'
  e4.estado = 'USA'
  e4.cep = '123123123'
  e4.descricao = 'Mantendo em família'
  e4.competencias = ['Python','Java','Spring Framework','Angular','Swift','Kotlin']
  listaEmpresas.push(e4)

  let e5 = new Empresa
  e5.nome = 'Nubank'
  e5.email_corporativo = 'jobs@nubank.com'
  e5.cnpj='00.000.0001/00'
  e5.estado = 'SP'
  e5.cep = '123123123'
  e5.descricao = 'Pensando roxo'
  e5.competencias = ['Swift','Kotlin']
  listaEmpresas.push(e5)
}

//--FUNÇÕES--
//Função que valida o nome do candidato.
function validaNome(nome: string): boolean{
  let regexNome: RegExp =  /^[a-z ,.'-]+$/gi //Regex que valida se o nome está inserido corretamente. 
    if(regexNome.test(nome))
    {
      return true//Caso seja válido, o sistema irá retornar true
    }
    else{
      window.alert('Nome incorreto!')//Caso esteja incorreto, o sistema notificará o usuário.
      return false // E retornarar false
    }
}


//---BOTÕES---
//Botão para ir para a área de Cadastro de Candidato
const gotoCadastroCandidato = document.getElementById('button_candidato');
gotoCadastroCandidato?.addEventListener('click', function handleClick(event) {
  console.log('Cadastro candidato selecionado');
  window.location.assign('../pages/cadastro-candidato.html');
});

//Botão para ir para a área de Cadastro de Empresa
const gotoCadastroEmpresa = document.getElementById('button_empresa');
gotoCadastroEmpresa?.addEventListener('click', function handleClick(event) {
  console.log('Cadastro candidato selecionado');
  window.location.assign('../pages/cadastro-empresa.html');
});

//Botão para submeter um novo Candidato
const submitCandidato = document.getElementById('inputCandidato')
submitCandidato?.addEventListener('click', function handleClick(event){
    //Instancia um candidato para setarmos os atributos 
    let candidato = new Candidato;
    //Coletando o nome e adicionando na instância de Candidato
    const inputNomeCandidato = document.getElementById('inputName') as HTMLInputElement;
    const nomeCandidato = inputNomeCandidato.value
    //Testando o input do nome com RegEx
    // let regexNome: RegExp =  /^[a-z ,.'-]+$/gi //Regex que valida se o nome está inserido corretamente. 
    // if(regexNome.test(inputNomeCandidato.value))
    // {
    //   candidato.nome = inputNomeCandidato?.value//Caso seja válido, o sistema irá adicionar o nome do candidato no objeto instanciado.
    // }
    // else{
    //   window.alert('Nome incorreto!')//Caso esteja incorreto, o sistema notificará o usuário.
    // }

    //Coletando o CPF e adicionando na instancia
    const inputCPFCandidato = document.getElementById('inputCPF') as HTMLInputElement;
    //Testando o input do CPF com RegEx
    let regexCPF: RegExp = /\d{3}\d{3}\d{3}\d{2}/gi
    if(regexCPF.test(inputCPFCandidato.value))
    {
      candidato.cpf = inputCPFCandidato?.value//Caso seja válido, o sistema irá adicionar o CPF do candidato no objeto instanciado.
    }
    else{
      window.alert('CPF Incorreto!')//Caso esteja incorreto, o sistema notificará o usuário.
    }

    //Coletando a data de nasc. e adicionando na instancia - Corrigir isso depois
    const inputIdade = document.getElementById('inputIdade') as HTMLInputElement;
    candidato.idade = inputIdade?.value

    //Coletando o CEP e adicionando na instancia
    const inputCEPCandidato = document.getElementById('inputCEP') as HTMLInputElement;
    let regexCEP: RegExp = /^[0-9]{5}-?[0-9]{3}$/gi
    if(regexCEP.test(inputCEPCandidato.value))
    {
      candidato.cep = inputCEPCandidato.value//Caso seja válido, o sistema irá adicionar o CEP do candidato no objeto instanciado.
    }
    else{
      window.alert('CEP Incorreto!')//Caso esteja incorreto, o sistema notificará o usuário.
    }

    //Coletando o Estado e adicionando na instancia
    const inputEstadoCandidato = document.getElementById('inputEstado') as HTMLInputElement;
    candidato.estado = inputEstadoCandidato?.value

    //Coletando o e-mail e adicionado na instancia 
    const inputEmailCandidato = document.getElementById('inputEmail') as HTMLInputElement;
  let regexEmail: RegExp = /\S+@\w+\.\w{2,6}(\.\w{2})?/gi //RegEx te validação do email
   if(regexEmail.test(inputEmailCandidato.value))
   {
    candidato.email = inputEmailCandidato.value //Caso seja válido, o sistema adiciona o email à instância criada
   }   
   else{
    window.alert('Email incorreto!') //Caso negativa, o sistema apresenta uma mensagem de erro.
   }

    //Coletando a descrição e adicionado na instancia 
    const inputDescricaoCandidato = document.getElementById('descricaoCandidato') as HTMLInputElement;
    candidato.descricao = inputDescricaoCandidato?.value
    
    //Coletando as competências 
    var element = <HTMLInputElement> document.getElementById("pythonCheckbox");
    if (element.checked){
      candidato.competencias.push(element.value)
    }
    var element = <HTMLInputElement> document.getElementById("javaCheckbox");
    if (element.checked){
      candidato.competencias.push(element.value)
    }
    var element = <HTMLInputElement> document.getElementById("springCheckbox");
    if (element.checked){
      candidato.competencias.push(element.value)
    }
    var element = <HTMLInputElement> document.getElementById("angularCheckbox");
    if (element.checked){
      candidato.competencias.push(element.value)
    }
    var element = <HTMLInputElement> document.getElementById("swiftCheckbox");
    if (element.checked){
      candidato.competencias.push(element.value)
    }
    var element = <HTMLInputElement> document.getElementById("kotlinCheckbox");
    if (element.checked){
      candidato.competencias.push(element.value)
    }

    //Adiciona o candidato instânciado na lista de candidatos
    if(validaNome(nomeCandidato)){
    console.log('Sucesso')
    candidato.nome = nomeCandidato;
    listaCandidatos.push(candidato);
    }
    //Redireciona o candidato para a próxima página
    console.log(candidato);
    console.log(listaCandidatos);
    console.log('Submeteu o Candidato!'); 
});

//Botão para submeter uma nova Empresa
const submitEmpresa = document.getElementById('botao-cadastrar-empresa')
submitEmpresa?.addEventListener('click', function handleClick(event){
    //Instancia um candidato para setarmos os atributos 
    let empresa = new Empresa;

    //Coletando o nome e adicionando na instância de Candidato
    const inputNomeEmpresa = document.getElementById('nome-empresa') as HTMLInputElement;
    empresa.nome = inputNomeEmpresa?.value

    //Coletando o CPF e adicionando na instancia
    const inputCNPJEmpresa = document.getElementById('cnpj-empresa') as HTMLInputElement;
    empresa.cnpj = inputCNPJEmpresa?.value

    //Coletando o CEP e adicionando na instancia
    const inputCEPEmpresa = document.getElementById('cep-empresa') as HTMLInputElement;
    empresa.cep = inputCEPEmpresa?.value

    //Coletando o Estado e adicionando na instancia
    const inputEstadoEmpresa = document.getElementById('estado-empresa') as HTMLInputElement;
    empresa.estado = inputEstadoEmpresa?.value

    //Coletando o e-mail e adicionado na instancia 
    const inputEmailEmpresa = document.getElementById('email-empresa') as HTMLInputElement;
    empresa.email_corporativo = inputEmailEmpresa?.value

    //Coletando a descrição e adicionado na instancia 
    const inputDescricaoEmpresa = document.getElementById('descricao-empresa') as HTMLInputElement;
    empresa.descricao = inputDescricaoEmpresa?.value
    

    //Adiciona o candidato instânciado na lista de candidatos
    listaEmpresas.push(empresa);
    window.location.assign('../pages/pagina-empresa.html');
    console.log(empresa);
    console.log(listaEmpresas)
    console.log('submeteu'); 
});

//---GERADORES DE HTML--- 
//Gerador de empresas na página de candidatos 
let i = 0
const elementEmpresas = document.createElement('div')
listaEmpresas.forEach(function(value){
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
  i++
});
const empresasCandidato = document.getElementById('mostrar-empresa')
empresasCandidato?.appendChild(elementEmpresas);

//Gerador de candidatos na página de empresas
i = 0
const elementCandidatos = document.createElement('div')
listaCandidatos.forEach(function(value){
  elementCandidatos.innerHTML +=
  elementCandidatos.innerHTML =`
  <br>
  <h2 id="nome-candidato">Nome do candidato: ${listaCandidatos[i].nome}</h2>
  <p id="descricao-candidato">Descrição: ${listaCandidatos[i].descricao}</p>
  <p id="competencias-candidato">Competências: ${listaCandidatos[i].competencias}</p>
  <p id="email">E-mail: ${listaCandidatos[i].email}</p>
  <button id='like'>LIKE</button>
  <button id='dislike'>DISLIKE</button>
  `;
  i++
});
const candidatoEmpresa = document.getElementById('mostrar-candidatos')
candidatoEmpresa?.appendChild(elementCandidatos);