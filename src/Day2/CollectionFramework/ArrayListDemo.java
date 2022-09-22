package Day2.CollectionFramework;

import java.util.*;

public class ArrayListDemo {
    // constructor has 3 overload, one with 'int capacity' and other one with 'Collection <? extends E> c' parameter.
    private final ArrayList<String> groceryList = new ArrayList<>();

    public void arrayListProperty(){
        // appending object to grocery list at the end of the list
        groceryList.add("Food");
        // inserting object to 3rd index, it will shift the current element in to the right side of the array
        groceryList.add(3,"Egg");
        // Replaces the element at the specified position in this list with the specified element.
        groceryList.set(1,"hello");
        // appending all the elements of the collection to end of list
        groceryList.addAll(Arrays.asList( "hello","hi") );
        // inserting all the element of the collection to specific index
        groceryList.addAll(3,Arrays.asList( "hello","hi") );

        //----------------------------------------------

        //remove all element
        groceryList.clear();
        // returns true if the list contains specific element
        boolean doesContain = groceryList.contains("hi");
        //Returns true if this list contains no elements.
        boolean isEmpty =groceryList.isEmpty();
        //Returns the number of elements in this list.
        int size = groceryList.size();

        // Returns the element at the specified position in this list.
        String groceryElement= groceryList.get(2);
        //Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
        groceryList.indexOf("hello");
        // Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
        int index = groceryList.lastIndexOf("hi");
        // returns from this list all of the elements whose index is between fromIndex and toIndex
        groceryList.subList(1,3);

        //----------------------------------------------
        // foreach method: we can do stuff with it.
        groceryList.forEach(System.out::println);

        // Returns an iterator over the elements in this list in proper sequence. it can only traverse the list in forward direction.
        // and can traverse map,set and list
        Iterator<String> iterator = groceryList.iterator();
        while (iterator.hasNext()){
            // do stuff
            System.out.println(iterator);
        }

        // Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list.
        // => we can use this only for list
        // => can traverse both forward and reverse direction.
        // => we can also specify a starting index in case if we want to start traverse from a specific index
        ListIterator<String> listIterator = groceryList.listIterator();
        // to traverse the list we can use both hasnext() or hasPrevious() here, which we couldn't do in iterator

        //----------------------------------------------


        // Removes the first occurrence of the specified element from this list, if it is present.
        groceryList.remove("hello");
        //Removes the element at the specified position in this list.
        groceryList.remove(1);
        //Removes from this list all of its elements that are contained in the specified collection.
        groceryList.removeAll(Arrays.asList("hello", "hi"));
        //Removes all of the elements of this collection that satisfy the given predicate.
        groceryList.removeIf((element)-> element=="hi");

        // not available in list interface, remove from 3 to 4. Start index is inclusive and end index is exclusive here
        // groceryList.removeRange(3,5);

        //Removes from this list all of the elements whose index is between fromIndex and toIndex
        groceryList.subList(1,3).clear();

        // Returns an array containing all of the elements in this list in proper sequence (from first to last element).
        // the typecasting can be rough though, have to study more about it.
        String[] arr = (String[]) groceryList.toArray();

        //Sorts this list according to the order induced by the specified Collection.Comparator.
        Collections.sort(groceryList);

        // Trims the capacity of this ArrayList instance to be the list's current size. Good way to minimize the storage
        groceryList.trimToSize();

        // Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number
        // of elements specified by the minimum capacity argument.
        groceryList.ensureCapacity(100);

        // in short, groceryList will only contain the union/common elements of two lists
        groceryList.retainAll(groceryList);

        // It's argument is of type UnaryOperator (functional interface with method apply). so we can use lambda expression here (preferable).
        // or can do old school way by implementing the interface, overriding the apply method and then pass an instance of the class as argument.
        groceryList.replaceAll(element-> element.toLowerCase());

    }
}
