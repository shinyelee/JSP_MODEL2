package action;

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodsRegistService;
import vo.ActionForward;
import vo.Goods;
import com.oreilly.servlet.MultipartRequest; // ���� ���ε� ó���� ���� cos.jar ���̺귯������ �����Ǵ� ���ε���� Ŭ������ ����Ʈ.
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy; // �ش� ���̺귯���� ������Ʈ�� �߰��ؾ� �Ѵ�.

public class GoodsRegistAction implements Action {
	
	// ���ο� �� ��ǰ ������ ����ϴ� Action Ŭ����.
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ������ ���� �� ���ε� �� �� ���ε�� ������ ������ �����ͺ��̽��� �����ϴ� ����Ͻ� ������ �����Ǵ� Service Ŭ���� ��ü�� ����.
		GoodsRegistService GoodsRegistService = new GoodsRegistService();
		String realFolder = ""; // ������ ���ε�� ���� ���� ���� ��θ� ������ ������ ����.
		String saveFolder = "/images"; // ������ ���ε�� ���丮 �̸��� ����.
		String encType = "UTF-8"; // ���ε�Ǵ� ������ ���ڵ� Ÿ���� ����.
		int maxSize = 5 * 1024 * 1024; // �� ���� ��û�� ���ؼ� ���ε�� �� �ִ� ����Ʈ ���� ����(�ִ� 5MB�� ����).
		
		ServletContext context = request.getServletContext(); // ������ ���ε�� �������� �������� ��θ� ����.
		realFolder = context.getRealPath(saveFolder); // ��, �� ���ø����̼� ��Ʈ�� image ���丮�� �������� ��θ� ����.
		// MultipartRequest Ŭ������ �����ڸ� ����ؼ� ��û�� ���۵Ǿ�� ������ ���� �� ���ε�.
		// �����ڸ� ����ؼ� ��ü�� �����ϴ� ���� �ٷ� ���� �� ������ ���ε�ȴ�.
		// DefaultFileRenamePolicy Ŭ���� ��ü�� Ŭ���̾�Ʈ�� ���ε��ϴ� ���� �̸��� ������ �̸��� ������ �̹� ���� ���� ���ε� ���丮�� ������ ��
		// ���ε�Ǵ� ���� �̸��� �ڵ����� �����Ͽ� ���ε�ǰ� �ϴ� ����� ����.
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("image"); // ���� �� ���ε�� ���� �̸��� ����.
		// Ŭ���̾�Ʈ���� ���۵� �Ķ���� �����͵��� ����ؼ� ���� ��ϵ� ���� ������ �����ϴ� Goods ��ü�� ����.
		Goods goods = new Goods(0, multi.getParameter("name"), Integer.parseInt(multi.getParameter("price")), image,
					  multi.getParameter("category"), multi.getParameter("category2"),
					  Integer.parseInt(multi.getParameter("version")), multi.getParameter("content"), 0);
		boolean isRegistSuccess = GoodsRegistService.registGoods(goods); // ���� ��ǰ ��� ����Ͻ� ������ ó���ϴ� registGoods �޼ҵ带 ȣ��.
		ActionForward forward = null; // ���������� �޼��忡�� ��ȯ�ؾߵǴ� ActionForward ��ü�� Ŭ���� ������ ����.
		
		// ���� ��ǰ ��� �۾��� ���������� ó���Ǿ����� �����̷�Ʈ ������� ���� ��Ϻ��� ��û�� �ϵ��� ��.
		// ���⼭ �����ؼ� ��ȯ�ϴ� forward ��ü�� GoodsFrontController ������ forward = action.execute(request, response); �κ����� ��ȯ�Ǿ�
		// �ش� ������ ����Ͽ� ������ ó���ȴ�.
		if (isRegistSuccess) {
			forward = new ActionForward("goodsList.go", true);
		// ���� ��ǰ ��� �۾��� ���еǾ��� ��� �ڹٽ�ũ��Ʈ�� ����ؼ� "��� ����" ���ڿ��� ���â���� ���� ���� URL, �� ���� ��ǰ ��� �������� �ǵ��ư��� ó��.
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