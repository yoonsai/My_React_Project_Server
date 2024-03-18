package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.*;
import com.sist.web.entity.*;
@RestController
@CrossOrigin(origins = "*")
public class MusicRestController {
   @Autowired
   private MusicDAO dao;
   
   @GetMapping("/music/list")
   public List<Music> musicListData(){
	   List<Music> list=dao.musicListData();
	   for(Music vo:list)
	   {
		   String he=vo.getHeart().substring(1);
		   vo.setHeart(he);
	   }
	   return list;
   }
}