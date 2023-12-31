package com.ryxenshop.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryxenshop.controller.BaseController;
import com.ryxenshop.dto.MappingModel;
import com.ryxenshop.entities.Category;
import com.ryxenshop.service.CategoryService;

@Controller
@RequestMapping("/ryxen-shop/")
public class CategoryController extends BaseController {
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private MappingModel mappingModel;

	@GetMapping("category-slide-home")
	public ResponseEntity<List<JSONObject>> getAllSlide() throws Exception {

		List<Category> categories = categoryService.getCategorySlider();
		List<JSONObject> listCategory = new ArrayList<>();
		for (Category category : categories) {
			listCategory.add(mappingModel.mappingModel(category));
		}
		return ResponseEntity.ok(listCategory);
	}

	/*
	 * @RequestMapping(value = { "/all-category-active" }, method =
	 * RequestMethod.GET) public ResponseEntity<List<JSONObject>> getAllActive(final
	 * Model model, final HttpServletRequest request, final HttpServletResponse
	 * response) throws IOException {
	 * 
	 * List<Category> categories = categoryService.findAllActive(); List<JSONObject>
	 * listCategory = new ArrayList<>(); for (Category category : categories) {
	 * listCategory.add(mappingModel.mappingModel(category)); } return
	 * ResponseEntity.ok(listCategory); }
	 */
}
