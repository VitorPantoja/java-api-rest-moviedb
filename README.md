# MovieDB POO

:gear: Tecnologias

- Spring Boot
- SWAGGER
- Maven

### :file_folder: Requisitos
- SDK JAVA 11
- Postgresql
- Git

### :hammer: Executando o Projeto


### Selecione uma pasta e clone o projeto

###### https://github.com/VitorPantoja/api-rest-discipline-poo.git

### Ou baixe o projeto zipado no github

### Abra a pasta clonada
###### api-rest-discipline-poo-develop

### Executando projeto
###### Recomendo utilizar a ide intellij para rodar o projeto ou qualquer outra de sua preferência. Instalar o postgresql e após isso substituir os valores das variáveis de ambiente do projeto, dentro do arquivo application.yml
<img src="https://user-images.githubusercontent.com/47435988/218766862-f55b0818-a46c-4a43-9b64-e5d3600b58b0.png" /> <br>
```bash
MOVIE_DB_PASSWORD=senha de seu postgres;
```
```bash
MOVIE_DB_USERNAME=seu user postgres;
```
```bash
MOVIE_DB_NAME=seu banco para o projeto;
```

### Ou você pode criar uma configuração de execução de projeto dentro do intellij:


1° Selecione o MovieApplication: <br>
<img src="https://user-images.githubusercontent.com/47435988/218755462-39619435-a61e-41c9-8518-ef2cbe261a3c.png" /><br>

2° Após o primeiro passo irá aparecer algumas opções, selecione edit configurations:<br>
<img src="https://user-images.githubusercontent.com/47435988/218757939-d5a4cc0b-7817-41ec-8a85-450ed7536c16.png" /><br>

3° Clique no + e após isso selecione a opção Application:<br>
<img src="https://user-images.githubusercontent.com/47435988/218758384-f3da0106-9c4c-4908-b155-3da430ded58d.png" /><br>

4° Após selecionada irá ser aberta uma aba, dentro do grupo Build and run selecione no input que está com as bordas em vermelho e selecione a classe de execução
de seu projeto:<br>
- Verifique se seu SDK do java está correto, caso não, você pode selecionar a primeira opção que fica a esqueda do input que está em vermelho. Feito isso selecione 
o SDK correto.
<img src="https://user-images.githubusercontent.com/47435988/218759351-fadb0b25-429e-475d-871e-f2365995272d.png" /> <br>

5° Selecione o input Environment variables:
```bash
 MOVIE_DB_PASSWORD=senha de seu postgres;MOVIE_DB_USERNAME=user de seu postgres;MOVIE_DB_NAME=nome de seu banco postgres<br>
 ```
<img src="https://user-images.githubusercontent.com/47435988/218762964-03bfaf9d-917a-49fc-bd6f-74cd441abed4.png" /> <br>

6° Feito isso é só executar o projeto no botão de play<br>

<img src="https://user-images.githubusercontent.com/47435988/218765908-42b3e636-2813-4b11-ba66-4052eb5802d0.png" /> <br>

### :bellhop_bell: Ainda falta
- Refatorar as interfaces de services
  <p>→ Criar interface de service para que todas as services implementem os recursos comuns entre elas.</p>
