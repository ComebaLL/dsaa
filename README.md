# Начало лаб по саоду и записи с лекции
## доделать
1. добавить шаблоны к типу данных;
2. добавить в класс NodeTree в конструкторе определять left, right;
3. сделать классы шаблоными;
4. сделать тесты к методам класса;

# лекци бинарнные деревья. обход

// ссылка на функцию, принимающую агрумент и возвращающая void
using Func = void(*)(int x)

void print_sqr(int x) {cout << x*x}
print_array2(a,N []// функция принимает список глобальных переменных,(int x), print_sqr) 

using FuncX = void(*)(int& x)

ListNode( T data):
//список инициализации
data(data1), next(nullptr), prev(nullptr) {}

##Бинарное дерево

строгое(полное) бинарное дерево - у каждого узла 2 потомка

законченное дерево - на каждом узле 0, n-1 полный набор узло;
все листья уровня n максимально слева

совершенное дерево - нечего добовлят

подсчет h-кол-во уровне в бинарном дереве типа законченном
2^h<= n < 2^h+1

log2(2^h) <= log2(n) < log2(2^h+1)

## Обход дерева
   1. N обработка текущего узла
   2. L переход к левому потомку
   3. R переход к правому потомку 
  обход :
  прямой - NLR/NRL
  симмитричный - ...


## Бинарное дерево поиска BST
### операции 
   поиск следующего наибольшего(succsessor):not rec
      1. элемент имеет правого потомка:
         1 раз вправо после до упора влево
      2. элемент не имеет потомков - идем вверх, 
         пока родитель не будет правым потомком

   удаление узла:rec*
         1. узел является листом: просто удаляем
         2. один потомок и присоединяем потомка к родителю
         3. 2 потомка:
            а. найти следующий наибольшее
            б. обменяться с этим значениями
            с. удалить свичнутый лист

   поиск not rec
   1. исковое значение меньше идем влево, после доупора вправо

   вставка not rec
   1. find вставляемое значение
   2. искать это значение и если есть дубликат продублировать
   3. если 2ое не выполнилось на последнем листе поиска вставить значение

   max (самый правый лист) rec
   min (самый левый лист) rec


## лекция 15.09
### Куча(heap)
   узлы имеют 0-2 потомка
   законченное(complete) дерево
   если узел А - родитель В, то А>В

   min - корень кучи

   max- смотреть листы
   
   бинарное дерево вырожденное(список)

### Копирование дерева
    
   на вырожденное дерево рекрсия не рекомендуется
  
   complete tree log(2)2
  
   бонусное дз : переводит массив в дерево

   


  

  



 