package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.query.EmployeeQuery;
import com.metacube.training.dao.query.ProjectQuery;
import com.metacube.training.mappers.EmployeeMapper;
import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.mappers.SearchMapper;
import com.metacube.training.model.Employee;

/**
 * To implement employee DAO methods
 * 
 * @author Rachna Jadam
 *
 */
@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee getEmployeeById(int id) {
        try {
	    TypedQuery<Employee> query = sessionFactory.getCurrentSession()
	            .createQuery(EmployeeQuery.GET_EMPLOYEE_BY_ID);
	    query.setParameter("id", id);
	    return query.getSingleResult();
	} catch (EmptyResultDataAccessException emptyResultDataAccessException) {
	    emptyResultDataAccessException.printStackTrace();
	    return null;
	} catch (Exception exception) {
	    exception.printStackTrace();
	    return null;
	}	            
    }
    
    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = sessionFactory.getCurrentSession()
             .createQuery(EmployeeQuery.GET_ALL_EMPLOYEES);
        return query.getResultList();
    }

    @Override
    public boolean deleteEmployeeById(Employee employee) {
        try {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(EmployeeQuery.DELETE_EMPLOYEE_BY_ID);
            query.setParameter("id", employee.getId());
            return query.executeUpdate() > 0;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        try {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                    .createQuery(EmployeeQuery.UPDATE_EMPLOYEE_BY_ID);
            query.setParameter("first_name", employee.getFirstName());
            query.setParameter("middle_name", employee.getMiddelName());
            query.setParameter("dob", employee.getDob());
            query.setParameter("gender", employee.getGender());
            query.setParameter("primary_contact_no", employee.getPrimaryContactNumber());
            query.setParameter("secondary_contact_no", employee.getSecondaryContactNumber());
            query.setParameter("email_id", employee.getEmailId());
            query.setParameter("skype_id", employee.getSkypeId());
            query.setParameter("id", employee.getId());
            return query.executeUpdate() > 0;
       } catch (Exception exception) {
           exception.printStackTrace();
           return false;
       }
    }

    @Override
    public boolean createEmployee(Employee employee) {
        try {
            sessionFactory.getCurrentSession().save(employee);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Employee getEmployeeByEmailId(String emailId) {
	try {
            TypedQuery<Employee> query = sessionFactory.getCurrentSession()
                .createQuery(EmployeeQuery.GET_EMPLOYEE_ID_BY_EMAIL_ID);
            query.setParameter("email_id", emailId);
            return query.getSingleResult();
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
	    emptyResultDataAccessException.printStackTrace();
	    return null;
	} catch (Exception exception) {
	    exception.printStackTrace();
	    return null;
	}
    }

    @Override
    public Employee searchByName(String name) {
        try {
	    TypedQuery<Employee> query = sessionFactory.getCurrentSession()
	            .createQuery(EmployeeQuery.SEARCH_EMPLOYEE_BY_NAME);
	    query.setParameter("first_name", name);
	    return query.getSingleResult();
	} catch (EmptyResultDataAccessException emptyResultDataAccessException) {
	    emptyResultDataAccessException.printStackTrace();
	    return null;
	} catch (Exception exception) {
	    exception.printStackTrace();
	    return null;
        }
    }
}
