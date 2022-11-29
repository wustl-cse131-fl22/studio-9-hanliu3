package assignment7;

public class Student {
	//instance variables 
	private String firstName;
	private String lastName;
	private int id;
	private int attemptedCredits;
	private int passingCredits;
	private double qualityPoints;
	private double bearBucks;

	
	//constructor
	public Student(String firstName, String lastName, int id) {
	this.firstName=firstName;
	this.lastName=lastName;
	this.id=id;
	}	

	//getters
	public String getFullName() {
		String fullName= this.firstName+ " " + this.lastName;
		return fullName;
	}
	
	public int getId() {
		return this.id;
	}
	
	//setting quality points, attempted credits, and passing credits
	public void submitGrade(double grade, int credits) {
		

		this.attemptedCredits+=credits;
		
		if (grade>=1.7) {
			this.passingCredits+=credits;
		}
		
		this.qualityPoints += grade * credits;
	}
	
	//getters
	public int getTotalAttemptedCredits() {
		return this.attemptedCredits;
	}
	
	public int getTotalPassingCredits() {
		return this.passingCredits;
	}
	
	//calculating student GPA based on submitGrade method
	public double calculateGradePointAverage() {
		return this.qualityPoints/this.attemptedCredits;
		
	}
	
	//determining student grade
	public String getClassStanding() {
		if (this.passingCredits<30) {
			return "First Year";
		}
		else if ((this.passingCredits>=30 && this.passingCredits<60)) {
			return "Sophomore";
		}
		else if ((this.passingCredits>=60 && this.passingCredits<90)) {
			return "Junior";
		}
		else {
			return "Senior";
		}
		
	}
	
	//determining if student is elligible
	public boolean isEligibleForPhiBetaKappa() {
		if (this.attemptedCredits>=98 && calculateGradePointAverage()>=3.6) {
			return true;
		}
		if (this.attemptedCredits>=75 && calculateGradePointAverage()>=3.8) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//setting and getting bear bucks balance
	public void depositBearBucks(double amount) {
		this.bearBucks+=amount;
		return;
	}
	
	public void deductBearBucks(double amount) {
		this.bearBucks-=amount;
		return;
	}
	
	public double getBearBucksBalance() {
		return this.bearBucks;
	}
	
	
	
	//calculating cashout 
	public double cashOutBearBucks() {
		double cashOut=0;
		if (this.bearBucks<=10) {
			this.bearBucks=0;
			cashOut=0;
		}
		else{
			cashOut=this.bearBucks-10;
			this.bearBucks=0;
		}
		return cashOut;
		
	}
	

	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		String lastName="";
		this.id=id;
		
		//determining student last name 
		if (isHyphenated==false) {
			lastName=this.lastName;
		}
		
		if (isHyphenated==true) {
			lastName=this.lastName+"-"+other.lastName;
		}
		
		//creating a new object: child 
		Student child= new Student (firstName, lastName,id);
		child.depositBearBucks(this.cashOutBearBucks()+other.cashOutBearBucks());
		
		return child;
		
	}
	
	public String toString() {
		return getFullName()+getId();
	}
	

	
	
	
	
	
	
}

