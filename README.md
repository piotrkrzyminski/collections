# collections
<html>
<body>
This is simple java collections library with most used structures. In the future i will add new collections.</br>

<h1>Lists</h1>
<h2>ArrayList</h2>
This structure uses simple array to store generic elements. You can create list with specified size of use default. When array will be filled add another element causes increasing array size by 2. This operation takes quite time because it copying all elements from smaller array to bigger. Howewer access to each node is very fast.</br>

Available methods:
  <ol>
  <li>Three types of constructor: non-parameter with default list size, with integer parameter to specify default size and copying constructor</li>
  <li><i>void add(E)</i> - adding new elements to array. If array is filled creates new bigger array to store new values.</li>
  <li><i>int size()</i> - returns number of elements in array.</li>
  <li><i>boolean isEmpty()</i> - returns true if array has no elements.</li>
  <li><i>void clear()</i> - deletes all elements in array and sets its size to default.</li>
  <li><i>E get(int)</i> - returns element from array at index passed in parameter.</li>
  <li><i>E remove(int)</i> - the same as get() but also remove element from array.</li>
  <li><i>boolean contains(E)</i> - returns true if element passed in parameter is in structure</li>
  <li><i>int indexOf(E)</i> - returns index of element in list or -1 if not exists</li>
  <li><i>void replace(E, int)</i> - changes element at specified index</li>
  <li><i>void trimToSize()</i> - changes size of list to fill all elements and avoid unnecesary memory alocation</li>
  <li><i>Object[] toArray()</i> - returns array with elements copied from list</li>
  <li><i>Iterator[] iterator()</i> - returns Iterator object that allows to move safely on ArrayList elements</li>
  </ol>
  
<h3>ArrayList Iterator</h3>
There are two ways to move across ArrayList elements. Using indexes or iterator object. That object has only two methods:
  <ol>
  <li><i>boolean hasNext()</i> - returns true if array has next element after current element</li>
  <li><i>E next()</i> - returns element reference after currently used</li>
  </ol>
  
<h2>Linked list</h2>
Doubly linked list stores elements in nodes. Besides elements, each node contains also information about next and previous node. This sort of collection don't have size limit. But access to each node may take more time than in ArrayList implementation.</br> 
Available methods:
  <ol>
  <li><i>void add(E)</i> - create new node with element and put it at the end of list</li>
  <li><i>int size()</i> - returns number of nodes.</li>
  <li><i>boolean isEmpty()</i> - returns true if first node is null.</li>
  <li><i>void clear()</i> - change first node to null.</li>
  <li><i>E get(int)</i> - returns element from list at index passed in parameter.</li>
  <li><i>E remove(int)</i> - the same as get() but also remove node from list.</li>
  <li><i>boolean contains(E)</i> - returns true if element passed in parameter is in structure</li>
  <li><i>int indexOf(E)</i> - returns index of element in list or -1 if not exists</li>
  <li><i>void replace(E, int)</i> - changes element at specified index</li>
  <li><i>void toArray()</i> - returns array with elements copied from list</li>
  <li><i>Iterator[] iterator()</i> - returns Iterator object that allows to move safely on LinkedList elements</li>
  </ol>
  
  <h3>Singly linked list Iterator</h3>
Iterator allows to move safely across nodes. It has only two methods:
  <ol>
  <li><i>boolean hasNext()</i> - returns true if array has next element after current element</li>
  <li><i>E next()</i> - returns element reference after currently used</li>
  </ol>
  
<h2>Queue ArrayList and LinkedList implementation</h2>
Queue uses almost every method from standard list class. But except taking element from end of the list it takes it from beginning.</br>
  
  Available methods:
  <li><i>void add(E)</i> - adding new elements at the end of structure</li>
  <li><i>int size()</i> - returns number of elements in structure.</li>
  <li><i>boolean isEmpty()</i> - returns true if structure has no elements.</li>
  <li><i>void clear()</i> - deletes all elements in structure.</li>
  <li><i>E get()</i> - returns element from structure at 0 index</li>
  <li><i>E remove()</i> - the same as get() but also remove element from structure.</li>
  
<h2>Stack ArrayList and LinkedList implementation</h2>
Stack add element to the end of structure but in contrast to queue, it takes elements from end.</br>

 Available methods:
  <li><i>boolean push(E)</i> - adding new elements at the end of structure</li>
  <li><i>int size()</i> - returns number of elements in structure.</li>
  <li><i>boolean isEmpty()</i> - returns true if structure has no elements.</li>
  <li><i>void clear()</i> - deletes all elements in structure.</li>
  <li><i>E peek()</i> - returns element from structure at 0 index</li>
  <li><i>E pop()</i> - the same as peek() but also remove element from structure.</li>
  
<h1>Trees</h1>
<h2>Binary tree</h2>
<p>Binary tree is a tree data structure in which each node has at most two children, which are referred to as the left child and the right child<p>
  Available methods:
  <ol>
    <li><i>void insert(E)</i></li>
    <li><i>E getRoot()<i></li>
      <li><i>int countNodes()</i></li>
      <li><i>void printAscending()</i></li>
      <li><i>void printDescending()</i></li>
      <li><i>boolean contains(E)</i></li>
      <li><i>boolean isEmpty()</i></li>
      <li><i>E maximum()</i></li>
      <li><i>E minimun()</i></li>
      <li><i>void clear()</i></li>
  </ol>
  <h3>Tree Iterator</h3>
  Iterator allows to move safely across nodes. It has only two methods:
  <ol>
  <li><i>hasNext()</i> - returns true if array has next element after current element</li>
  <li><i>next()</i> - returns element reference after currently used</li>
  </ol>
  
  Every method was tested using jUnit library
  </body>
 </html>
