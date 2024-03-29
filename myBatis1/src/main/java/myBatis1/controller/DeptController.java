package myBatis1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myBatis1.model.Dept;
import myBatis1.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	private DeptService ds;

	// 부서 목록 요청
	@RequestMapping("deptList.do")
	public String list(Model model) {
		List<Dept> list = ds.list();
		model.addAttribute("list", list);
		return "deptList";
	}

	// 부서 상세정보
	@RequestMapping("deptView.do")
	public String deptView(@RequestParam("deptno") int deptno, Model model) {
		Dept dept = ds.select(deptno);
		model.addAttribute("dept", dept);
		return "deptView";
	}

	@RequestMapping("deptUpdateForm.do")
	public String deptUpdateForm(int deptno, Model model) {
		Dept dept = ds.select(deptno);
		model.addAttribute("dept", dept);
		return "deptUpdateForm";
	}

	@RequestMapping("deptUpdate.do")
	public String deptUpdate(Dept dept, Model model) {
		int result = ds.update(dept);
		model.addAttribute("result", result);
		return "deptUpdate";
	}

	@RequestMapping("deptDelete.do")
	public String deptDelete(int deptno, Model model) {
		int result = ds.delete(deptno);
		model.addAttribute("result", result);
		return "deptDelete";
	}
}