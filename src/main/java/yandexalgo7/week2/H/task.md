### H. Дерево отрезков с операцией на отрезке

Реализуйте эффективную структуру данных для хранения элементов и увеличения нескольких подряд идущих элементов на одно и то же число.

**Формат ввода**<br>
В первой строке вводится одно натуральное число `N (1 ⩽ N ⩽ 100000)` — количество чисел в массиве.

Во второй строке вводятся N чисел от 0 до 100000 — элементы массива.

В третьей строке вводится одно натуральное число `M (1 ⩽ M ⩽ 30000)` — количество запросов.

Каждая из следующих M строк представляет собой описание запроса. 
Сначала вводится одна буква, кодирующая вид запроса (_g_ — получить текущее значение элемента по его номеру, _а_ — увеличить все элементы на отрезке).

Следом за _g_ вводится одно число — номер элемента.
Следом за _a_ вводится три числа — левый и правый концы отрезка и число add, 
на которое нужно увеличить все элементы данного отрезка массива `(0 ⩽ add ⩽ 100000)`.

**Формат вывода**<br>
Выведите в одну строку через пробел ответы на каждый запрос _g_.