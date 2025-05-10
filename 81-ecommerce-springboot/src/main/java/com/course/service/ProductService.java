package com.course.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.course.model.entity.ProductEntity;
import com.course.model.vo.ProductVo;
import com.course.repository.ProductRepository;

@Service
public class ProductService {

	private static final String UPLOAD_DIR = "/Users/student/static/images/";
	
	@Autowired
	private ProductRepository productRepo;
	
	public Page<ProductVo> getProductsPage(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<ProductEntity> pagedResult = productRepo.findAll(pageable);
		Page<ProductVo> infoPage = pagedResult.map(entity -> convertToVo(entity));
		return infoPage;
	}
	
	public List<ProductVo> getAllProduct() {
		List<ProductEntity> entityList = productRepo.findAll();
		return entityList.stream().map(entity -> convertToVo(entity)).collect(Collectors.toList());
	}
	
	/**
	 * 新增/修改商品
	 * @param productVo
	 * @throws IOException 
	 */
	public ProductVo updateProduct(ProductVo productVo) throws IOException {
	
		String code = productVo.getCode();
		ProductEntity entity = productRepo.findByCode(code);
		
		if (entity == null) {
			// 商品不存在，新增商品
			entity = new ProductEntity();
		}
		
		entity.setName(productVo.getName());
		entity.setCode(productVo.getCode());
		entity.setListPrice(productVo.getListPrice());
		entity.setSalesPrice(productVo.getSalesPrice());
		entity.setDescript(productVo.getDescript());
		entity.setOnline(productVo.getOnline());
		entity.setQuantity(productVo.getQuantity());
		entity.setImageName(productVo.getUploadFile().getOriginalFilename());
		// 寫入圖檔
		saveImage(productVo.getUploadFile());
		
		// 存入DB
		productRepo.save(entity);
		
		return convertToVo(entity);
		
	}
	
	/**
	 * 將 Entity 轉換 成 Vo
	 * @param entity
	 * @return
	 */
	private ProductVo convertToVo(ProductEntity entity) {
		ProductVo vo = new ProductVo();
		vo.setCode(entity.getCode());
		vo.setName(entity.getName());
		vo.setListPrice(entity.getListPrice());
		vo.setSalesPrice(entity.getSalesPrice());
		vo.setQuantity(entity.getQuantity());
		vo.setImageUrl("http://localhost:8085/images/" + entity.getImageName());
		vo.setImageName(entity.getImageName());
		return vo;
	}
	
	/**
	 * 寫入圖檔
	 * @param file
	 * @throws IOException
	 */
	private void saveImage(MultipartFile file) throws IOException {
		// 確保上傳目錄存在
		Path uploadPath = Paths.get(UPLOAD_DIR);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		// 保存檔案
		Path filePath = uploadPath.resolve(file.getOriginalFilename());
		// 如果檔案已經存在，直接覆蓋舊檔
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	}
}
