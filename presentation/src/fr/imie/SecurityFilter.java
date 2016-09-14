package fr.imie;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter("/CrowdFundingGiveController")
public class SecurityFilter implements Filter {
 
	@Inject IUserConnectedManagement userConnectedManagement;
	
	/**
	 * Default constructor.
	 */
	public SecurityFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		Boolean resourceToSecure = true;

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		String url = httpServletRequest.getRequestURI();
		if (httpServletRequest.getQueryString() != null) {
			url = url.concat("?").concat(httpServletRequest.getQueryString());
		}
		if (url.contains("Login")) {
			resourceToSecure = false;
		}
		if (url.contains("css")) {
			resourceToSecure = false;
		}
		if (url.contains("png")) {
			resourceToSecure = false;
		}

		//UserDTO LogedUser = (UserDTO) httpServletRequest.getSession().getAttribute("logedUser");
		UserEntity LogedUser = userConnectedManagement.getUserDTO();
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		if (resourceToSecure == false || LogedUser != null) {
			chain.doFilter(request, response);

		} else {
			//httpServletRequest.getSession().setAttribute("urlAim", url);
			System.out.println("save ".concat(url));
			userConnectedManagement.setAimUrl(url);
			httpServletResponse.sendRedirect("LoginController");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
