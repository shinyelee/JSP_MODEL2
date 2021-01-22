package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodsCartAddService;
import vo.ActionForward;
import vo.Goods;

// 장바구니 담기 요청을 처리하는 Action 클래스.
public class GoodsCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		GoodsCartAddService goodsCartAddService = new GoodsCartAddService(); // 장바구니 항목을 추가하는 비즈니스 로직을 처리하는 서비스 객체를 생성.
		int id = Integer.parseInt(request.getParameter("id")); // 장바구니 항목으로 추가될 굿즈 상품의 아이디를 파라미터 값으로 얻어옴.
		Goods cartGoods = goodsCartAddService.getCartGoods(id); // 장바구니 항목으로 추가될 굿즈 상품 정보를 얻어옴.
		// 특정 굿즈 상품을 장바구니 항목으로 추가하는 메소드를 호출. 세션 영역 객체에 장바구니 항목을 추가해야 하기 때문에 파라미터 값으로 request 객체를 던진다.
		goodsCartAddService.addCart(request,cartGoods);
		// 세션 객체를 얻어올 때 request.getSession() 메소드를 호출해서 얻어옴. 포워딩에 사용되는 정보를 ActionForward 객체로 생성.
		// 장바구니 항목을 추가한 후 장바구니 목록보기 요청을 다시 하기 위해서 url을 goodsCartList.go로 지정,
		// 리다이렉트 방식으로 포워딩 처리를 하기 위해서 redirect 속성 값을 true로 지정.
		ActionForward forward = new ActionForward("goodsCartList.go", true);
		return forward;
	}

}