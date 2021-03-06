# Task1 

## Description

### Предыстория 1

Вы — QA инженер на космическом корабле, который летит покорять новые галактики. Корабль новый и навороченный, но некоторые его части сделаны по принципу "работает — не трогай". Именно так реализован датчик температуры. Шел 2070 год, а к датчику все еще обращаются по HTTP 1.1 через GET-запросы. API принимает на вход параметр "?temperature=", в качестве выходных данных отдает вердикт — в каком состоянии будет вода при такой температуре.
Командир корабля попросил убедиться, что датчик "нормально работает". К сожалению, требований к датчику не сохранилось.

### Задание 1
Пожалуйста, напишите тесты на [API сервиса](http://ntanygin.pythonanywhere.com/) по анализу температуры. Мы хотим увидеть набор тестов, который поможет проверить, что датчик работает корректно, а космический корабль — не взорвется в холодном космическом пространстве. 

## Solution

Данный проект представляет собой базовый набор тестов для API сервиса.


### How to use

Для запуска тестов нужно из корневой директории репозиитория перейти в директорию  проекта. Все последующие команды нужно так же выполнять из  папки проекта.

```
cd task1/
```

#### Configuration

Все настройки тестового проекта хранятся в файле `src/main/resources/properties/client.properties`.

```properties
server.url=http://ntanygin.pythonanywhere.com/

```

#### Test running 

Для запуска тестов следует использовать команду:

```text
mvn clean test
```

#### Allure Report

Для генерации отчета нужно выполнить следующую команду:

```text
mvn clean test
```

Затем можно просмотреть текущий отчет в браузере, страница будет открыта после 
выполнения команды :

```text
mvn allure:serve
```