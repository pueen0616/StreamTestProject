package StreamTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


class Member {
	String name;
	int English;
	int math;
	
	public Member(String name, int english, int math) {
		super();
		this.name = name;
		English = english;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnglish() {
		return English;
	}

	public void setEnglish(int english) {
		English = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", English=" + English + ", math=" + math + "]";
	}
}
	// 100���� �ȵǴ� �л� : (��ù� : 80, 10), (���翵 : 60, 20)
public class Exam04 {
	public static void main(String[] args) {
	List<Member> list = Arrays.asList(new Member("������", 90, 50),
			   						  new Member("��ù�", 80, 10),
			   						  new Member("�㼺��", 70, 60),
			   						  new Member("���翵", 60, 20));
	
	Stream<Member> students = list.stream();
	students.filter(e->e.English + e.math < 100).forEach(System.out::println);
	}
}
