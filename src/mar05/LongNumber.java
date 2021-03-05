package mar05;

import datatypes.Node;

import java.util.Arrays;

public class LongNumber {

    public static void main(String[] args) {
        Node<Integer> n1 = Node.createFrom(1, 2, 3, 4);
        Node<Integer> n2 = Node.createFrom(9, 9, 9, 9, 5);
        //System.out.println(Arrays.toString(longNumberToArray(n1)));
        //System.out.println(Arrays.toString(longNumberToArray(n2)));

        System.out.println(sumLongNumber(n1, n2));
    }

    public static Node<Integer> sumLongNumber(Node<Integer> lng1, Node<Integer> lng2) {

        int[] arr1 = longNumberToArray(lng1);
        int[] arr2 = longNumberToArray(lng2);

        int size = Math.max(arr1.length, arr2.length) * 2;
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            int a, b;
            if (i < arr1.length) {
                a = arr1[i];
            } else {
                a = 0;
            }

            if (i < arr2.length) {
                b = arr2[i];
            } else {
                b = 0;
            }

            int sum = a + b + result[i];
            if (sum >= 10) {
                int remainder = sum % 10;
                result[i] = remainder;
                if (i + 1 < size) {
                    result[i + 1] = sum / 10;
                }
            } else {
                result[i] = sum;
            }
        }

        Node<Integer> resultHead = new Node<Integer>(0);

        Node<Integer> current = null;

        boolean foundFirst = false;

        for (int i = size - 1; i >= 0; i--) {
            if (result[i] != 0 || foundFirst) {
                if (current == null) {
                    foundFirst = true;
                    resultHead.setValue(result[i]);
                    current = resultHead;
                } else {
                    current.setNext(new Node<>(result[i]));
                    current = current.getNext();
                }
            }
        }

        return resultHead;
    }

    public static int[] longNumberToArray(Node<Integer> lng1) {
        int size = size(lng1);
        int[] arr = new int[size];

        Node<Integer> current = lng1;

        for (int i = size - 1; i >= 0; i--) {
            arr[i] = current.getValue();
            current = current.getNext();
        }
        return arr;
    }

    public static int size(Node<Integer> head) {
        int size = 0;
        while(head != null) {
            size++;
            head = head.getNext();
        }
        return size;
    }

}
