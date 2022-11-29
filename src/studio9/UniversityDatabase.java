package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	private final Map<String, Student> database;
	
	public UniversityDatabase() {
		this.database=new HashMap<String,Student>();
	}
	
	public void addStudent(String accountName, Student student) {
		this.database.put(accountName, student);
	}

	public int getStudentCount() {
		return this.database.size();
	}

	public String lookupFullName(String accountName) {

		if (this.database.get(accountName)==null) {
			return null;
		}
		else {
			return this.database.get(accountName).getFullName();	
		}
	}

	public double getTotalBearBucks() {
		double totalBearBucks=0;
		for (String key:this.database.keySet()) {
			totalBearBucks+=this.database.get(key).getBearBucksBalance();
		}
		return totalBearBucks;
	}
}
