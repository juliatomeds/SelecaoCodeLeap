#language: en
 Feature: Realizar o login

  @CT1
  Scenario: Realizar o login verificando o funcionamento do botão "Enter"
      Given eu acesso o site
      Then o botao de login deve estar indisponivel
      When eu escrevo meu usuario
      Then o botao de login deve ficar disponivel
      When eu clico no botao Enter
      Then devo logar
