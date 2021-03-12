package arrays;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllMethodsArrays {

	public static void main(String[] args) throws Exception {
		Integer[] i = {1,56,7,87,9,0,3,33,3,25,9,4,46};
		//Arrays.asList(null);  //npe		
		List<Integer>list = Arrays.asList(i);  //����������� � ����(Arrays.asList ���������� ������� List ������ �������)
	//	list.remove(87);  //UnsupportedOperationException, Arrays.ArrayList ������������ ������ set(), �� �� �� ������ ������� 
	//	list.add(100); //UnsupportedOperationException
		Collections.sort(list, (o1,o2) -> o1-o2);  //�����������
		list.stream().forEach((y) -> System.out.print(y + " "));   //������� �� �����
		Integer[] integers = list.toArray(new Integer[0]);
		System.out.println("\n" + Arrays.binarySearch(integers, 0,8 , 5));  //���������� ����� ��������(� ������ ����� �������), ���� ������ ��������� ���������
		System.out.println(Arrays.toString(i));
		System.out.println("\n" + Arrays.binarySearch(i, 25 , (o1,o2) -> o1-o2));  //��������� comporator
		System.out.println(Arrays.toString(Arrays.copyOf(i, 50)));  //������� ������ ���������� �������(�������� null)
		Number[] num = Arrays.copyOfRange(i, 1, 5, Number[].class);  //����������� ���������� + �������������� � ������� ����
		System.out.println(Arrays.toString(num));
		Arrays.fill(i, 5, 7, -1);  //��������� ��������� ����� ����� ����������(-1)
		System.out.println(Arrays.toString(i));
		double[] d = {5.2, 6.8, 1.2, 7.2, 1.3};
	//	Arrays.parallelPrefix(d, (x,y) -> x+=y); //���������� ������ ������� �������
	//	Arrays.stream(d).forEach((z) -> System.out.print(z + ", "));
		Arrays.parallelSetAll(d, iq->iq*2);  //������������� �������� ������� � ������� ������-���������
	    Arrays.stream(d).forEach((z) -> System.out.print(z + ", "));
		System.out.println();
		Arrays.parallelSort(d,1,5);
		Arrays.stream(d).forEach((z) -> System.out.print(z + ", "));
		
		
		//�� ������� Java Puzzlers NG S02
		ArrayList[] two = new ArrayList[10];
		Arrays.setAll(two,ArrayList::new);  //�.� �������� ������� ���������� � �������� arrayList ��� capacity, � ��� ��� ������ ���������
		System.out.println(Arrays.deepToString(two));
		two[0].add("!!!");
		two[0].add("???");	
		System.out.println(two[3].size() + " " + getCapacity(two[85]));  //����� ������� ������ ��������, ���  
		two[0].forEach(System.out::print);
		System.out.println(Arrays.deepToString(two));
	}
	
	//����� ������� ��������� capacity ���������
	static int getCapacity(ArrayList<?> l) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }

}
