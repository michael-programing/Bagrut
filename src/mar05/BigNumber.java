package mar05;

import datatypes.Node;

public class BigNumber {

    public static void main(String[] args) {
        Node<Integer>[] arList = listsFromNum(273375);
        System.out.println(numFromLists(arList));
    }

    public static int numFromLists(Node<Integer>[] arList) {
        int maxPower = maxOfLists(arList) - 1;

        int result = 0;

        for (int i = 0; i < arList.length; i++) {
            Node<Integer> current = arList[i];
            while(current != null) {
                int power = maxPower - (current.getValue() - 1);
                result += Math.round(Math.pow(10, power) * i);
                current = current.getNext();
            }
        }

        return result;
    }

    public static Node<Integer>[] listsFromNum(int num) {
        Node<Integer>[] arr = new Node[10];
        int power = 0;
        do {
            int biggestPower = biggestPowerOfTen(num);
            int tenToTheBiggestPower = (int) Math.pow(10, biggestPower);
            int digit = num / tenToTheBiggestPower;
            if (arr[digit] == null) {
                arr[digit] = new Node<>(power + 1);
            } else {
                Node<Integer> current = arr[digit];
                while (current.hasNext()) {
                    current = current.getNext();
                }
                current.setNext(new Node<>(power + 1));
            }
            power += 1;
            num = num % tenToTheBiggestPower;
        } while (num != 0);
        return arr;
    }

    public static int biggestPowerOfTen(int n) {
        int count = 0;
        while (n >= 10) {
            n = n / 10;
            count++;
        }
        return count;
    }

    public static int maxOfLists(Node<Integer>[] arList) {
        int max = -1;
        for (Node<Integer> first : arList) {
            Node<Integer> current = first;
            while (current != null) {
                int n = current.getValue();
                if (n > max) {
                    max = n;
                }
                current = current.getNext();
            }
        }
        return max;
    }

}
