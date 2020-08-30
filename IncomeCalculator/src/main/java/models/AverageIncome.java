package models;

public class AverageIncome {
	private String city;
	private String country;
	private String gender;
	private String currency;
	private String averageIncome;
	

	public AverageIncome(String city, String gender, String currency, String averageIncome) {
		super();
		this.city = city;
		this.gender = gender;
		this.currency = currency;
		this.averageIncome = averageIncome;
	}
	public AverageIncome(String city, String country, String gender, String currency, String averageIncome) {
		super();
		this.city = city;
		this.country = country;
		this.gender = gender;
		this.currency = currency;
		this.averageIncome = averageIncome;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAverageIncome() {
		return averageIncome;
	}
	public void setAverageIncome(String averageIncome) {
		this.averageIncome = averageIncome;
	}
	
	@Override
	public String toString() {
		return "AverageIncome [city=" + city + ", country=" + country + ", gender=" + gender + ", currency=" + currency
				+ ", averageIncome=" + averageIncome + "]";
	}
}
