package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.course.model.TodoVo;
import com.course.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<TodoVo> todoList= todoService.getAllTodoList();
		model.addAttribute("todoList", todoList);
		return "index";
	}
	
	@ModelAttribute("title")
	public String title() {
		return "<script>alert('XXXXXX')</script>";
	}
	
	@GetMapping("/toAddPage")
	public String toAddPage(@ModelAttribute("todo") TodoVo todoVo) {
		return "addTodo";
	}
	
	/**
	 * 新增待辦事項
	 * @param todoVo
	 * @return
	 */
	@PostMapping("/todo")
	public String add(@ModelAttribute("todo") TodoVo todoVo) {
		System.out.println(todoVo);

		todoService.addTodo(todoVo);


		// 新增完畢後，轉導至首頁，避免refresh重送新增
		return "redirect:/";
	}
	
	/**
	 * 刪除待辦事項
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public String deleteTodo(@PathVariable Long id) {
		todoService.deleteTodo(id);
		// 刪除完畢後，轉導至首頁，避免refresh重送新增
		return "redirect:/";
	}
	
	/**
	 * 轉導至編輯頁
	 * @param id
	 * @return
	 */
	@GetMapping("/toEditPage/{id}")
	public String toEditPage(@PathVariable Long id, Model model) {
		TodoVo vo = todoService.getTodoById(id);
		model.addAttribute("todo", vo);
		return "editTodo";
	}
	

	@PostMapping("/editTodo")
	public String editTodo(@ModelAttribute("todo") TodoVo todoVo) {
		System.out.println(todoVo);
		todoService.updateTodo(todoVo);
		return "redirect:/";
	}
}
