# SEMrush UI
Пожалуйста, напишите 3 автотеста на интерфейс semrush.com.
* Тест 1: залониться под пользователем в SEMrush
* Тест 2: создайте новую заметку на /users/notes
* Тест 3: создайте новый проект с /dashboard страницы


#Solution

Данный проект содержит простые автотесты для сайта [SEMrush](https:/semrush.com).

### How to use

Для запуска тестов нужно из корневой директории репозиитория перейти в директорию  проекта. Все последующие команды нужно так же выполнять из  папки проекта.

```
cd task3/
```

#### Configuration

Все настройки тестового проекта хранятся в файле `src/main/resources/properties/client.properties`.

```properties
semrush.url=https://www.semrush.com/
semrush.user.login=test_user
semrush.user.password=test_
semrush.action.timeout.sec=15
```

Так же любой из  этих параметров может быть передан как maven property, 
а так же пераметры selenide.

```
mvn -Dbrowser=chrome -Dsemrush.user.login=genius -Dsemrush.user.password=genius_password clean test
```


#### Test running 

Для запуска тестов следует использовать команду:

```text
mvn clean test
```

#### Allure Report

Для генерации отчета нужно выполнить следующую команду:

```text
mvn clean site
```

Затем можно просмотреть текущий отчет в браузере, страница будет открыта после 
выполнения команды :

```text
mvn io.qameta.allure:allure-maven:serve
```