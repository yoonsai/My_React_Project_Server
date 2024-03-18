package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sist.web.entity.Music;
import java.util.*;
public interface MusicDAO extends JpaRepository<Music, Integer>{
   @Query(value="SELECT * FROM chart ORDER BY no ASC",nativeQuery = true)
   public List<Music> musicListData();
   
   @Query(value="SELECT * FROM chart ORDER BY heart DESC LIMIT 0,6",nativeQuery = true)
   public List<Music> musicMainList();
   
   @Query(value="SELECT * FROM chart ORDER BY hit2 DESC LIMIT 0,7",nativeQuery = true)
   public List<Music> musicMainList2();
   
   
}