Feature: Coleta e seus agendamentos

  Scenario: Salvando varios agendamentos
    Then exclui os agendamentos
    Given Eu quero salvar 1000 agendamentos
    When Quando tiver 1000 agendamentos

  Scenario: Salvando um agendamento e atribuindo
    Then exclui os agendamentos
    Given Eu quero salvar 1 agendamentos
    When Quando tiver 1 agendamentos
    Then Atribua um agendamento sem coletor para "Marcelina"
    When Deve ter 0 agendamento sem coletor

  Scenario: Salvando dois agendamentos e atribuindo os dois
    Then exclui os agendamentos
    Given Eu quero salvar 2 agendamentos
    When Quando tiver 2 agendamentos
    Then Atribua um agendamento sem coletor para "Marcelao_Silvao"
    Then Atribua um agendamento sem coletor para "Joana"
    When Deve ter 0 agendamento sem coletor

  Scenario: Salvando dois agendamentos e atribuindo apenas um
    Then exclui os agendamentos
    Given Eu quero salvar 2 agendamentos
    When Quando tiver 2 agendamentos
    Then Atribua um agendamento sem coletor para "Cristaldo"
    When Deve ter 1 agendamento sem coletor
