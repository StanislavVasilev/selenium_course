#language: en
Feature: : Страхование

  Scenario: Заявка на полис
    When выбран пункт меню "Страхование"
    When выбран пункт подменю -"Страхование путешественников"
    Then выполнено нажатие нажатие на кнопку - Оформить онлайн
    When выполнено нажатие на кнопку Оформить и переход на 2ю вкладку Оформление
    When заполняются поля формы
      | Имя | Станислав |
    Then выполнно нажатие на кнопку Продолжить



