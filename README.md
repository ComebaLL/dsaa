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


### Повторение
   depth: max правое и min левое


### Лекция 22.09 BST. Обходы. Операции. Итераторы
   
   Помскк в ширину:
   поместить корень в очередь
   //todo

   Обход в глубину используя стек
   - поместить в стек корень
   - взять узел из стека
   //todo


   Копирование дерева 
      BinTreeNode<int>* root:
      //построение дерева
      BinTreeNode<int>* root2;
      root2 = root; //поверхностное копирование
      root3 = new BinTreeNode(root-> data,
      root->left, root->right); // глубокое копирование

### Повторениe
   операции над дерево
   find: худший случай O(n); лучший случай log2(n)
   insert: хуйдший случай O(n); лучший случай log2(n)
   remove : O(n); log2(n).

### Лекция 29.09 

   //конструктор копирования
   Array( const Array& ar2){
    this-> n =ar2.n;
    this-> a = new int[ this-> n];
    memcpy( this-> a, ar2.a, this->n * sizeof(int));
   }

   правило пяти
   если нужно написать 1 метод, то нужно и остальные 5:
   констр - копирование;
   констр - перемищение;
   дисктруктор;
   оператор - копирования;
   оператор - перемищения;

   Итераторы
   адресная арифметике *(a+1)

### Лекция 06.10 
##  Итераторы
   пример:
   fibomaciITerator( ULL f1_, f2_):    f1(f1_), f2(f2_){}
    // префиксный оператор
    fibomaciITerator operator++(){
     next();
     return *this;
    }
    // постфиксный оператор
    fibomaciITerator operator++(int){
    fibomaciOTeratot tmp( f1_ f1, f2_ f2);
    next();
    return *this;
    }

   // не равно
    bool operator !=(const fibomanciITerator&) const = default;
# Итераторы класса vector в C++

# Придумать варианты использования функци :
  for_each
  any_of
  //todo

# Инерфейс итератора из SLT
  Итераторы используютя в связи с коллекцией
  Коллекция должна содержать методы begin/end указывающие на начало/конец соответственно

# Задание реализовать итератор для класса LinkedList


# Лекция 20.10.23 Хранение дерева в массиве
 
  - получить индекс левого и правого потомка
  - получить родителя
 
  i левого - i*2+1
  i правого - i*2+2

  родитель - iлв - iпв / 2

## Куча(heap)
 
  сво-во - чем ниже, тем больше значение
  Задание: сделать класс куча и хранить данные в массиве
 
## Сортировка кучей

# Лекция 30.09.23 Куча; Турнирная сортировка

  мат ожидание
  кол-во сравнений для поиска значений х = dx, dx- глубина узла х
  M(dx) = 1/n Sum(dx)
  D= sum(dx) - полная глубина дерева
     Полная глубина всех элементов- D(n) =sum i = 1;n! Di

# Лекция 03.10.23 Самобалансирующиеся деревья AVL-деревья

  Balance factor h hight - h left

  + перенес вправо
  - перенос влево

  Если по модулю разница на каждом узлу в высоте не привышает единицы, то это AVL-tree

 AVL- rotation : левый и правый поворот
 left rotation - если положительный перевес
 right rotation - если отрицательный перевес
 double rotation - когда у одного узла положительный, а у другого отрицательный перевесы

# Лекция 10.11 Граф
 - дз конспект Red-Black tree; b-tree; splay tree. содержание: описание сложности операций, описание важных свойств, описать алгоритмы опирации.
 
 Эксперемент Stanly Milgram 1969
 Мультиграфы
 Social network analysis
 Маьрица смежности и инцедентности
 Направленый граф
 GrafML 
## Обход графа 
   Способ обхода: 
   breadth-first
   depth-first
   Адгоритм Беллмана Форда

# Лекция 17.11 

  Итерация : цикл по кол-во вершин

  Алгоритмы : Флойда-Уоршеллп; Прима; А*
  
  Сетевой Анализ

# Лекция 8.12
  побитовые и логические операции.
  побитовые not ~; or |; and &; xor ^.
## Хеширование
   Хешфункция
   
   Хеш-таблица состоит из:
   -хешфункции
   -массив[n]
   -алгоритм разрешения коллизии
   h(x) = h(y) - колизия

   св-ва хешфункций:
   1) h(x) = h(y) 
      int h( int x{
        return rand()}
      разные значения при одинаковых параметрах
   
   2) h(x) != h(y), если x !=y
   3) функция должна иметь сложность О(1)

### Методы решения коллизии
   Найти другую позицию для ключа, место для ключа занято
   Хранить значения для одного ключа в списке
   Двойное хеширование

# Лекция 15.12 хеш таблицы
  Load factor a= n/m

## Словарь
     

    

  
    
     
    
    
   

   
    

   
    
   
    
   

   


  

  



 