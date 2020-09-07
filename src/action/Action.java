package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;

public interface Action {
	ActionForward execute(HttpServletRequest request, // �� ��û�� ó���ϴ� Action Ŭ�������� ���������� �����ؾ� �ϴ� execute �޼��带 ����.
	HttpServletResponse response) throws Exception; // �� ��û�� ó���ϰ� �����ϱ� ���� HttpServletRequest request�� HttpServletResponse response�� �Ķ���� ������ ó��.
}
