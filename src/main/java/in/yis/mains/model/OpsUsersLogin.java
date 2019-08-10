package in.yis.mains.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class OpsUsersLogin {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private long id;
	
	private String name;
	
	private String username;
	
	private String password;
	
	private String oldPassword;
	
	private String status_flag;
	
	private int wrong_attampts;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date created_date;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date expiry_date;
	
	private int rights;
	
	private String address;
	
	private String designation;
	
	private long empId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date created_by;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date updated_by;
}
