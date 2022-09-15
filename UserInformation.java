package design_patterns;

public class UserInformation {
	private int UserType;	
	private String UserName;
	private String Password;
	
	UserInformation(int userType,String UserName,String Password){
		this.UserType = userType;
		this.UserName = UserName;
		this.Password = Password;
	}

	public String getPassword() {
		if(!Password.isEmpty()) {
			return Password;
		}
		else {
			return "";
		}
		
	}

	public String getUserName() {
		if(!UserName.isEmpty()) {
			return UserName;
		}
		else {
			return "";
		}		
	}
	
	public int getUserType() {
		if(UserType==0 || UserType==1) {
			return UserType;
		}
		else {
			return -1;
		}
		
	}

	
	
}
