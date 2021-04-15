package com.model;

import java.util.ListResourceBundle;

public class Dictionary_hi extends ListResourceBundle{
	Object obj[][]= {
			{"username","उपयोगकर�?ता नाम" },
			{"password","पारण शब�?द " },
	};
	@Override
	protected Object[][] getContents() {
		return obj;
	}
}
