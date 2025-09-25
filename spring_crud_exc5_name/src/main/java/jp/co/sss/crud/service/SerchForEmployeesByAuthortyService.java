package jp.co.sss.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.repository.EmployeeRepository;
import jp.co.sss.crud.util.BeanManager;

@Service
public class SerchForEmployeesByAuthortyService {
	@Autowired
	EmployeeRepository repository;
	
	/**
	 * 権限検索サービスクラス。
	 * 指定された権限を基に、該当する従業員情報を取得し、EmployeeBeanとして返却します。
	 * データベースからの参照取得にはfindByAuthorityOrderByEmpIdメソッドを使用します。
	 */
	public List<EmployeeBean> execute(Integer authority){
		List<Employee> searchAuthority = repository.findByAuthorityOrderByEmpId(authority);
		List<EmployeeBean> employeeBean = BeanManager.copyEntityListToBeanList(searchAuthority);
		return employeeBean;
	}
}
