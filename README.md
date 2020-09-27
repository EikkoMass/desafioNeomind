Projeto Neomind 1: Processo de Seleção Desenvolvedor Full-Stack (Back-End e Front-End)

Desafio 1: Programação Back-end
    Objetivo: 
    O objetivo deste desafio é demonstrar sua experiência e conhecimento em programação back-end. Assim saberemos como você pensa e resolve estas necessidades.
    Necessitamos que seja criado um webservice em REST para devolver os dados de nossos fornecedores, e ainda executar operações de Criação, Deleção e Atualização dos dados.
    Premissas:
    
   1. Restrições:
    
            >  Necessário ser um projeto feito com JavaEE;
            >  Utilizar Maven ou Gradle para compilação do projeto;
            >  Evitar o uso de API de terceiros;
      
   2. Objeto exemplo:
       
            {"id": 1, "name": "fornec lorimospm", "email": "fornec@loripsom", "comment": "loreipsum", "cnpj": "00.000/0000-00"}

   3. Caso tenhas alguma dúvida, tome a decisão que julgar ser a melhor e encaminhe junto com a solução do desafio dizendo qual era sua dúvida, qual foi a decisão tomada e        defenda a posição tomada. 

Desafio 2:  Programação de Interfaces
    
    
  Objetivo: 
     O objetivo desse desafio é demonstrar sua experiência e conhecimento em programação de interfaces.
     Necessitamos que seja criada uma interface para apresentar os dados dos nossos fornecedores, requisitando os mesmos a partir dos RESTs criados no problema anterior. Deve também ser possível realizar operações de criação, edição e exclusão de fornecedores.
     
   Premissas:
     
 1. Restrições:
      >     A interface deverá ser feita com Bootstrap. A API para MVW a ser utilizada é o AngularJS.
      
 2. O consumo dos dados deverá ser feito através do AngularJS ou qualquer API feita em AngularJS.
    
 3. Caso tenhas alguma dúvida, tome a decisão que julgar ser a melhor e encaminhe junto com a solução do desafio dizendo qual era sua dúvida, qual foi a decisão tomada e defenda a posição tomada.
---------------------------------------------------------------------------------------------------------------------

Nota: 

- Utilizado Maven para compilação de projeto,
- Utilizado JDBC para conexão com Banco de Dados,
- Utilizado Jersey Rest Api para Back-End,
- Utilizado AngularJs e Bootstrap para Front-End,
- Servidor para o projeto foi utilizado o Apache Tomcat v9.0.28,
- Rota do Banco de dados (JDBC) definida na porta 3306,
- Rota do Projeto definida na porta 8080 (localhost:8080/projetoNeomind/),
- Banco de Dados desenvolvido e utilizado em MySql [Arquivo '.sql' e '.mwb' em: projetoNeomind\src\main\webapp\bd].

- [Arquivo 'index.html' em: projetoNeomind\src\main\webapp]

---------------------------------------------------------------------------------------------------------------------





Projeto Neomind 2: Ponteiros do Relógio

Desafio de Lógica e Programação
Objetivo: O objetivo desse desafio é demonstrar sua habilidade e conhecimento em lógica de programação. Assim saberemos como você pensa e como resolve problemas cotidianos.
O Problema: Escreva um programa onde, dado um determinado horário, ele seja capaz de calcular o ângulo entre os 2 ponteiros do relógio.
Premissas:
1. Considere:
  
        > 00:00h possui um ângulo de 0
        > 00:15h possui um ângulo de 45
        > 00:30h possui um ângulo de 180
  
2. Construtor do método:
  
        public long retornaAnguloRelogio(GregorianCalendar horario);
  
3. O desafio deve ser entregue escrito em Java ou linguagem natural.

4. Não deverá ser utilizada qualquer biblioteca de terceiros para execução do projeto.

5. Caso tenhas alguma dúvida, tome a decisão que julgar ser a melhor e encaminhe junto com a solução do desafio dizendo qual era sua dúvida, qual foi a decisão tomada e defenda a posição tomada.


---------------------------------------------------------------------------------------------------------------------

Nota: Apenas fiquei em dúvida em relação ao ponto de 00:15h sendo aplicado como 45º, mas enviei o projeto com o que considero logicamente correto! 

---------------------------------------------------------------------------------------------------------------------
