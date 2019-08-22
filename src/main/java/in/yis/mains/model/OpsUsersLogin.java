package in.yis.mains.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;

import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(
	    name="ops_users_login",
	    uniqueConstraints={@UniqueConstraint(columnNames={"username"})}
	)
public class OpsUsersLogin {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private long id;
	
	private String name;
	
	@Column(name="username")
	private String username;
	
	private String password;
	
	private String oldPassword;
	
	private String status_flag;
	
	private int wrong_attampts;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date created_date;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date expiry_date;
	
	
	private long rights;
	
	private String address;
	
	private String designation;
	
	private long empId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date created_by;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date updated_by;
	
	@ManyToMany
    @JoinTable( 
        name = "opsUsersLogin_roles", 
        joinColumns=@JoinColumn(name = "user_id", referencedColumnName = "id"), 
        inverseJoinColumns=@JoinColumn(name = "role_id", referencedColumnName = "id")) 
    private Collection<Role> roles;
	
	
}
