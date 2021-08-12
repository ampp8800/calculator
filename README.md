# calculator
Задание 1. Простой консольный калькулятор

1) Создать новый репозиторий для калькулятора, основную ветку назвать master, в нее в качестве начального коммита запушить файл readme.md с этим заданием.

2) От ветки master отвести ветку task_1, в которой проводить всю дальнейшую работу 
	2.1) перед началом выполнения следующего пункта необходимо примерно оценить (в часах) время, за которое будет выполнено данное задание и прислать цифру мне. Это информативная вещь и на что не влияет, но сделать оценку надо обязательно.

3) Написать простой консольный калькулятор: 
	- Калькулятор должен поддерживать 2 числа (операнда), которые могут быть целыми либо дробными и 4 операции между ними (+, -, *, /). Вывод округлить до 4 знаков после запятой. Если дробная часть 0 - не выводить её.
	- На вход калькулятор принимает 1 строку-выражение в формате "A op B" (op = один любой оператор). Некорректный формат входной строки должен обрабатываться с выдачей в консоль предупреждения и просьбы ввести выражение заново.
	- После ввода входной строки в консоль вывести результат и следующей строкой предложение продолжить - на входе считать y/n и либо запустить считывание строки заново (y) либо завершить программу (n).

4) По окончании задания ветку task1 необходимо запушить на гитхаб, после чего через веб-интерфейс гитхаба создать там пулл-реквест в ветку master, меня поставить в качестве ревьюера.

Требования по оформлению:
 	1) На сервере github не должно быть скомпилированных *.class файлов, только исходники *.java (настроить файл .gitignore в локальном репозитории).
	2) Весь текст, выводимый программой в консоль должен быть на английском.
	3) У коммитов git есть описание - оно должно содержать краткую суть коммита на английском языке.
