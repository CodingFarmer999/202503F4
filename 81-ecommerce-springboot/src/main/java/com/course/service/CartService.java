package com.course.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.entity.OrderEntity;
import com.course.model.entity.OrderItemEntity;
import com.course.model.entity.ProductEntity;
import com.course.model.session.CartSession;
import com.course.model.session.UserSession;
import com.course.model.vo.CartVo;
import com.course.model.vo.ProductItem;
import com.course.model.vo.ProductVo;
import com.course.model.vo.ShippingMethod;
import com.course.repository.OrderItemRepository;
import com.course.repository.OrderRepository;
import com.course.repository.ProductRepository;
import com.course.utils.EcUtils;

@Service
public class CartService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	/** Session 當中的購物車 */
	@Autowired
	private CartSession cartSession;
	
	/** Session 當中的使用者 */
	@Autowired
	private UserSession userSession;

	@Autowired
	private EcUtils utils;
	
	/**
	 * 將商品加入購物車
	 * @param code
	 */
	public void addProductToCart(String code) {
		ProductEntity product = productRepo.findByCode(code);
		if (product != null) {
			if (cartSession == null) {
				// 防呆，如果購物車為null，建立一個新的購物車
				cartSession = new CartSession();
			}
			ProductVo productVo = utils.convertToVo(product);
			cartSession.getProductVoList().add(productVo);	
		}
	}
	
	/**
	 * 取得購物車
	 * @return
	 */
	public CartVo getCart() {
		CartVo cartVo = new CartVo();
		List<ProductVo> productVoList = cartSession.getProductVoList();
				
	    // 對 ProductVo 進行分組並累加數量
	    Map<ProductVo, Integer> productMap = productVoList.stream()
	        .collect(Collectors.groupingBy(vo -> vo, Collectors.summingInt(vo -> 1)));
		
	    // 將每個產品轉換為 ProductItem 並計算小計金額
	    List<ProductItem> productItemList = productMap.entrySet().stream()
	        .map(entry -> {
	            ProductVo productVo = entry.getKey();
	            Integer quantity = entry.getValue();
	            BigDecimal subAmount = productVo.getSalesPrice().multiply(new BigDecimal(quantity));
	            return new ProductItem(productVo, quantity, subAmount);
	        })
	        .collect(Collectors.toList());
		
	    BigDecimal totalAmount = productItemList.stream().map(ProductItem::getSubAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
	    
	    cartVo.setTotalAmount(totalAmount);
		cartVo.setItemList(productItemList);
		return cartVo;
	}
	
	/**
	 * 從購物車移除商品，並回傳新的購物車
	 * @param code
	 * @return
	 */
	public CartVo removeProductFromCart(String code) {
		List<ProductVo> productList = cartSession.getProductVoList();
		ProductVo product = productList.stream().filter(p -> p.getCode().equals(code)).findFirst().orElse(null);
		if (product != null) {
			productList.remove(product);
		}
		cartSession.setProductVoList(productList);
		return getCart();
	}
	
	public void checkoutConfirm(ShippingMethod shippingMethod) {
		// TODO: 檢查使用者是否登入

		CartVo cart = getCart();
		cart.setShippingMethod(shippingMethod);
		
		// 產生訂單
		OrderEntity order = utils.genOrderEntity(cart, userSession.getId());
		orderRepo.save(order);
		
		List<OrderItemEntity> orderItemEntityList = new ArrayList<>();
		List<ProductItem> productItemList = cart.getItemList();
		// 產生 OrderItem
		for (ProductItem item : productItemList) {
			// 每樣商品需要紀錄一筆 OrderItem
			OrderItemEntity itemEntity = new OrderItemEntity();
			itemEntity.setOrderId(order.getId());
			itemEntity.setProductId(item.getProduct().getId());
			itemEntity.setQuantity(item.getQuantity());
			itemEntity.setPrice(item.getSubAmount());
			orderItemEntityList.add(itemEntity);
		}
		orderItemRepo.saveAll(orderItemEntityList);
		
	}
	

}
