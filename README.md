# collections
This is simple java collections library with most used structures. In the future i will add new collections

UPDATE #1
Added generic ArrayList implementation:
  1. Implemented all methods from List interface;
  2. Added new exception class for empty list;
  3. Added needed exceptions headers in interfaces List and Collection;
  4. Created jUnit test for all methods in ArrayList class.
  
  
ArrayList
This structure uses simple array to store generic elements. Start size of structure must be specified.
If array is filled then copy all element to bigger array to allow to add new elements.
Available methods:
  1. add(E) - adding new elements to array. If array is filled creates new bigger array to store new values.
  2. size() - returns number of elements in array.
  3. isEmpty() - returns true if array has no elements.
  4. clear() - deletes all elements in array and sets its size to default.
  5. get(int) - returns element from array at index passed in parameter.
  6. remove(int) - the same as get() but also remove element from array.


