package jan29;

import datatypes.*;

public class Solution {


    public static void main(String[] args) {
        Node<Integer> list = Node.createFrom(1, 2, 3, 4, 5);
        System.out.println(list);
        Node<Integer> reversed = reverse(list);
        System.out.println(reversed);
    }


    public static<T> Node<T> reverse(Node<T> list) {

        Node<T> head = null;
        Node<T> current = null;

        while(true) {
            Node<T> listLast = null;
            Node<T> previous = null;
            Node<T> temp = list;
            while(temp != null) {
                previous = listLast;
                listLast = temp;
                temp = temp.getNext();
            }

            if (head == null) {
                head = listLast;
                current = head;
            } else {
                current.setNext(listLast);
                current = current.getNext();
            }

            if (previous != null) {
                previous.setNext(null);
            } else {
                break;
            }

        }

        return head;
    }


}
