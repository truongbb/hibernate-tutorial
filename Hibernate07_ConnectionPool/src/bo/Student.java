package bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ID_STUDENT")
	@SequenceGenerator(name = "GEN_ID_STUDENT", sequenceName = "SEQ_STUDENT", allocationSize = 1)
	private Long id;

	@Column(name = "fullname", nullable = false)
	private String fullName;

	@Column(name = "birthday", nullable = false)
	private java.util.Date birthday;

	@Column(name = "classname", nullable = false)
	private String className;

	public Student() {
	}

	public Student(Long id, String fullName, Date birthday, String className) {
		this.id = id;
		this.fullName = fullName;
		this.birthday = birthday;
		this.className = className;
	}

	public Student(String fullName, Date birthday, String className) {
		this.fullName = fullName;
		this.birthday = birthday;
		this.className = className;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fullName=" + fullName + ", birthday=" + birthday + ", className=" + className
				+ "]";
	}

}
