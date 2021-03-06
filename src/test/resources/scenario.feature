# language: ru
Функция: поиск модели в Яндекс.Маркете
  Сценарий: Поиск телевизоров
    Когда Выполнен переход на страницу Яндекс.Маркет
    Когда Выполнен переход на страницу раздела "Телевизоры"
    Когда Выполнена проверка заголовка страницы
    Когда Выполнен поиск телевизоров стоимостью от 20000 и фирмой производителем: "LG" и "Samsung"
    Тогда проверка, что ожидаемое и фактическое количество найденных моделей равны 455
    Когда Из списка в результатах поиска взят 1 элемент, по нему выполнен поиск и проверка, что в результатах поиска он есть