# collections
<html>
  <body>
This is simple java collections library with most used structures. In the future i will add new collections.</br>

<h2>UPDATE #1</h2>
Added generic ArrayList implementation:
<ul>
  <li>Implemented all methods from List interface</li>
  <li>Added new exception class for empty list</li>
  <li>Added needed exceptions headers in interfaces List and Collection</li>
  <li>Created jUnit test for all methods in ArrayList class</li>
</ul>
  
  
<h2>ArrayList</h2></br>
This structure uses simple array to store generic elements. Start size of structure must be specified.
If array is filled then copy all element to bigger array to allow to add new elements.
Available methods:
  <ol>
  <li><i>add(E)</i> - adding new elements to array. If array is filled creates new bigger array to store new values.</li>
  <li><i>size()</i> - returns number of elements in array.</li>
  <li><i>isEmpty()</i> - returns true if array has no elements.</li>
  <li><i>clear()</i> - deletes all elements in array and sets its size to default.</li>
  <li><i>get(int)</i> - returns element from array at index passed in parameter.</li>
  <li><i>remove(int)</i> - the same as get() but also remove element from array.</li>
  </ol>
  </body>
</html>
