# Projeto de uma empresa hipotética com relação aos seus funcionários

Neste Projeto quero simular como seria a gerência de ganhos, quantidade de funcionários, horas trabalhadas e calcular certos fatores a partir disso.  
  
De forma simples, os funcionários serão divididos como gerente, funcionário, terceirizado e estagiário, de forma que todos eles sejam colaboradores da empresa.
Daí serão listado os funcionários, que terão como atributos seus nomes, id da empresa, salário e horas trabalhadas por semana, além de alguns ter certos benefícios.  
  
Algumas das bonificações que alguns tipos de funcionário pode ter é o vale alimentação e o vale transporte, dependendo da sua posição.

Hierarquicamente falando, os funcionários dessa empresa fictícia se organizam da seguinte forma:

--------------------------------------
| Nº | Ordem Hierárquica            |
|----|------------------------------|
| 1  | Gerente                      |
| 2  | Funcionários e Terceirizados |
| 3  | Estagiários                  |
--------------------------------------
  
Pensando nisso, os IDs foram organizados da seguinte forma:  

ID

-------------------------------
| Dígitos                                                                        |
|--------------------------------------------------------------------------------|
| Dígito de ordem hierárquica                                                    |
| Ano e mês de inserção na empresa                                               |
| Ordem de insercão na data especificada                                         |
| Dígito Final que varia quando se tem duas posições hierárquicas de mesmo valor |
-----------------------------------------------------------------------------------  
  
Exemplo:  
Um gerente pode ter um Id de 120200710, onde o dígito inicial *1* é sua posição hierárquica,
os digitos *202007* definem o ano/mês de inserção na empresa,
o segundo dígito *1* logo após indica que ele é o 1º que foi inserido no ano/mês indicado anteriormente e
o dígito *0* indica que o cargo dele é o primeiro da mesma ordem hierárquica.

Se fosse um funcionário, poderia ter um Id 219990510, e sendo terceirizado, teria que ser 219990511, 
sendo o último dígito o que indica qual dos dois colaboradores esse Id representa, levando em conta a igualdade na hierarquia.  
Se não houver outro tipo de colaborador na mesma camada hierárquica, o Id sempre terminará com 0.  

Para cada tipo de colaborador foi designado um tipo de bonificação (Exceto terceirizado), sem nenhum motivo específico além de hierarquia e salário.
Por exemplo, o gerente tem o maior salário e recebe três bonificações, que são o bônus por horas semanais, vale alimentação e vale transporte.  
Já um funcionário têm direito somente aos vale alimentação e vale transporte.  
E um estagiário só recebe o vale transporte.

Para implementar cada uma dessas classes, uma classe abstrata chamada Colaborador foi criada, e dali os atributos que cada colaborador tem em comum saem.  
Herdando essa classe, as classes Funcionario, Estagiario, Gerente e Terceirizado foi criado, implementando certas diferenças entre essas classes de acordo a necessidade.  
  
Para testar o funcionamento das classes e utilizar recursos da API Stream (Meu real propósito), fiz vários objetos na main e os coloquei numa TreeSet, 
que define a ordem e a existência de elementos repetitivos de acordo com o Id, levando em conta que a classe abstrata Colaborador
implementa a interface funcional Comparable<>, e o compareTo() foi implementado usando o Id como parâmetro de comparação.  

Na main, utilizei algumas das funcionalidades da stream API para filtrar, ordenar e iterar sobre os elementos do conjunto de colaboradores.