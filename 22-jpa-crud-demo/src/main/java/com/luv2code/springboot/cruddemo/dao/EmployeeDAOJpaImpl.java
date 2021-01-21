package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	// define fields for entity manager
	private EntityManager entityManager;

	// set up constructor injection

	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> getEmployees() {


		// create a query
		Query theQuery = entityManager.createQuery("from Employee", Employee.class);

		// execute the query and result list
		List<Employee> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public Employee getSingleEmployee(int id) {
		
		Employee theEmployee = entityManager.find(Employee.class, id);
		
		return theEmployee;
	}

	@Override
	public void saveOrUpdateEmployee(Employee employee) {
		
		Employee dbEmployee = entityManager.merge(employee);
		
		employee.setId(dbEmployee.getId());
		
		
		
	}

	@Override
	public void deleteEmployee(int id) {
		
		Query theQuery = 
				entityManager.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", id);
		
		theQuery.executeUpdate();
		
	}
	
	

}
