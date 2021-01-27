package action;

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import svc.MdRegistService;
import vo.ActionForward;
import vo.Md;
// ���� ���ε� ó���� ���� cos.jar ���̺귯������ �����Ǵ� ���ε���� Ŭ������ ����Ʈ.
import com.oreilly.servlet.MultipartRequest;
// �ش� ���̺귯���� ������Ʈ�� �߰��ؾ� �Ѵ�.
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// ���ο� �� ��ǰ ������ ����ϴ� Action Ŭ����.
public class MdRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ������ ���� �� ���ε� �� �� ���ε�� ������ ������ �����ͺ��̽��� �����ϴ� ����Ͻ� ������ �����Ǵ� Service Ŭ���� ��ü�� ����.
		MdRegistService MdRegistService = new MdRegistService();
		// ������ ���ε�� ���� ���� ���� ��θ� ������ ������ ����.
		String realFolder = "";
		// ������ ���ε�� ���丮 �̸��� ����.
		String saveFolder = "/images";
		// ���ε�Ǵ� ������ ���ڵ� Ÿ���� ����.
		String encType = "UTF-8";
		// �� ���� ��û�� ���ؼ� ���ε�� �� �ִ� ����Ʈ ���� ����(�ִ� 10MB�� ����).
		int maxSize = 10*1024*1024;
		
		// ������ ���ε�� �������� �������� ��θ� ����.
		ServletContext context = request.getServletContext();
		// ��, �� ���ø����̼� ��Ʈ�� image ���丮�� �������� ��θ� ����.
		realFolder = context.getRealPath(saveFolder);
		// MultipartRequest Ŭ������ �����ڸ� ����ؼ� ��û�� ���۵Ǿ�� ������ ���� �� ���ε�.
		// �����ڸ� ����ؼ� ��ü�� �����ϴ� ���� �ٷ� ���� �� ������ ���ε�ȴ�.
		// DefaultFileRenamePolicy Ŭ���� ��ü�� Ŭ���̾�Ʈ�� ���ε��ϴ� ���� �̸��� ������ �̸��� ������ �̹� ���� ���� ���ε� ���丮�� ������ ��
		// ���ε�Ǵ� ���� �̸��� �ڵ����� �����Ͽ� ���ε�ǰ� �ϴ� ����� ����.
		MultipartRequest multi = new MultipartRequest(request,
					realFolder, maxSize, encType,
					new DefaultFileRenamePolicy());
		// ���� �� ���ε�� ���� �̸��� ����.
		String image = multi.getFilesystemName("image");
		// Ŭ���̾�Ʈ���� ���۵� �Ķ���� �����͵��� ����ؼ� ���� ��ϵ� ��ǰ ������ �����ϴ� Md ��ü�� ����.
		Md md = new Md(
				0, 
				multi.getParameter("item"), 
				Integer.parseInt(multi.getParameter("price")), 
				image, 
				multi.getParameter("cate1"), 
				multi.getParameter("cate2"), 
				multi.getParameter("cate3"), 
				multi.getParameter("content"), 
				0);
		// ��ǰ ��� ����Ͻ� ������ ó���ϴ� registMd �޼ҵ带 ȣ��.
		boolean isRegistSuccess = MdRegistService.registMd(md);
		// ���������� �޼��忡�� ��ȯ�ؾߵǴ� ActionForward ��ü�� Ŭ���� ������ ����.
		ActionForward forward = null;
		
		// ��ǰ ��� �۾��� ���������� ó���Ǿ����� �����̷�Ʈ ������� ��ǰ ��Ϻ��� ��û�� �ϵ��� ��.
		// ���⼭ �����ؼ� ��ȯ�ϴ� forward ��ü�� MdFrontController ������ forward = action.execute(request, response);
		// �κ����� ��ȯ�Ǿ� �ش� ������ ����Ͽ� ������ ó���ȴ�.
		if(isRegistSuccess) {
			forward = new ActionForward("mdList.md", true);
		// ��ǰ ��� �۾��� ���еǾ��� ��� �ڹٽ�ũ��Ʈ�� ����ؼ� "��� ����" ���ڿ��� ���â���� ���� ���� URL, �� ��ǰ ��� �������� �ǵ��ư��� ó��.
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��Ͻ���');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}