<h1 align="center"> Code and Go! Viagens </h1> 

<h1 align="center">
      <img alt="logoNova" title="LOGOCODEANDGO" src="https://github.com/nataliarodrxgues/code-and-go-viagens/blob/main/IMG/logo_rodape.png" width="300vw"/>
</h1>

## 💻 Sobre o projeto
Code and Go! Viagens é um projeto que simula uma agencia de viagens desenvolvido durante o Bootcamp **Recode Pro 2023** para formação de desenvolvedores de softwares fullstack oferecido pela [Recode](https://recodepro.org.br).  <br>

-  Ao entrar na pasta do projeto você já encontra o HTML, CSS E BOOTSTRAP do protótipo do Site.<br>
-  Na pasta <strong>"bd-sql"</strong> você encontra os modelos lógico e conceitual em arquivos brM3 e .png<br>
-  Na pasta <strong>"java-crud"</strong> você encontra o modelo UML da aplicação em png e o CRUD do projeto em .java e .class
-  Você encontrará uma api em C# com a tabela Viagem, tendo seu id, destino, preco e URL da imagem referente. Existem 4 ids gerados para auto preenchimento de banco de dados visando a rapidez de teste.
-  Na pasta consume-api, você encontrará um modelo em Nextjs pronto para consumir, mostrando-as na tela um GET em Nextjs.

## 🛠 Tecnologias

### **Frontend** 
-   **HTML**
-   **CSS**
-   **Bootstrap**
-   **JavaScript**

### **Backend** 
-  **Spring Tool**
-  **MySQL**
-  **C#**

### **Banco de dados** 
Abaixo é possível visualizar as modelagens utilizadas para a composição do banco, desenvolvidas no BrModelo 3.31.
<br><br>
Modelo conceitual:
![ModeloConceitual](https://github.com/nataliarodrxgues/code-and-go-viagens/blob/main/bd-sql/ModeloConceitual_CodeAndGo.png)
<br><br>
Modelo lógico:
![ModeloLogico](https://github.com/nataliarodrxgues/code-and-go-viagens/blob/main/bd-sql/ModeloLogico_CodeAndGo.png)

Também é possível visualizar a tabela do código SQL usado na aplicação para JavaSpring e Servelet:
<br><br>
CREATE DATABASE IF NOT EXISTS codeandgoapi;
USE codeandgoapi;

-- Tabela 'clientes'
CREATE TABLE IF NOT EXISTS clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
) ENGINE=InnoDB;      

-- Tabela 'destinos'
CREATE TABLE IF NOT EXISTS destinos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    local VARCHAR(255) NOT NULL,
    dataIda DATE NOT NULL,
    dataVolta DATE NOT NULL,
    clientes_fk INT,
    FOREIGN KEY (clientes_fk) REFERENCES clientes(id)
) ENGINE=InnoDB;

## 👩🏼‍💻 Autora 
Natalia Rodrigues- [@nataliarodrxgues](https://www.github.com/nataliarodrxgues)
<br>
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/nataliarodrxgues)

## Licenças

Este projeto está sob as licenças:
<br>
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)
