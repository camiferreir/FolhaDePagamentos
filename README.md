# README — Folha de Pagamento

## 📌 Descrição do Projeto

Este projeto consiste em um aplicativo de **Folha de Pagamento** desenvolvido para calcular o salário líquido de um funcionário de forma automática.

O sistema permite informar os dados do funcionário e realiza os seguintes cálculos:

* Desconto do INSS
* Desconto do IR (Imposto de Renda)
* Salário-Família
* Salário Líquido

Além disso, o aplicativo possui validações de dados, tratamento de exceções utilizando `try-catch` e interface amigável para facilitar a utilização.

---

# 🖥️ Funcionalidades

## ✅ Entrada de Dados

O usuário poderá informar:

* Nome do funcionário
* Salário bruto
* Sexo (Masculino/Feminino)
* Número de filhos

---

# 🧮 Regras de Cálculo

## 📌 INSS

| Faixa Salarial              | Alíquota |
| --------------------------- | -------- |
| Até R$ 1.212,00             | 7,5%     |
| R$ 1.212,01 até R$ 2.427,35 | 9%       |
| R$ 2.427,36 até R$ 3.641,03 | 12%      |
| R$ 3.641,04 até R$ 7.087,22 | 14%      |

---

## 📌 Imposto de Renda (IR)

| Faixa Salarial              | Alíquota |
| --------------------------- | -------- |
| Até R$ 1.903,98             | Isento   |
| R$ 1.903,99 até R$ 2.826,65 | 7,5%     |
| R$ 2.826,66 até R$ 3.751,05 | 15%      |
| R$ 3.751,06 até R$ 4.664,68 | 22,5%    |

---

## 👨‍👩‍👧 Salário-Família

Funcionários com salário bruto de até **R$ 1.212,00** recebem:

* R$ 56,47 por filho

---

# 📌 Fórmula do Salário Líquido

Sal\acute{a}rio\ L\acute{i}quido = Sal\acute{a}rio\ Bruto - (INSS + IR) + Sal\acute{a}rio\ Fam\acute{i}lia

---

# 🧾 Exibição dos Resultados

O sistema apresenta:

* Nome do funcionário com tratamento:

  * **Sr.** para masculino
  * **Sra.** para feminino
* Valor descontado do INSS
* Valor descontado do IR
* Valor do salário líquido

---

# 🎨 Interface do Usuário

A interface contém:

* Campos de entrada
* RadioButtons para seleção do sexo
* Botão **Calcular**
* Campos de resultado:

  * INSS R$
  * IR R$
  * Salário Líquido R$

Sugestões visuais:

* Verde → salário líquido
* Vermelho → descontos
* Ícones para melhorar a usabilidade

---

# ⚠️ Validações Implementadas

O aplicativo valida:

* Nome vazio
* Salário negativo ou inválido
* Número de filhos negativo
* Campos obrigatórios não preenchidos

Mensagens de erro são exibidas ao usuário caso existam dados incorretos.

---

# 🛡️ Tratamento de Exceções

Foi utilizado `try-catch` para evitar falhas durante a execução do programa, principalmente em conversões numéricas.

Exemplo:

```java
try {
    double salario = Double.parseDouble(txtSalario.getText());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Digite um salário válido!");
}
```

---

# 💻 Tecnologias Utilizadas

* Java
* Java Swing / Android Studio (dependendo da implementação)
* Programação Orientada a Objetos
* Estruturas Condicionais
* Tratamento de Exceções

---

# ▶️ Como Executar

1. Abra o projeto na IDE:

   * NetBeans
   * Eclipse
   * Android Studio

2. Execute o arquivo principal do projeto.

3. Informe os dados do funcionário.

4. Clique no botão **Calcular**.

5. Os resultados serão exibidos automaticamente.

---

# 📷 Exemplo de Funcionamento

### Entrada:

* Nome: João
* Salário Bruto: R$ 2.500,00
* Sexo: Masculino
* Filhos: 2

### Resultado:

* INSS: R$ 225,00
* IR: R$ 187,50
* Salário Líquido: R$ 2.087,50

---

# 📚 Conceitos Trabalhados

* Variáveis
* Condicionais (`if/else`)
* Eventos de botão
* Interface gráfica
* Tratamento de exceções
* Validação de dados
* Cálculos matemáticos

---

# 👨‍💻 Autor

Projeto desenvolvido para a atividade **Avaliativo II — Aplicativo de Folha de Pagamento** por Camille Ferreira.
