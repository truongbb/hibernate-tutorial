package bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "fullName", nullable = false)
	private String fullName;

	@Column(name = "className", nullable = false)
	private String className;

	@Column(name = "birthday", nullable = false)
	private java.util.Date birthday;

	public Student() {
	}

	public Student(int id, String fullName, String className, Date birthday) {
		this.id = id;
		this.fullName = fullName;
		this.className = className;
		this.birthday = birthday;
	}

	public Student(String fullName, String className, Date birthday) {
		this.fullName = fullName;
		this.className = className;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fullName=" + fullName + ", className=" + className + ", birthday=" + birthday
				+ "]";
	}

}
