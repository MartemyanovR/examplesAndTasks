package bloh.twoDotOne;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class AbstractSkeletalImplementations {

	public static void main(String[] args) {
		int[] a = {4,32,2,1};
 		List<Integer> al = intArrayAsList(a);
 		System.out.println(al.get(1));

	}
	
	static List<Integer> intArrayAsList(int[] a) {
		Objects.requireNonNull(a);
		// �������� "����" � ��������� ����� ������ � Java 9
		//� ����� ������� �������. ��� ������������� �����
		// ������ ������ ���������� <Integer>
		return new AbstractList<Integer>() {
			@Override public Integer get(int i)
			{
				System.out.println("!!!");
				return a[i]; // ������������ (������ 2.6)
			}
			@Override public Integer set(int i, Integer val) {
				int oldVal = a[i];
				a[i] = val; // ��������������
				return oldVal; // ������������
			}
			@Override public int size()
			{
				return a.length;
			}
		};
	}

}
