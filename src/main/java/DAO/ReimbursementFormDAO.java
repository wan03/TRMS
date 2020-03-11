package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.ReimbursementForm;
import util.ConnectionFactory;

public class ReimbursementFormDAO {
	
	private Connection conn = ConnectionFactory.getConnection();
	
	private static final String REIMBURSEMENT_TABLE = "reimbursement";
	private static final String SELECT_ALL_FORMS = "SELECT * FROM " + REIMBURSEMENT_TABLE;
	private static final String INSERT_FORM = "INSERT INTO " 
	+ REIMBURSEMENT_TABLE + 
	" (first_name, last_name, address, city, state, zip, user_id, email, institution_name, institution_address, institution_city, institution_state, institution_zip, program_name, start_date, end_date, week_days, time_block, description, cost, grade_format, event_type, reimbursement_amount, justification, status, submitted) "
			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private static final String UPDATE_FORM = "UPDATE " + REIMBURSEMENT_TABLE + " SET ";
	
	
	public List<ReimbursementForm> retrieveForms () {
		
		List<ReimbursementForm> forms = new ArrayList<ReimbursementForm>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_FORMS);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				forms.add(
						new ReimbursementForm(
								rs.getInt("reimbid"), 
								rs.getString("first_name"), 
								rs.getString("last_name"), 
								rs.getString("address"), 
								rs.getString("city"),
								rs.getString("state"), 
								rs.getString("zip"), 
								rs.getInt("user_id"), 
								rs.getString("email"), 
								rs.getString("institution_name"), 
								rs.getString("institution_address"),
								rs.getString("institution_city"),
								rs.getString("institution_state"), 
								rs.getString("institution_zip"), 
								rs.getString("program_name"), 
								rs.getDate("start_date").toLocalDate(), 
								rs.getDate("end_date").toLocalDate(), 
								rs.getString("week_days"), 
								rs.getString("time_block"), 
								rs.getString("description"), 
								rs.getDouble("cost"), 
								rs.getString("grade_format"), 
								rs.getString("event_type"), 
								rs.getDouble("reimbursement_amount"), 
								rs.getString("justification"), 
								rs.getString("status"),
								rs.getString("information_request"),
								rs.getDate("submitted").toLocalDate(),
								rs.getString("file")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return forms;
	}
	
	public List<ReimbursementForm> retrieveForms (int user_id) {
List<ReimbursementForm> forms = new ArrayList<ReimbursementForm>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_FORMS + " where user_id = ?");
			stmt.setInt(1, user_id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				forms.add(
						new ReimbursementForm(
								rs.getInt("reimbid"), 
								rs.getString("first_name"), 
								rs.getString("last_name"), 
								rs.getString("address"),
								rs.getString("city"),
								rs.getString("state"), 
								rs.getString("zip"), 
								rs.getInt("user_id"), 
								rs.getString("email"), 
								rs.getString("institution_name"), 
								rs.getString("institution_address"),
								rs.getString("institution_city"),
								rs.getString("institution_state"), 
								rs.getString("institution_zip"), 
								rs.getString("program_name"), 
								rs.getDate("start_date").toLocalDate(), 
								rs.getDate("end_date").toLocalDate(), 
								rs.getString("week_days"), 
								rs.getString("time_block"), 
								rs.getString("description"), 
								rs.getDouble("cost"), 
								rs.getString("grade_format"), 
								rs.getString("event_type"), 
								rs.getDouble("reimbursement_amount"), 
								rs.getString("justification"), 
								rs.getString("status"),
								rs.getString("information_request"),
								rs.getDate("submitted").toLocalDate(),
								rs.getString("file")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return forms;
	}
	
	public ReimbursementForm retrieveForm (int id) {
		
		ReimbursementForm form = null;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_FORMS + " where reimbid = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				form =			new ReimbursementForm(
								rs.getInt("reimbid"), 
								rs.getString("first_name"), 
								rs.getString("last_name"), 
								rs.getString("address"),
								rs.getString("city"),
								rs.getString("state"), 
								rs.getString("zip"), 
								rs.getInt("user_id"), 
								rs.getString("email"), 
								rs.getString("institution_name"), 
								rs.getString("institution_address"),
								rs.getString("institution_city"),
								rs.getString("institution_state"), 
								rs.getString("institution_zip"), 
								rs.getString("program_name"), 
								rs.getDate("start_date").toLocalDate(), 
								rs.getDate("end_date").toLocalDate(), 
								rs.getString("week_days"), 
								rs.getString("time_block"), 
								rs.getString("description"), 
								rs.getDouble("cost"), 
								rs.getString("grade_format"), 
								rs.getString("event_type"), 
								rs.getDouble("reimbursement_amount"), 
								rs.getString("justification"), 
								rs.getString("status"),
								rs.getString("information_request"),
								rs.getDate("submitted").toLocalDate(),
								rs.getString("file"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return form;
	}
	
	public void insertForm (ReimbursementForm form) {
		
		
		try {
			PreparedStatement stmt = conn.prepareStatement(INSERT_FORM);
			stmt.setString(1, form.getFirstName());
			stmt.setString(2, form.getLastName());
			stmt.setString(3, form.getAddress());
			stmt.setString(4, form.getCity());
			stmt.setString(5, form.getState());
			stmt.setString(6, form.getZip());
			stmt.setInt(7, form.getUserId());
			stmt.setString(8, form.getEmail());
			stmt.setString(9, form.getInstitutionName());
			stmt.setString(10, form.getInstitutionaddress());
			stmt.setString(11, form.getInstitutionstate());			
			stmt.setString(12, form.getInstitutioncity());
			stmt.setString(13, form.getInstitutionzip());
			stmt.setString(14, form.getProgramName());
			stmt.setDate(15, Date.valueOf(form.getStartDate()));
			stmt.setDate(16, Date.valueOf(form.getEndDate()));
			stmt.setString(17, form.getWeekDays());
			stmt.setString(18, form.getTimeBlock());
			stmt.setString(19, form.getDescription());
			stmt.setDouble(20, form.getCost());
			stmt.setString(21, form.getGradeFormat());
			stmt.setString(22, form.getEventType());
			stmt.setDouble(23, form.getReimbursementAmount());
			stmt.setString(24, form.getJustification());
			stmt.setString(25, "pending");
			stmt.setDate(26, Date.valueOf(form.getSubmitted()));
			
			stmt.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
	}
	
public void updateForm (String column, String value, int id) {
		
		try {
			PreparedStatement stmt = conn.prepareStatement(UPDATE_FORM + column + "=? WHERE reimbid=?");
			stmt.setString(1, value);
			stmt.setInt(2, id);
			System.out.println(stmt + " DAO");
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



}
