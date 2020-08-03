#language: en
Feature: : Страхование

  Scenario: Заявка на полис
    When выбран пункт меню "Страхование"
    When выбран пункт подменю -"Страхование путешественников"
    Then выполнено нажатие нажатие на кнопку - Оформить онлайн
    When выполнено нажатие на кнопку Оформить и переход на 2ю вкладку Оформление
    When заполняются поля формы
      | Фамилия Застрахованного       | Васильев       |
      | Имя Застрахованного           | Станислав      |
      | Дата рождения застрахованного | 18121985       |
      | Фамилия Страхователя          | Васильев       |
      | Имя Страхователя              | Станислав      |
      | Отчество Страхователя         | Вадимович      |
      | Дата рождения Страхователя    | 18121985       |
      | Серия паспорта                | 1234           |
      | Номер паспорта                | 456789         |
      | Дата выдачи паспорта          | 22112006       |
      | Кем выдан                     | УВД КЛМН ЕЖЗКИ |
    When выполнно нажатие на кнопку Продолжить
    Then проверка текста ошибки




