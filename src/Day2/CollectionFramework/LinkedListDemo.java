package Day2.CollectionFramework;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {
    public static void main(String[] args) {
        // constructor has one more overload, we can pass a collection to the constructor as well to add the list
        LinkedList<String> places = new LinkedList<>();

        // ----------------------------------------------
        // difference between add and offer is their return type, offer returns false when it
        // fails and add will throw IllegalStateException. Add is from the list interface, while offer is from Deque interface

        // Appends the specified element to the end of this list.
        places.add("dhaka");
        // Adds the specified element as the tail (last element) of this list.
        places.offer("dhaka");
        // Inserts the specified element at the specified position in this list. shifts the current element to the right if there is any.
        places.add(0,"khulna");
        // Replaces the element at the specified position in this list with the specified element.
        places.set(1,"dhaka");

        // Inserts the specified element at the beginning of this list.
        places.addFirst("Chittagong");
        //Inserts the specified element at the front of this list.
        places.offerFirst("Chittagong");

        // Appends the specified element to the end of this list.
        places.addLast("Monipur");
        // Inserts the specified element at the end of this list.
        places.offerLast("Monipur");

        // Appends all of the elements in the specified collection to the end of this list,
        // in the order that they are returned by the specified collection's iterator.
        places.addAll(Arrays.asList("Bogura", "Narail"));
        // Inserts all of the elements in the specified collection into this list, starting at the specified position.
        places.addAll(1,Arrays.asList("Dhanmondi","Mirpur"));
        // ----------------------------------------------

        // Removes all of the elements from this list.
        places.clear();
        // Returns a shallow copy of this LinkedList.
        places.clone();
        // ----------------------------------------------


        // Returns an iterator over the elements in this deque in reverse sequential order in forward direction only. In other words from tail towards head
        Iterator<String> iterator = places.descendingIterator();
        while (iterator.hasNext()){
            // do stuff
        }

        // Returns a list-iterator of the elements in this list (in proper sequence), starting at the specified position in the list.
        ListIterator<String> listIterator= places.listIterator(2);
        // => we can use this only for list
        // => can traverse both forward and reverse direction.
        // => we can also specify a starting index in case if we want to start traverse from a specific index
        // to traverse the list in both direction we can use both hasnext() or hasPrevious() here

        // ----------------------------------------------


        // Retrieves, but does not remove, the head (first element) of this list.
        String element = places.element();
        // Returns the element at the specified position in this list.
        String elementAtIndex= places.get(1);
        //Returns the first element in this list.
        places.getFirst();
        // Returns the last element in this list.
        places.getLast();
        // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
        int firstIndexof = places.indexOf("dhaka");
        // Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
        int lastIndexOf = places.lastIndexOf("dhaka");
        //Returns true if this list contains the specified element.
        boolean isExists= places.contains("dhaka");
        // Returns the number of elements in this list.
        int numberOfElements= places.size();

        // ----------------------------------------------
        // Retrieves, but does not remove, the head (first element) of this list.
        places.peek();
        // Retrieves and removes the head (first element) of this list.
        places.poll();
        // Removes and returns the first element from this list.
        places.removeFirst();

        // Retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
        places.peekFirst();
        // Retrieves and removes the first element of this list, or returns null if this list is empty.
        places.pollFirst();
        // Retrieves and removes the head (first element) of this list.
        places.remove();

        //Removes the element at the specified position in this list.
        places.remove(1);
        //Removes the first occurrence of the specified element from this list, if it is present.
        places.remove("dhaka");
        // Removes the first occurrence of the specified element in this list (when traversing the list from head to tail).
        places.removeFirstOccurrence("dhaka");
        // Removes the last occurrence of the specified element in this list (when traversing the list from head to tail).
        places.removeLastOccurrence("dhaka");

        // Retrieves, but does not remove, the last element of this list, or returns null if this list is empty.
        places.peekLast();
        // Retrieves and removes the last element of this list, or returns null if this list is empty.
        places.pollLast();
        // Removes and returns the last element from this list.
        places.removeLast();
        // ----------------------------------------------

        //Pops an element from the stack represented by this list.
        places.pop();
        // Pushes an element onto the stack represented by this list.
        places.push("Pushed Element");


        //---------------------------------------------------
        // Returns an array containing all of the elements in this list in proper sequence (from first to last element).
        String[] arr= ( String[] ) places.toArray();


    }
}
