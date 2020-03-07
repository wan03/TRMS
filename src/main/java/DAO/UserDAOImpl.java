package DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Employee;
import pojos.User;
import util.ConnectionFactory;


public class UserDAOImpl {
	
	public void addUser (User u) {
		
		try (Connection conn = ConnectionFactory.getConnection()){
		
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO users VALUES(?,?,?)");
		ps.setString(1, u.getFirstName());
		ps.setString(2, u.getLastName());
		ps.setString(2, u.getUsername());
		ps.setString(2, u.getPassword());
		ps.setString(2, u.getUserType());
		ps.setString(2, u.getPosition());
		
		
		ps.execute();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
		
	}
	
	public void addEmployee (Employee emp) {
		
		try (Connection conn = ConnectionFactory.getConnection()){
		
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO users VALUES(?,?,?)");
		ps.setString(1, emp.getFirstName());
		ps.setString(2, emp.getLastName());
		ps.setString(2, emp.getUsername());
		ps.setString(2, emp.getPassword());
		ps.setString(2, emp.getUserType());
		ps.setString(2, emp.getPosition());
		ps.setString(2, emp.getSupervisor());
		ps.setString(2, emp.getDepartmentHead());
		ps.setDouble(2, emp.getAvailableReimbursment());
		ps.setDouble(2, emp.getPendingReimbursment());
		
		
		ps.execute();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
		
	}
	
	
	public User readUser(String username) {
		User user = null;
	try (Connection conn = ConnectionFactory.getConnection()){
			
			
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=?");
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new Employee(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("username"), rs.getString("password"), rs.getString("userType"), rs.getString("position"), rs.getString("supervisor"), rs.getString("department_head"), rs.getDouble("available_reimbursement"), rs.getDouble("pending_reimbursement"));
		
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}	
	
	public List<User> readAllUsers (){
		
		
		List<User> users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getConnection()){
				
				
				
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					users.add(new Employee(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("username"), rs.getString("password"), rs.getString("userType"), rs.getString("position"), rs.getString("supervisor"), rs.getString("department_head"), rs.getDouble("available_reimbursement"), rs.getDouble("pending_reimbursement")));
					
				}
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return users;

		
	}
	
	public void updateUser (User u, String column, String value) {
		
		try (Connection conn = ConnectionFactory.getConnection()){
		
		
		PreparedStatement ps = conn.prepareStatement("UPDATE users SET ?=? WHERE id=?");
		ps.setString(1, column);
		ps.setString(2, value);
		ps.setInt(4, u.getUserId());
		
		
		ps.execute();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
		
	}
	
	public void removeUser (User u) {
		
	try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE username=?");
			ps.setString(1, u.getUsername());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
		
	}

}
