package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;

public interface Action {
	ActionForward execute(HttpServletRequest request, // 각 요청을 처리하는 Action 클래스들이 공통적으로 구현해야 하는 execute 메서드를 정의.
	HttpServletResponse response) throws Exception; // 웹 요청을 처리하고 응답하기 위해 HttpServletRequest request와 HttpServletResponse response를 파라미터 변수로 처리.
}
