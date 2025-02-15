# 💰 Wallet - Anotador de Gastos

## ✨ Sobre o Projeto

O **Wallet** é uma aplicação simples para anotação de despesas. Com ele, você pode registrar seus gastos e categorizá-los conforme sua necessidade, facilitando o controle financeiro do dia a dia.

## 📚 Tecnologias Utilizadas

- **Java** ☕️  
- **JDBC** para conexão com banco de dados  
- **MySQL**  

## 📊 Estrutura do Projeto

O projeto segue uma estrutura simples baseada em classes Java para representar as entidades principais.

## 🗂 Classes Principais

### **Category**
```java
private Integer id_category;
private String name_category;
```

### **Expense**
```java
private Integer id_expense;
private String name;
private Date expenseDate;
private Double value_expense;
private Integer parcels;
private PaymentMethod payment_method;
private Category category;
```

### **PaymentMethod**
```java
private Integer id_payment_method;
private String name_payment_method;
```

## 🔧 Como Executar o Projeto

1. Clone o repositório:
   ```sh
   git clone https://github.com/evandrossjr/wallet.git
   ```
2. Configure o banco de dados e ajuste as credenciais no código.
3. Compile e execute a aplicação Java.

## ✨ Melhorias Futuras

- Implementação de interface gráfica  
- Conexão com API para conversão de moeda  
- Relatórios detalhados de gastos  

## ⚙ Contribuição

Fique à vontade para abrir issues e enviar pull requests para melhorias!

