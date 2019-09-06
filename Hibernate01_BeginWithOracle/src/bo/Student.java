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
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fullname", nullable = false)
	private String fullName;

	@Column(name = "birthday", nullable = false)
	private java.util.Date birthday;

	@Column(name = "classname", nullable = false)
	private String className;

	public Student() {
	}

	public Student(int id, String fullName, Date birthday, String className) {
		this.id = id;
		this.fullName = fullName;
		this.birthday = birthday;
		this.className = className;
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
