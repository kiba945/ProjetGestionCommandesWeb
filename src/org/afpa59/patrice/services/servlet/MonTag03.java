package org.afpa59.patrice.services.servlet;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MonTag03 extends BodyTagSupport{
	
	
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
		
		String value = pageContext.getRequest().getParameter(this.name);
       
		if (value != null){
			
			this.name = "World";
			return EVAL_BODY_INCLUDE;
		}
				
		return SKIP_BODY;
		
	}
	
	@Override
	public void doInitBody() throws JspException{
		super.doInitBody();
	}
	
	@Override
	public int doAfterBody() throws JspException{
		
		try {
			if ( getBodyContent()!=null ) {
				String bodyString = getBodyContent().getString();
				bodyString = bodyString.toUpperCase();
				getBodyContent().getEnclosingWriter().println( bodyString );
			}
		} catch (IOException e) {
			throw new JspException (e);
		}
		
		return EVAL_PAGE;
		
	}
	
	@Override
	public int doEndTag() throws JspException{
		pageContext.removeAttribute("value");
		return EVAL_PAGE;
	}
	
}
