    Тестовое задание QA Automation
###ТК1

#1. Перейти на главную страницу
https://oplatagosuslug.ru/
###Корректно отобразилась главная страница (логотип)
###Отобразилось меню “Выбрать услугу”

#2. Нажать на меню “Выбрать услугу”
###Отобразился список услуг, в том числе пункт “Штрафы ГИБДД”

#3. Нажать на пункт “Штрафы ГИБДД”
###Корректно отобразилась страница поиска штрафов (https://oplatagosuslug.ru/shtrafy_gibdd/)

#4. Открыть вкладку “Поиск по документам”
###Корректно отобразилась форма поиска штрафов (инпуты Свид. о регистрации ТС и Водительское удостоверение)

#5. Ввести номер Свид. о регистрации ТС (7813690343)

#6. Нажать кнопку “Найти штрафы”
###После поиска корректно отобразилась форма оплаты:
###Отобразился текст “Найдено начислений: 1” 2. Показаны 3 способа оплаты (Банковская карта, Со счета телефона, Yandex Pay)
###Документ у штрафа совпадает с ожидаемым (в формате 7*****0343)

#7.Проверка суммы “К оплате”
###Сумма к оплате совпадает с суммой штрафа (правый верхний угол) + сумма комиссии
        - добавление квитанции при оплате штрафа со счёта телефона


###ТК2

#Предусловие: найти неоплаченный штраф (шаги предыдущего сценария)
    
#1. Выбрать способ оплаты “Со счёта телефона”
###Отобразился инпут “Укажите номер, с которого будет списан платёж”
###Отобразились иконки операторов мобильной связи

#2. Нажать чекбокс “получить банковскую квитанцию на e‐mail”

#3. Сумма к оплате совпадает с суммой штрафа (правый верхний угол) + сумма за оплату квитанции
     
работа выполнена в ветке develop. 

