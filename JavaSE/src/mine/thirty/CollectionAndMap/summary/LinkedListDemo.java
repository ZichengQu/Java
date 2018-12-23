package mine.thirty.CollectionAndMap.summary;

import java.util.*;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<String> ll = new LinkedList<String>();
		ll.addLast("java01");
		ll.addLast("java02");
		ll.addLast("java03");//永远在下标为0的位置插入
		ll.addLast("java04");//永远在下标为size()-1的位置插入
		System.out.println(ll);
	}

}
