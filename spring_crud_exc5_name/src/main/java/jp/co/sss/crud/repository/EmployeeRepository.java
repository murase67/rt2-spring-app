package jp.co.sss.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.crud.entity.Department;
import jp.co.sss.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	//ログイン
	Employee findByEmpIdAndEmpPass(Integer empId, String empPass);
	
	//社員IDで全件検索
	List<Employee> findAllByOrderByEmpIdAsc();
	
	//社員名検索
	List<Employee> findByEmpNameContainingOrderByEmpId(String empName);
	
	//部署ID検索
	List<Employee> findByDepartmentOrderByEmpId(Department department);
}
