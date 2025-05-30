### B. Ни больше ни меньше

Дан массив целых положительных чисел _a_ длины _n_. 
Разбейте его на **минимально возможное** количество отрезков, чтобы каждое число было не меньше длины отрезка, которому оно принадлежит. 
Длиной отрезка считается количество чисел в нём.

Разбиение массива на отрезки считается корректным, если каждый элемент принадлежит ровно одному отрезку.

**Формат ввода**<br>
Первая строка содержит одно целое число `t (1 ≤ t ≤ 1000)` — количество наборов тестовых данных. 
Затем следуют _t_ наборов тестовых данных.

Первая строка набора тестовых данных содержит одно целое число `n (1 ≤ n ≤ 10^5)` — длину массива.

Следующая строка содержит _n_ целых чисел `a1, a2, …, an (1 ≤ ai ≤ n)` — массив _a_.

Гарантируется, что сумма _n_ по всем наборам тестовых данных не превосходит _2 ⋅ 10^5_.

**Формат вывода**<br>
Для каждого набора тестовых данных в первой строке выведите число _k_ — количество отрезков в вашем разбиении.
Затем в следующей строке выведите _k_ чисел `len1, len2, ..., lenk` — длины отрезков в порядке слева направо.