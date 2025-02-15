💰 Wallet - Anotador de Gastos



✨ Sobre o Projeto

O Wallet é uma aplicação simples para anotação de despesas. Com ele, você pode registrar seus gastos e categorizá-los conforme sua necessidade, facilitando o controle financeiro do dia a dia.

📚 Tecnologias Utilizadas

Java ☕️

JDBC para conexão com banco de dados

MySQL

📊 Estrutura do Projeto

O projeto segue uma estrutura simples baseada em classes Java para representar as entidades principais.

🗂 Classes Principais

Category

Integer id_category;
String name_category;

Expense

Integer id_expense;
String name;
Date expenseDate;
Double value_expense;
Integer parcels;
PaymentMethod payment_method;
Category category;

PaymentMethod

id_payment_method;
name_payment_method;

🔧 Como Executar o Projeto

Clone o repositório:

git clone https://github.com/evandrossjr/wallet.git

Configure o banco de dados e ajuste as credenciais no código.

Compile e execute a aplicação Java.

✨ Melhorias Futuras

Implementação de interface gráfica

Conexão com API para conversão de moeda

Relatórios detalhados de gastos

⚙ Contribuição

Fique à vontade para abrir issues e enviar pull requests para melhorias!
