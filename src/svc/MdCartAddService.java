package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;
import vo.Md;
import dao.MdDAO;

// ���ο� ��ٱ��� �׸��� �߰��ϴ� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class MdCartAddService {

	// �Ķ���� ������ ���۵� id ���� ������ �ִ� ���� ��ǰ ������ ������ �޼ҵ带 ����.
	public Md getCartMd(int id) {
		Connection con = getConnection();
		MdDAO mdDAO = MdDAO.getInstance();
		mdDAO.setConnection(con);	
		Md md = mdDAO.selectMd(id);
		close(con);
		return md;
	}

	// ��ٱ��� �׸��� �߰��ϴ� ����� ������ �޼ҵ带 ����.
	public void addCart(HttpServletRequest request, Md cartMd) {
		// ��û�� �� Ŭ���̾�Ʈ�� ���� ��ü�� ����.
		HttpSession session = request.getSession();
		// ���� ���� ������ ����Ǿ� �ִ� ��ٱ��� ����� ����.
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		// ��û�� ���� ���� ������ ��ٱ��� ��� ��ü�� �������� ������, ��, ��ٱ��� ��û�� ó�� �����ϴ� ��쿡��
		// ��ٱ��� �׸��� ��ҷ� �߰��� ArrayList ��ü�� �����ؼ� �ش� ��ü�� ���� ������ �Ӽ����� ��������.
		if(cartList == null){
		   cartList = new ArrayList<Cart>();
		   session.setAttribute("cartList", cartList);
		}
		
		// ��û�� ���ؼ� �߰��Ǵ� ��ٱ��� �׸��� ��ٱ��� �׸� ��Ͽ� �̹� �����ϴ� �׸������� �Ǵ��ϴ� ������ ����.
		// isNewCart ������ �⺻ ���� true�� �����Ͽ� �⺻������ ��û���� ������ �׸��� ó������ �߰��Ǵ� ��ٱ��� �׸����� �����ǰ� ��.
		boolean isNewCart = true;
		
		// ���� �߰��� ��ٱ��� �׸��� ���� ��ٱ��� �׸� ���(cartList)�� �����ϴ����� �Ǵ��Ͽ�
		// ������ �����ϴ� ��ٱ��� �׸��̸� isNewCart ���� ���� false�� ������ �ְ� ���� ��ٱ��� �׸��� ������ �ϳ� ������Ŵ.
		for (int i = 0; i < cartList.size(); i++) {
			// �� ��ٱ��� �׸� �������� �ĺ��ڸ� name ������ ����ϱ� ������
			// ���� �߰��ϴ� ��ǰ(cartMd)�� name ���� ������ name ���� ������ �ִ� cart ��ü�� �����ϸ�
			// ���� �߰��Ϸ��� ��ǰ�� ��ٱ��� �׸��� �����Ѵٰ� �Ǵ�.
			if(cartMd.getItem().equals(cartList.get(i).getItem())){
				isNewCart = false;
				// ���� ��ٱ��Ͽ� ��� ���� ��ǰ�� ��ٱ��� �׸� ������ ������Ŵ.
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
				break;
			}
		}
		
		// ��ٱ��� ��� ��û�� �� ���� ��ǰ�� ��ٱ��� �׸����� �������� ������
		// ��ٱ��� �׸��� �����ϴ� cartList ��ü�� ���ο� Cart ��ü�� �����Ͽ� �߰�.
		if(isNewCart){
			Cart cart = new Cart();
			cart.setImage(cartMd.getImage());
			cart.setItem(cartMd.getItem());
			cart.setPrice(cartMd.getPrice());
			cart.setQty(1);
			cartList.add(cart);
		}
		
	}
	
}