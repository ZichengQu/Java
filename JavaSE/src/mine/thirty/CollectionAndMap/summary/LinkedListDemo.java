package mine.thirty.CollectionAndMap.summary;

import java.util.*;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<String> ll = new LinkedList<String>();
		ll.addLast("java01");
		ll.addLast("java02");
		ll.addLast("java03");//��Զ���±�Ϊ0��λ�ò���
		ll.addLast("java04");//��Զ���±�Ϊsize()-1��λ�ò���
		System.out.println(ll);
	}

}
