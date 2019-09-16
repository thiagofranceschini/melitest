# melitest
Encurtador de URLs

## RUN:
### mvn package
### java -jar target/meli-test-0.0.1-SNAPSHOT.jar 

## Descrição:
#### O encurtador de URLs recebe uma url e uma categoria e persiste em cache.
#### Ao receber a requisição para a nova url redireciona para a url original.
#### Caso a url 'curta' não exista ou não possa ser obtida naquele momento, redireciona para a busca com base na categoria.
#### Exibe métricas a respeito dos acessos às urls. 
