Este é um projeto em Java 11 que utiliza Rest Assured para testes de API e JUnit 5 como framework de testes. Este README contém instruções detalhadas para configurar o ambiente e executar os testes, com foco na IDE IntelliJ IDEA e Gradle como sistema de build. 
O objetivo desse projeto é participar de um desafio do CBLAB, usando automação para testar a API.

Pré-requisitos
Antes de começar, os seguintes itens deram que está instalados em sua máquina:

Java 11 JDK (versão mínima recomendada)
Gradle: Ferramenta de build (pode ser instalada automaticamente pelo IntelliJ ou manualmente).
Git (para clonar o repositório)
IntelliJ IDEA (IDE recomendado, usada nesse projeto)

Configuração do Ambiente
Siga os passos abaixo para configurar o ambiente localmente:

1. Instale o Java 11 JDK
Baixe o JDK 11 em: Oracle JDK ou OpenJDK.
Siga as instruções de instalação para o seu sistema operacional (Windows, Linux ou macOS).
instalação: no CDM você pode usar o comando "java -version" e ver qual a versão e se deu tudo certo.

2. Configure uma variável de ambiente JAVA_HOME
Defina a variável de ambiente JAVA_HOME apontando para o diretório de instalação do JDK.
Caminho:  Pesquise por "variáveis de ambiente" com a jalena aberta da configuração, clique em > "Variáveis ​​de Ambiente".

![image](https://github.com/user-attachments/assets/b4613e7b-bbbe-4c18-adac-305bd2e05e83)

Adicione uma nova variável de sistema:
Nome: JAVA_HOME
Valor: C:\caminhoPara\Java\jdk-11 (ajuste o caminho conforme sua instalação).

![image](https://github.com/user-attachments/assets/8b7bcc55-f94d-4750-ae45-9acad5c82900)

Na variável Path, adiciona no botão novo o valor %JAVA_HOME%\bin.

![image](https://github.com/user-attachments/assets/22d7b3e5-8566-4ceb-a453-4665f893a079)

Abrindo sua IDE (vou usar a intellij com exemplo)

3. Abra o Projeto no IntelliJ IDEA
Abra o IntelliJ IDEA.
Para clonar o projeto, basta ir em:

![image](https://github.com/user-attachments/assets/d31b23f3-eec6-47ee-baa4-42bf325ba3bd)

Colocar a url do projeto e clicar em clonar:

![image](https://github.com/user-attachments/assets/fbb1380e-186c-4cc4-b234-f822cefb7504)

4. Configure o JDK no IntelliJ
Vá para File > Project Structure.
Em Project, selecione o JDK instalado (ex.: 11).

![image](https://github.com/user-attachments/assets/14542a2c-5b4a-4a7a-be3d-99db93636a41)

Em Modules, confirme que o mesmo JDK está selecionado.
Clique em Apply e OK.

![image](https://github.com/user-attachments/assets/8c76ec60-12f8-4dd0-bcf5-b8633111c1d4)

5. Sincronize as Dependências
No IntelliJ, clique no ícone de "Refresh" no painel Gradle (geralmente à direita) ou execute no terminal:  "./gradlew build"

![image](https://github.com/user-attachments/assets/f127e40d-a2d0-4522-8476-ac7bec524ac4)

configurações ao build.gradle já estão todas, mas caso precise pode buscar em https://mvnrepository.com/artifact/io.rest-assured/rest-assured.

Executando os Testes
1. Testes no IntelliJ IDEA
Abra um arquivo do projeto em src/test/java (desafioCBTestAPI.java).
Clique com o botão direito no arquivo ou em um método de teste e selecione Run 'nomeTests'.
Os resultados aparecem na aba Run do IntelliJ.

![image](https://github.com/user-attachments/assets/c2026334-adc1-406c-81ec-5776f251e131)

2. Testes via Terminal
Para rodar todos os testes: "./gradlew test"
