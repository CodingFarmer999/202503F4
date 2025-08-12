package com.course.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.course.dao.TodoDao;
import com.course.model.SearchCondition;
import com.course.model.TodoDto;
import com.course.model.TodoVo;

@Service
public class TodoService {

	private static final String UPLOAD_DIR = "/Users/yaochilee/static/images";
	
	@Autowired
	private TodoDao todoDao;
	
	@Autowired
	private TodoServiceHelper helper;
	
	/**
	 * 取得所有待辦事項
	 * @return
	 */
	public List<TodoVo> getAllTodoList() {
		List<TodoDto> dtoList = todoDao.findAll();
		// 將 DTO 轉換成 VO
		return dtoList.stream().map(dto -> helper.convertToVo(dto)).collect(Collectors.toList());
	}
	
	/**
	 * 新增待辦事項
	 * @param todoVo
	 */
	public void addTodo(TodoVo todoVo) {
		// 新增代辦事項，狀態固定為0(未完成)
		todoVo.setStatus("0");
		
		// 轉換 Vo -> Dto
		TodoDto dto = helper.convertToDto(todoVo);
		todoDao.add(dto);
		
		
		try {
			saveImage(todoVo.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 刪除待辦事項
	 * @param id
	 */
	public void deleteTodo(Long id) {
		todoDao.delete(id);
	}
	
	/**
	 * 更新待辦事項
	 * @param todoVo
	 */
	public void updateTodo(TodoVo todoVo) {
		TodoDto dto = helper.convertToDto(todoVo);
		todoDao.update(dto);
	}

	/**
	 * 透過 ID 搜尋
	 * @param id
	 * @return
	 */
	public TodoVo getTodoById(Long id) {
		TodoDto dto = todoDao.findById(id);
		return helper.convertToVo(dto);
	}
	
	public List<TodoVo> searchByCondition(SearchCondition condition) {
		List<TodoDto> dtoList = todoDao.findByCondition(condition);
		return dtoList.stream().map(dto -> helper.convertToVo(dto)).collect(Collectors.toList());
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
