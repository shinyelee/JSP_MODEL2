package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;

// Action Ŭ�������� �԰��� ������ Action �������̽�.
public interface Action {
	
	// �� ��û�� ó���ϴ� Action Ŭ�������� ���������� �����ؾ� �ϴ� execute �޼��带 ����.
	// �� ��û�� ó���ϰ� �����ϱ� ���� HttpServletRequest request�� HttpServletResponse response�� �Ķ���� ������ ó��.
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}