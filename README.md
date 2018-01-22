# collections
<html>
<body>
This is simple java collections library with most used structures. In the future i will add new collections.</br>

<h2>ArrayList</h2>
This structure uses simple array to store generic elements. Start size of structure must be specified.
If array is filled then copy all element to bigger array to allow to add new elements.
Available methods:
  <ol>
  <li>Three types of constructor: non-parameter with default list size, wih integer parameter to specify default size and copying constructor</li>
  <li><i>add(E)</i> - adding new elements to array. If array is filled creates new bigger array to store new values.</li>
  <li><i>size()</i> - returns number of elements in array.</li>
  <li><i>isEmpty()</i> - returns true if array has no elements.</li>
  <li><i>clear()</i> - deletes all elements in array and sets its size to default.</li>
  <li><i>get(int)</i> - returns element from array at index passed in parameter.</li>
  <li><i>remove(int)</i> - the same as get() but also remove element from array.</li>
  <li><i>contains()</i> - returns true if element passed in parameter is in structure</li>
  <li><i>indexOf()</i> - returns index of element in list or -1 if not exists</li>
  <li><i>replace></i> - changes element at specified index</li>
  <li><i>trimToSize()</i> - changes size of list to fill all elements and avoid unnecesary memory alocation</li>
  <li><i>toArray()</i> - returns array with elements copied from list</li>
  </ol>
  
  Every method was tested using jUnit library
  </body>
 </html>
