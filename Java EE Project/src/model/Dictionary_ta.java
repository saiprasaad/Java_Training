package model;

import java.util.ListResourceBundle;

public class Dictionary_ta extends ListResourceBundle{
	Object obj[][]= {
			{"username","\r\n" + 
					"பெயர்" },{"password","\r\n" + 
							"கடவுச்சொல்" },
	};
	@Override
	protected Object[][] getContents() {
		return obj;
	}
}
