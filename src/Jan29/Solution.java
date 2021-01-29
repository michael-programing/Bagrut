package Jan29;

import datatypes.*;

public class Solution {


    public static void main(String[] args) {]

    }


    public static<T> Node<T> reverse(Node<T> list) {

        Node<T> head = null;

        Node<T> currentFirst = list;

        while(true) {
            Node<T> listLast = null;
            Node<T> temp = list;
            while(temp != null) {
                listLast = temp;
                temp = temp.getNext();
            }

            if (head == null) {
                head = listLast;
            } else {
                head.setNext(listLast);
            }

        }


    }


}
