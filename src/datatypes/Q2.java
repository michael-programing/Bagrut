package datatypes;

public class Q2 {

	public static void main(String[] args) {
		Node<Integer>[] num = createBigNum();
		printBigNum(num);
		

	}
	//just iterate to print
	public static void printBigNum(Node<Integer>[] num) {
		int place = 1;
		for (int i = 0; i < num.length; i++) {
			if(num[i] != null) {
				Node<Integer> values = num[i];
				do {
					if(values.getValue() == place) {
						System.out.print(values.getValue()+" ");
						place++;
					}
					values = values.getNext();
				}
				while(values != null);
			}
		}
	}
	/**
	 * 
	 * @return an array of Node type integer with filled values 1,2,3
	 */
	public static Node<Integer>[] createBigNum(){
		 Node<Integer>[] big = (Node<Integer>[]) new Node[10];
		 big[0] = new Node<Integer>(1);
		 big[1] = new Node<Integer>(2,  new Node<Integer>(3));
		 
		 return big;
	}

}
