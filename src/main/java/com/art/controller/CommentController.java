package com.art.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.art.comment.dto.CommentDto;
import com.art.comment.service.CommentService;

@Controller
@RequestMapping("/comment/*")
public class CommentController extends BaseController{
	
	@Resource
	private CommentService commentService;
	
	@ResponseBody
	@RequestMapping("{id}")
	public List<CommentDto> index(@PathVariable("id") Long id){
		return commentService.getCommentById(id);
	}
	
	@ResponseBody
	@RequestMapping("addcomment")
	public int addComment(@RequestParam("comment") String commentStr,@RequestParam("id") Long id){
		return commentService.addComment(commentStr,id,getSessionUser());
	}
}
