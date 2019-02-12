#Manual de Instalação do Projeto

Teste simples com chrome usando cucumber com java para a pagina Newsletters.

##Passo a passo da instalação do projeto

###1º Componentes necessários para executar:

* Java (versão 1.8.201 ou 1.8.181)
* Neon
* Eclipse Oxigen
* Selenium (versão 3.11.0)
* Maven 


Após essas execuções deve ser preenchida a variavel de ambiente:

* JAVA_HOME;
* PATH.

###2ª Clonar ou realizar o Download do Projeto no GitLab:

Segue o caminho do Repositorio para a clonagem do projeto:

Caminho:  https://github.com/raizarb27/TestCucumberGlobo.git: junto com o projeto terá a pasta das dependencias.

Obs.: Caso a versão do selenium seja maior do que a versão do projeto, deve ser copiadas conforme o passo a passo:
“Caso não seja localizado a pasta das dependencias no link do projeto (GitLab), deve ser seguido o passo a passo.

####1ª alteração:



O arquivo de nome Jars Selenium deve ser descompactado e seu conteúdo deve ser inserido na pasta Program Files do computador. Após fazer isso, vá até as propriedades do projeto e exclua todos os JAR´s que estão no Java Build Path.

####2ª alteração:

Localize os binários do seu appium (Geralmente na Program Files(86x)), exclua tudo que estiver na pasta e substitua pelo conteúdo do arquivo appium-desktop.zip em anexo.”

Links de Documentação

Cucumber: https://cucumber.io/docs
Surefire: http://maven.apache.org/surefire/maven-surefire-plugin/examples/junit.html




