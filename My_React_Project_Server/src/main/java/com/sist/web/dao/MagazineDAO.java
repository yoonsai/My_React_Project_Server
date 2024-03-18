package com.sist.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sist.web.entity.Magazine;
import com.sist.web.entity.MagazineDetail;

public interface MagazineDAO extends JpaRepository<Magazine, Integer>{
	@Query(value="SELECT * FROM magazine "
			+ "WHERE title LIKE CONCAT('%',:title,'%') "
			+ "ORDER BY no ASC "
			+ "LIMIT :start,12",nativeQuery = true)
	public List<Magazine> MagazineList(@Param("start") Integer start,@Param("title") String title);
	
	@Query(value="SELECT CEIL(COUNT(*)/12.0) FROM magazine "
			 +"WHERE title LIKE CONCAT('%',:title,'%')",nativeQuery = true)
	   public int MagazineTotalPage(@Param("title") String title);
	
	public Magazine findByNo(int no);
	
	@Query(value="SELECT * FROM magazine "
			+ "ORDER BY no DESC "
			+ "LIMIT 0,8",nativeQuery = true)
	public List<Magazine> MagazineMainList();
}
