package StreamTest;

import java.sql.SQLException;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.DoubleStream;

import basic.common.EmpDAO;
import basic.common.Employee;

public class Exam05 {
	public static void main(String[] args) {
		List<Employee> empList = null;
		try {
			empList = EmpDAO.getEmpList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		OptionalDouble result = empList.stream().flatMapToDouble(new Function<Employee, DoubleStream>(){

			@Override
			public DoubleStream apply(Employee t) {
				return DoubleStream.of(t.getSalary());
			}	
		}).average();
		System.out.println("전체 사원의 평균 급여  : " + result.getAsDouble() + "원");
	}
}
