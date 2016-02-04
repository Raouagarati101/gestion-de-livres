package ch.blutch.library.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "SMALLINT UNSIGNED")
	private int id;
	
	@Column(name = "username", columnDefinition = "VARCHAR(100)", nullable = false)
	private String username;
	
	@Column(name = "password", columnDefinition = "VARCHAR(500)", nullable = false)
	private String password;
	
	@Column(name = "enabled", columnDefinition = "BOOLEAN", nullable = true)
	private boolean enabled;
	
	@ManyToOne(targetEntity = UserRole.class)
	@JoinColumn(name = "user_role_id", columnDefinition = "SMALLINT UNSIGNED", nullable = true)
	@Cascade({CascadeType.SAVE_UPDATE})
	private UserRole userRole;
	
	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
}

