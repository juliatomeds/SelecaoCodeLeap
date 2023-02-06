#language: en
Feature: Gestão de Posts

  Background: Efetuar Login
    Given eu acesso o site
    Then o botao de login deve estar indisponivel
    When eu escrevo meu usuario
    Then o botao de login deve ficar disponivel
    When eu clico no botao Enter
    Then devo logar

@CT2
  Scenario: Permissão para criar Posts
  Given que eu fiz o login e estou na tela de Posts
  Then o botao de criar deve estar indisponivel
  And eu escrevo o titulo do Post
  Then o botao de criar deve estar indisponivel
  When eu escrevo o subtitulo do Post
  Then o botao de criar deve ficar disponivel
  When eu clico no botao criar
  Then a lista deve ser atualizada

@CT3
  Scenario: Permissão para editar Posts
  Given que eu fiz o login e estou na tela de Posts
  And clico em editar o Post
  And edito o Titulo
  And edito o Content
  And clico em Save
  Then a lista deve ser atualizada