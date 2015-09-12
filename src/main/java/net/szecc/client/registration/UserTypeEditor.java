package net.szecc.client.registration;

import java.beans.PropertyEditorSupport;

public class UserTypeEditor extends PropertyEditorSupport {
	
	public void setAsText(String text) {
		Integer id = Integer.parseInt(text);
		UserType ut = UserType.toUserType(id);
		setValue(ut);
	}
	
}
