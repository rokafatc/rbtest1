package kr.co.robin1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;

import kr.co.robin1.rbdata.emp.Employee;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;


public class Test1 {

	public static void main(String[] args) {
		System.out.println("Hello World 1");

		TestDataClass1 tdc1 = new TestDataClass1();
		tdc1.setIdxNumber(22);
		String rtnMsg = String.format("Return Result: %d", tdc1.getIdxNumber());
		System.out.println(rtnMsg);

		// TestJDBC1();
		TestMyBatis1();

//		try {
//			System.out.println("Press any key to exit.");
//			System.in.read();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	private static void TestMyBatis1() {
		System.out.println("TestMyBatis1========================");
		String resource = "kr/co/robin1/rbdata/RobinMyBatisConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			System.out.println("Resources.getResourceAsStream error raised.");
			e.printStackTrace();
		}
		if (inputStream != null) {
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			try {
//				Employee emp = (Employee)session.selectOne("kr.co.robin1.rbdata.emp.EmpMapper.selectEmpOne", 192);
//				System.out.println(String.format("Name: %s, %s", emp.getFirst_Name(), emp.getLast_Name()));
				//
				Employee emp = (Employee)session.selectOne("kr.co.robin1.rbdata.emp.EmpMapper.selectEmpOne", 992);
				if (emp == null) {
					System.out.println("Returned emp is null");
					return;
				}
//				List<Employee> lstEmp = session.selectOne("kr.co.robin1.rbdata.emp.EmpMapper.selectEmpOne", 992);
//				if (lstEmp == null) {
//					System.out.println("Return is null");
//					return;
//				}
				//System.out.println(String.format("Retrieved Result: %s", lstEmp.isEmpty()));
				
//				System.out.println(String.format("Retrieved Count: %d", lstEmp.size()));
//				for(Employee emp: lstEmp) {
//					System.out.println(String.format("Name: %s, %s", emp.getFirst_Name(), emp.getLast_Name()));
//				}
				//
//				List<Employee> lstEmp = session.selectList("kr.co.robin1.rbdata.emp.EmpMapper.selectEmp");
//				for(Employee emp: lstEmp) {
//					System.out.println(String.format("All Name: %s, %s", emp.getFirst_Name(), emp.getLast_Name()));
//				}
				//
//				List<Employee> lstEmp = session.selectList("kr.co.robin1.rbdata.emp.EmpMapper.selectEmpCond1", "peter");
//				for(Employee emp: lstEmp) {
//					System.out.println(String.format("Cond1 Name: %s, %s", emp.getFirst_Name(), emp.getLast_Name()));
//				}
			} catch (Exception e) {
				System.out.println("error raise.");
				e.printStackTrace();
			} finally {
				System.out.println("Session will be closed");
				session.close();
			}
		}
		System.out.println("=================================");
	}

	private static void TestJDBC1() {
		System.out.println("TestJDBC1========================");
		String oracleDriver = "oracle.jdbc.driver.OracleDriver";
		String conUrl = "jdbc:oracle:thin:@localhost:1521:XE";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(oracleDriver);
			con = DriverManager.getConnection(conUrl, "hr", "noadmin");

			// Statement
			String sql = "select * from employees";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(String.format("%d, %s, %s",
						rs.getInt("employee_ID"), rs.getString("first_name"),
						rs.getString("last_name")));
			}
			System.out.println("Successfully connected 1");
		} catch (Exception e) {
			System.out.println("Connection or other failed 1");
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e1) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
				}
			}
		}
		System.out.println("=================================");
	}

}
