package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;
import action.Action;
import action.MdCartAddAction;
import action.MdCartListAction;
import action.MdCartQtyDownAction;
import action.MdCartQtyUpAction;
import action.MdCartRemoveAction;
import action.MdListAction;
import action.MdViewAction;

@WebFilter("*.md")
public class MdFrontControllerFilter implements Filter {

	public MdFrontControllerFilter() {

	}

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		// /project/boardWriteForm.bo
		String requestURI = request.getRequestURI();
		// /project
		String contextPath = request.getContextPath();
		//  /boardWriteForm.bo
		String command = requestURI.substring(contextPath.length());
		
		// �� Action ��ü ���� ������ �����ϰ� �ִ� �������̽�.
		// ��û�� ó���� �� �ش� ��û�� ó���� Action ��ü���� �ϳ��� �����ؼ�
		// �ش� ��ü�� Action �������̽��� ���۷��� ������ ������.
		Action action = null;

		ActionForward forward = null;
		
		if(command.equals("/mdList.md")) {
			action = new MdListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdView.md")) {
			action = new MdViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartAdd.md")) {
			action = new MdCartAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
		else if(command.equals("/mdCartList.md")) {
			action = new MdCartListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartRemove.md")){
			action = new MdCartRemoveAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartQtyUp.md")) {
			action = new MdCartQtyUpAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/mdCartQtyDown.md")) {
			action = new MdCartQtyDownAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward !=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}