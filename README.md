`/src/main/java/ru/example/service/UserServiceDbImpl.java` - Реализация сервиса для работы с PosgreSQL

`/src/main/java/ru/example/service/UserServiceMockImpl.java` - Реализация сервиса с заглушкой вместо БД

`/src/main/resources/application.properties` содержит свойство _autoChangeStatusDelaySec_,<br> устанавливающее время <ins>в секундах</ins>, через которое произойдёт автосмена статуса с Online на Away.

С заглушкой "сервер" отвечает через 5-10 секунд. Значение задержки устанавливается  в `/src/main/java/ru/example/service/UserServiceMockImpl.delay()`.

Для того, чтобы запустить сервер с заглушкой БД необходимо пометить класс `/src/main/java/ru/example/Application.java` аннотацией _@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })_ и раскомментировать аннотацию _@Service_ в классе `UserServiceMockImpl.java`, а в классе `UserServiceDbImpl.java` - закомментировать.

И наоборот. Для того, чтобы запустить сервер с БД, необходимо пометить класс `/src/main/java/ru/example/Application.java` аннотацией _@SpringBootApplication_ и раскомментировать аннотацию _@Service_ в классе `UserServiceDbImpl.java`, а в классе `UserServiceMockImpl.java` - закомментировать.

____

Написать серверную часть
Web-приложения согласно следующим
требованиям:

Средства разработки: Java 1.7 (или выше)
Инструменты: Spring Framework
Протокол: HTTP
База данных: PostgreSQL

Примечание: Вместо обращения к
реальной базе можно реализовать
"заглушку" с имитацией обращения и
задержкой по времени 5-10 сек.

Функционал:

* Добавление нового пользователя.
Передаем на сервер данные
пользователя (имя пользователя, email,
phoneNumber и т.д.). Сохраняем информацию в
базе данных. Ответ сервера —
уникальный ID нового пользователя
* Получение информации о
пользователе. Передаем на сервер
уникальный ID пользователя. Читаем
информацию из базы данных. Ответ
сервера — данные пользователя
* Изменение статуса пользователя
(Online, Away, Offline). Передаем на сервер
уникальный ID пользователя и новый
статус. Изменяем статус
пользователя. Ответ сервера —
уникальный ID пользователя, новый и
предыдущий статус
* Перевод в статус Away должен
делаться автоматически через 5 минут
после последнего изменения статуса
на online. Таким образом, если
“подтверждать” статус online
пользователя каждые 5 минут -
автоматического перехода в Away не
должно быть

Обязательные требования:
- RESTful
- Все данные в формате JSON
- Обработка ошибок
