# language: ru
Функция: поиск модели в Яндекс.Маркете
  Сценарий: Поиск телевизоров
    Когда Выполнен переход на страницу Яндекс.Маркет
    Когда Выполнена проверка заголовка страницы
    Когда Выполнен переход на страницу раздела "Телевизоры"
    Когда
    Когда проверено, что количество ожидаемых равно 500 и оно равно фактическому
    Когда Из списка ТВ в результатах поиска взят 1 элемент, по нему выполнен поиск и проверка, что в результатах поиска он есть
