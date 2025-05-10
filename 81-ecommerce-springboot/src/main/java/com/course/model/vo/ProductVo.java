package com.course.model.vo;

import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.web.multipart.MultipartFile;

public class ProductVo {

	/** 鍵值 */
	private Long id;
	
	/** 產品代碼 */
	private String code;
	
	/** 商品名稱 */
	private String name;
	
	/** 商品售價 */
	private BigDecimal listPrice;
	
	/** 商品特價 */
	private BigDecimal salesPrice;
	
	/** 圖檔名稱 */
	private String imageName;
	
	/** 庫存數量 */
	private Integer quantity;
	
	/** 商品描述 */
	private String descript;
	
	/** 上下架 */
	private Integer online;
	
	/** 圖檔連結 */
	private String imageUrl;
	
	/** 圖檔 */
	private MultipartFile uploadFile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Integer getOnline() {
		return online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductVo other = (ProductVo) obj;
		return Objects.equals(code, other.code);
	}
	
}
