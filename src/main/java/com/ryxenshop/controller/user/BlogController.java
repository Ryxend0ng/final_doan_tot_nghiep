package com.ryxenshop.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ryxenshop.conf.GlobalConfig;
import com.ryxenshop.controller.BaseController;
import com.ryxenshop.dto.MappingModel;
import com.ryxenshop.entities.Blog;
import com.ryxenshop.service.BlogService;
import com.ryxenshop.service.CategoryBlogService;
import com.ryxenshop.valueObjects.UserRequest;

@Controller
@RequestMapping("/ryxen-shop/")
public class BlogController extends BaseController {

	@Autowired
	private CategoryBlogService categoryBlogService;

	@Autowired
	private BlogService blogService;

	@Autowired
	private GlobalConfig globalConfig;

	@Autowired
	private MappingModel mappingModel;

	@GetMapping("blog.html")
	public String index(final Model model) throws Exception {
		model.addAttribute("categoryBlogs", categoryBlogService.findByStatus(true));
		model.addAttribute("amountBlog", blogService.findByStatus(true).size());
		model.addAttribute("recentPosts", blogService.getRecentPost());
		return "user/blog/blog";
	}

	@GetMapping("all-blog")
	public ResponseEntity<Map<String, Object>> getAll(@RequestParam("keySearch") String keySearch,
			@RequestParam("currentPage") Integer currentPage, @RequestParam("idParent") Integer idCategory, Model model)
			throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		UserRequest userRequest = new UserRequest(currentPage, globalConfig.getSizeClientBlog(), keySearch, idCategory,
				true);
		Page<Blog> page = blogService.getListBlogByFilter(userRequest);
		result.put("listBlog", mappingModel.mappingModel(page.getContent()));
		result.put("currentPage", page.getNumber() + 1);
		result.put("totalPage", page.getTotalPages());
		result.put("searchKey", userRequest.getKeySearch());
		result.put("idCategory", userRequest.getIdParent());
		return ResponseEntity.ok(result);
	}

	@GetMapping("detail-blog")
	public ResponseEntity<Blog> detail(@RequestParam("idBlog") String idBlog) throws Exception {
		return ResponseEntity.ok(blogService.findById(idBlog));
	}
}
