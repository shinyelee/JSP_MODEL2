package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;
import vo.Goods;
import dao.GoodsDAO;

// ���ο� ��ٱ��� �׸��� �߰��ϴ� ��û�� ó���ϴ� ����Ͻ� ������ �����ϴ� Service Ŭ����.
public class GoodsCartAddService {

	// �Ķ���� ������ ���۵� id ���� ������ �ִ� ���� ��ǰ ������ ������ �޼ҵ带 ����.
	public Goods getCartGoods(int id) {
		Connection con = getConnection();
		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(con);	
		Goods goods = goodsDAO.selectGoods(id);
		close(con);
		return goods;
	}

	// ��ٱ��� �׸��� �߰��ϴ� ����� ������ �޼ҵ带 ����.
	public void addCart(HttpServletRequest request, Goods cartGoods) {
		HttpSession session = request.getSession(); // ��û�� �� Ŭ���̾�Ʈ�� ���� ��ü�� ����.
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
			// ���� �߰��ϴ� ��ǰ(cartGoods)�� name ���� ������ name ���� ������ �ִ� cart ��ü�� �����ϸ�
			// ���� �߰��Ϸ��� ��ǰ�� ��ٱ��� �׸��� �����Ѵٰ� �Ǵ�.
			if(cartGoods.getName().equals(cartList.get(i).getName())){
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
			cart.setImage(cartGoods.getImage());
			cart.setName(cartGoods.getName());
			cart.setPrice(cartGoods.getPrice());
			cart.setQty(1);
			cartList.add(cart);
		}
		
	}
	
}