package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sist.web.entity.MagazineDetail;

public interface MagazinedetailDAO extends JpaRepository<MagazineDetail, Integer>{
	public MagazineDetail findByNo(int no);
}
