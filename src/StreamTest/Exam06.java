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

		//부서별
		Set<String> set = newList.keySet();
		for (String s : set) {
			System.out.println();
			System.out.println("--------------------" + s + "-------------------");

			newList.get(s);
			List<Employee> list = newList.get(s);
			for (Employee e : list) {
				// 이름, 입사일, 급여 출력
				System.out.println("이름 : " + e.getFirstName() + ", 입사일 : " + e.getHireDate() + ", 급여 : " + e.getSalary());
			}
		}
	}
}
