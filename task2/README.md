### Предыстория 2
Вы с коллегами проектируете главный графический интерфейс развлекательного экрана корабля, который показывает информацию на дисплеях. В процессе возникла сложность — разные части корабля заточены под разные технологии. Унифицировать их слишком тяжело и дорого, поэтому решено было просто поддержать разные версии всего.
Развлекательный экран должен работать с:
* английским и клингонским языками;
* соединяться и корректно работать с Postgres и MongoDB базами (да, прошло 50 лет, а ничего лучше так и не придумали);
* дисплеями моделей Nova и SuperNova.

### Задание 2
Составьте таблицу проверок, которая поможет удостовериться, что все будет работать как надо. Помните, что чем меньше проверок — тем лучше. 

### Soultion

Здесь логично применить принцип All-pairs testing.


Вместо перебора всех возможных конфигураций системы - мы возьмем лишь тот минимальный набор комбинаций, которые содержит
все возможные  пары двух различных параметров. Обосновано это тем, что чаще всего причиной ошибки является 
взаимодействие лишь двух факторв.


| Монитор | Язык | База данных |
| --- | --- | --- |
| Nova | Английский | Mongo | 
| Nova | Клингонский | MySQL |
| SuperNova | Английский | MySQL
| SuperNova | Клингонский | Mongo |


Как видно, данный набор комбинаций содержит все возможные парные комбинации парамаетров:

Монитор - Язык 
Монитор - База Данных
Язык - База Данных 