package bo;

import java.util.Date;

public class Student {

	private int id;
	private String fullName;
	private String className;
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
