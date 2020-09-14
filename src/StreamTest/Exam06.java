package StreamTest;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import basic.common.EmpDAO;
import basic.common.Employee;

public class Exam06 {
	public static void main(String[] args) {
		List<Employee> empList = null;
		try {
			empList = EmpDAO.getEmpList();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Map<String, List<Employee>> newList = empList.stream()
				.collect(Collectors.groupingBy(new Function<Employee, String>() {

					@Override
					public String apply(Employee t) {
						return t.getJobId();
					}
				}, Collectors.toList()));

		//�μ���
		Set<String> set = newList.keySet();
		for (String s : set) {
			System.out.println();
			System.out.println("--------------------" + s + "-------------------");

			newList.get(s);
			List<Employee> list = newList.get(s);
			for (Employee e : list) {
				// �̸�, �Ի���, �޿� ���
				System.out.println("�̸� : " + e.getFirstName() + ", �Ի��� : " + e.getHireDate() + ", �޿� : " + e.getSalary());
			}
		}
	}
}
