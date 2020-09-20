package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;

// Action 클래스들의 규격을 정의한 Action 인터페이스.
public interface Action {
	
	// 각 요청을 처리하는 Action 클래스들이 공통적으로 구현해야 하는 execute 메서드를 정의.
	// 웹 요청을 처리하고 응답하기 위해 HttpServletRequest request와 HttpServletResponse response를 파라미터 변수로 처리.
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}