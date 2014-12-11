package org.afpa59.patrice.services.servlet;

import java.io.IOException;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MonTag01 extends SimpleTagSupport {
	
	@Override
	public void doTag(){
		
		try {
			
			getJspContext().getOut().println("Hello TAG 01");
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
}
