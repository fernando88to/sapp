## Sobre o Projeto

O Sistema de Acompanhamento de Políticas de Preservação de Documentos Digitais (SAPP) é um sistema web tem por objetivo ser uma ferramenta de  avaliação e acompanhamento da implementação das políticas de preservação de documentos digitais nos sistemas informatizados do Poder Judiciário tocantinense atendendo aos requisitos estabelecidos pelo Sistemas Informatizados de Gestão de Processos e Documentos do Poder Judiciário (MoReq-Jus).
O SAPP é resultado do desenvolvimento do trabalho de qualificação do aluno Fernando Henrique no Programa de Pós-Graduação Mestrado Profissional em Modelagem Computaciona de Sistema da Universidade Federal do Tocantins (UFT).
 

### Pré-Requisitos para instalação do sistema
 - [JDK 1.8.0_91 ](https://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase8-2177648.html "JDK 1.8")
 - [git]( https://git-scm.com/ "git")
### Passo a passo a instalação do sistema
```sh
$ git clone https://github.com/fernando88to/sapp.git
$ cd sapp
$ java -Dgrails.env=prod -jar distribuicao/sapp-0.1.jar 
```

## Versão na nuvem

Caso queira testar o sistema sem instalar pode-se utilizar a versão abaixo.

http://ec2-54-184-68-9.us-west-2.compute.amazonaws.com/




## Quadro de desenvolvimento

Para o acompanhamento do processo de programação é utilizado a ferramenta abaixo que permite gerenciar
um quadro das atividades que ainda devem ser desenvolvidas e quais já foram finalizadas. 

https://fernando88to.myjetbrains.com/youtrack/agiles/87-8/88-14


## Compilar o projeto

Para efetuar alguma alteração no código fonte, pode ser fazer uma cópia do código fonte ou caso queira contribuir para o projeto
basta enviar um email para fernando.henrique@mail.uft.edu.br.

Para compilar o projeto é necessário o jdk 1.8, git e o  framework grails (https://grails.org/) instalado.

Para a programação do código fonte recomenda-se a utilização da linha de comando e o editor de texto Visual Code Studio (https://code.visualstudio.com/)


## Layout

Para o desenvolvimento das telas foi utilizado um template open source chamado Modular Admin (https://github.com/modularcode/modular-admin-html
).  

## Banco de Dados

Para o armazenamento dos dados foi utilizado o banco de dados H2 (https://www.h2database.com/html/main.html) o qual é open soure
relacioal, transacional e permite que o banco de dados seja distribuído junto com a aplicação por meio de um arquivo.


