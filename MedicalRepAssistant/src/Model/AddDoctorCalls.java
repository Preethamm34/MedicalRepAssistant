package Model;

public class AddDoctorCalls {

	private int userId;
	private String doctorname;
	private String phonenumber;
	private String address;
	private String location;
	private String sampledetails;
	private String doctorcallon;
	
	@Override
	public String toString() {
		return "AddDoctorCalls [userId=" + userId + ", doctorname=" + doctorname + ", phonenumber=" + phonenumber
				+ ", address=" + address + ", location=" + location + ", sampledetails=" + sampledetails
				+ ", doctorcallon=" + doctorcallon + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSampledetails() {
		return sampledetails;
	}

	public void setSampledetails(String sampledetails) {
		this.sampledetails = sampledetails;
	}

	public String getDoctorcallon() {
		return doctorcallon;
	}

	public void setDoctorcallon(String doctorcallon) {
		this.doctorcallon = doctorcallon;
	}
	
	
	
}
