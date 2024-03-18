package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.MagazineDAO;
import com.sist.web.dao.MusicDAO;
import com.sist.web.entity.Magazine;
import com.sist.web.entity.Music;

@RestController
@CrossOrigin(origins="*")
public class MainRestController {
	@Autowired
	public MagazineDAO mdao;
	
	@Autowired
	public MusicDAO mDao;
	
	@GetMapping("/magazine/main_react")
	public List<Magazine> magazine_main(){
		return mdao.MagazineMainList();
	}
	
	@GetMapping("/music/main_react")
	public List<Music> music_main(){
		return mDao.musicMainList();
	}
	
	@GetMapping("/music/main2_react")
	public List<Music> music2_main(){
		System.out.println("dddddddddddd");
		return mDao.musicMainList2();
	}
}
