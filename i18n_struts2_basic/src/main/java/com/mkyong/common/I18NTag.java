package com.mkyong.common;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class I18NTag extends SimpleTagSupport {

	private String language;
	private String imageURL;

	public I18NTag() {
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public void doTag() throws JspException, IOException {
		String contextPath = ServletActionContext.getRequest().getContextPath();
		String nameSpace = ServletActionContext.getActionMapping()
				.getNamespace();
		String action = ActionContext.getContext().getName();
		String pathImages = "/i18n/";

		try {
			String html = "";
			String nombreFormulario = language + "form";
			html += "<form action=\"" + contextPath + nameSpace + "/" + action
					+ "\" id=\"" + nombreFormulario + "\" method=\"post\">";

			// por cada parámetro, obtenemos el nombre y el valor

			HttpServletRequest request = ServletActionContext.getRequest();

			Enumeration<String> parameterNames = request.getParameterNames();

			while (parameterNames.hasMoreElements()) {

				String paramName = parameterNames.nextElement();
				if (!paramName.equals("request_locale") && !paramName.equals("submit")) {
					String paramValue = request.getParameter(paramName);
					html += "<input type=\"hidden\" name=\"" + paramName
							+ "\" value=\"" + paramValue + "\"/>";
				}
			}

			// Incluimos el language
			html += "<input type=\"hidden\" name=\"request_locale\" value=\""
					+ language + "\">";

			html += "</form>";

			html += "<a href=\"#\" onClick=\"document.getElementById('"
					+ nombreFormulario + "').submit();\"> <img src=\""
					+ contextPath + pathImages + imageURL + "\"></a>";
			getJspContext().getOut().write(html);
		} catch (Exception e) {
			e.printStackTrace();
			// stop page from loading further by throwing SkipPageException
			throw new SkipPageException(
					"Exception printing i18n tag,  language:" + language
							+ " imageURL:" + imageURL);
		}
	}
}
