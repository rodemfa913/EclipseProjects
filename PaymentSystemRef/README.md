# Sistema de Folha de Pagamento
## Funcionalidades
### Adicionar empregado
Adiciona um empregado no sistema. Devem ser fornecidos o tipo de empregado
(horista, assalariado ou comissionado) o nome, o endereço, o método de pagamento
(cheque por correios, cheque em mãos ou depósito em conta) e o salário; caso
seja um empregado comissionado, informa-se também a comissão. O sistema gera
então um identificador único para o empregado.
### Remover empregado
Remove um empregado do sistema. Deve ser fornecido o identificador de empregado.
### Editar empregado
Edita os atributos de um empregado. Deve ser fornecido o identificador de
empregado.
### Entrar no sindicato
Adiciona um empregado ao sindicato, caso não seja membro. Devem ser fornecidos o
identificador de empregado, um identificador de membro único (não
necessariamente igual ao identificador do empregado) e a taxa sindical.
### Sair do sindicato
Remove um empregado do sindicato. Deve ser fornecido o identificador de membro
do sindicato.
### Lançar cartão de ponto
Adiciona um cartão de ponto associado a um empregado horista. Devem ser
fornecidos o identificador de empregado, a data de lançamento do cartão e as
horas trabalhadas naquela data.
### Lançar resultado de venda
Adiciona um resultado de venda associado a um empregado comissionado. Devem ser
fornecidos o identificador de empregado, a data e o valor da venda.
### Lançar taxa de serviço
Adiciona ou edita a taxa de um serviço oferecido pelo sindicato e associa o
serviço a um membro do sindicato. Devem ser fornecidos o identificador de membro
do sindicato, o serviço a ser associado e a taxa de serviço.
### Rodar folha de pagamento
O sistema busca por todos os empregados que devem ser pagos no dia informado,
calcula o valor a ser pago e, de acordo com o método de pagamento escolhido pelo
empregado, providencia o pagamento.
### Desfazer/refazer
Desfaz ou refaz a ação da última funcionalidade a ser chamada.
## Classes
### payment.PaymentSystem
A classe principal. Fornece a interface para a chamada das funcionalidades, além
de implementar a funcionalidade **desfazer/refazer**.
### payment.action.Action
Classe abstrata que representa uma funcionalidade qualquer. Cada subclasse de
Action representa uma das funcionalidades do sistema. Dependendo da
funcionalidade escolhida, a classe principal realiza a chamada do método
abstrato doAction(), que é implementado pela subclasse associada. Action contém
outros métodos que são de uso comum por mais de uma funcionalidade.
### payment.action.Add
Subclasse de Action que representa a funcionalidade **adicionar empregado**.
### payment.action.Edit
Subclasse de Action que representa a funcionalidade **editar empregado**.
### payment.action.LaunchCard
Subclasse de Action que representa a funcionalidade **lançar cartão de ponto**.
### payment.action.LaunchFee
Subclasse de Action que representa a funcionalidade **lançar taxa de serviço**.
### payment.action.LaunchSale
Subclasse de Action que representa a funcionalidade **lançar resultado de
venda**.
