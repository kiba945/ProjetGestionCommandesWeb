package org.afpa59.patrice.services.servlet;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MonTag02 extends BodyTagSupport{
	
	
	/**
	 * 
	 */
	private String name = null;
	
	public void setName (String string) {
		this.name = string;
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException{
		
		if (this.name==null){
			this.name = "World";
		}
			
		
		try {
			pageContext.getOut().println ("Hello " + this.name + " !");
		} catch (IOException e) {
			throw new JspException ("I/O Error", e);
		}
		return SKIP_BODY;
		
	}
	
	@Override
	public void doInitBody() throws JspException{
		super.doInitBody();
	}
	
	@Override
	public int doAfterBody() throws JspException{
		return super.doAfterBody();
		
	}
	
	@Override
	public int doEndTag() throws JspException{
		return super.doEndTag();
	}
	
}
