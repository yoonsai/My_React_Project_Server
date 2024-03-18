package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.MagazineDAO;
import com.sist.web.dao.MagazinedetailDAO;
import com.sist.web.entity.Magazine;
import com.sist.web.entity.MagazineDetail;

@RestController
@CrossOrigin(origins="*")
public class MagazineRestController {
	@Autowired
	private MagazineDAO dao;
	
	@Autowired
	private MagazinedetailDAO mdao;
	@PostMapping("/magazine/list_react")
	public Map magazine_list(int page,String title)
	{
		   int rowSize=12;
		   if(title==null || title==" ")
		   {
			   title="";
		   }
		   int start=(rowSize*page)-rowSize;
		   List<Magazine> list=dao.MagazineList(start,title);
		   Map map=new HashMap();
		   int count=(int)dao.count();
		   int totalpage=dao.MagazineTotalPage(title);
		   final int BLOCK=5;
		   int startPage=((page-1)/BLOCK*BLOCK)+1;
		   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		   if(endPage>totalpage)
			   endPage=totalpage;
		   
		   map.put("curpage",page);
		   map.put("totalpage",totalpage);
		   map.put("startPage",startPage);
		   map.put("endPage", endPage);
		   map.put("list", list);
		   return map;
	}
	
	@GetMapping("/magazine/detail_react")
	public Map magazine_detail(int no)
	{
		
		MagazineDetail mdvo=mdao.findByNo(no);
		Magazine vo=dao.findByNo(no);
		Map map=new HashMap();
		map.put("vo",vo);
		map.put("mdvo",mdvo);
		return map;
		
	}
}
