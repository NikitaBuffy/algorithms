### B. Миссия джедая Ивана

Юный джедай Иван был заброшен на Звезду Смерти с заданием уничтожить её. 
Для того, чтобы уничтожить Звезду Смерти, ему требуется массив неотрицательных целых чисел _ai_ длины _N_.
К сожалению, у Ивана нет этого массива, но есть секретный документ с требованиями к этому массиву, который ему передал его старый друг Дарт Вейдер.

В этом документе содержится квадратная матрица m размера N, где элемент в _i-й_ строке в _j-м_ столбце равен побитовому `"И"` чисел _ai_ и _aj_. 
Для повышения безопасности главная диагональ матрицы была уничтожена и вместо чисел на ней были записаны нули. 
Помогите Ивану восстановить массив _a_ и выполнить свою миссию.

Гарантируется, что решение всегда существует. Если решений несколько, выведите любое.

**Формат ввода**<br>
В первой строке содержится число `N (1 ≤ N ≤ 1000)` — размер матрицы.

Каждая из последующих _N_ строк содержит по _N_ целых чисел _mij_ `(0 ≤ mij ≤ 9)` — элементы матрицы.

**Формат вывода**<br>
В единственной строке выведите _N_ целых неотрицательных чисел, не превышающих 100 — требуемый массив _a_.

