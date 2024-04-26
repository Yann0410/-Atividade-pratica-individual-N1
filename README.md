# -Atividade-pratica-individual-N1

# Sistema Bancário em Java

Este projeto é uma simulação de um sistema bancário implementado em Java 17, utilizando conceitos de threads.

## Entidades

O sistema contém as seguintes entidades:

- **Banco**: Intermedia as transações de forma síncrona e coordenada, garantindo a consistência dos saldos das contas.
- **Loja**: Possui uma conta para receber os pagamentos dos clientes e paga os funcionários assim que possui o valor dos seus salários.
- **Funcionário**: É uma thread que possui duas contas, uma para receber o salário da loja e outra de investimentos. Investe 20% do salário na conta de investimentos logo após seu recebimento.
- **Cliente**: É uma thread que possui uma conta com um saldo inicial de R$ 1.000,00 e realiza compras, de R$ 100,00 ou R$ 200,00, alternando as lojas, até o saldo da conta estar vazio.
- **Conta**: Entidade que representa a conta bancária de um cliente ou loja.

## Funcionamento

O sistema inicia com 1 banco, 2 lojas, 4 funcionários (2 por loja) e 5 clientes. Cada cliente realiza compras alternando as lojas até que o saldo da conta esteja vazio. As lojas pagam os funcionários assim que possuem o valor dos seus salários. Cada funcionário investe 20% do salário na conta de investimentos logo após seu recebimento.

O sistema exibe o valor das transferências e o saldo final de cada conta, garantindo que os saldos estejam consistentes ao fim da execução, independente da ordem em que as transações foram feitas.
