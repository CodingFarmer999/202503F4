package com.course.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//@SqlResultSetMapping(
//	    name = "ProductDtoMapping",
//	    classes = @ConstructorResult(
//	        targetClass = ProductCustomDto.class,
//	        columns = {
//	            @ColumnResult(name = "NAME", type = String.class),
//	            @ColumnResult(name = "LIST_PRICE", type = BigDecimal.class),
//	            @ColumnResult(name = "SALES_PRICE", type = BigDecimal.class),
//	            @ColumnResult(name = "MEMO", type = String.class),
//	            @ColumnResult(name = "CNAME", type = String.class)
//	        }
//	    )
//	)
@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ_GENERATOR")
	@SequenceGenerator(name = "PRODUCT_SEQ_GENERATOR", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
	private Long id;
	
	@Column
	private String code;
	
	@Column
	private String name;
	
	// ProductPriceEntity 的 ProductEntity 欄位名稱
    @OneToOne(mappedBy = "product",  cascade = CascadeType.ALL, orphanRemoval = true)
    private ProductPriceEntity productPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductReviewEntity> reviews;
      
    @ManyToMany
    @JoinTable(
            name = "PRODUCT_CATEGORY", 
            joinColumns = @JoinColumn(name = "PRODUCT_ID"), 
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID")
        )
    private List<CategoryEntity> categoryList;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductPriceEntity getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(ProductPriceEntity productPrice) {
		this.productPrice = productPrice;
	}

	public List<ProductReviewEntity> getReviews() {
		return reviews;
	}

	public void setReviews(List<ProductReviewEntity> reviews) {
		this.reviews = reviews;
	}

	public List<CategoryEntity> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CategoryEntity> categoryList) {
		this.categoryList = categoryList;
	}
	
}
