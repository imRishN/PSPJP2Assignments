package models;

public class Summary {
	private String country;
	private String gender;
	private String averageIncome;
	
	public Summary(String country, String gender, String averageIncome) {
		super();
		this.country = country;
		this.gender = gender;
		this.averageIncome = averageIncome;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAverageIncome() {
		return averageIncome;
	}
	public void setAverageIncome(String averageIncome) {
		this.averageIncome = averageIncome;
	}
	
	@Override
	public String toString() {
		return "Summary [country=" + country + ", gender=" + gender + ", averageIncome=" + averageIncome + "]";
	}
}
