package net.szecc.client.registration;


public enum UserType {
	
	STANDARD(1, "Standard"),
	RESTRICTED(2, "Restricted"),
	POWER(3, "Power"),
	ADMIN(4, "Admin");
	
	private Integer id;
	private String name;
	
	private UserType(Integer id, String name) {
		this.id=id;
		this.name=name;
	}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public static UserType toUserType(Integer id) throws IllegalArgumentException {
		for (UserType userType : values() ) {
			if (userType.getId().equals(id)) {
				return userType;
			}
		}
		throw new IllegalArgumentException("UserType not found:" + id);
	}
	
}
