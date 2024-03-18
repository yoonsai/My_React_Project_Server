package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="magazinedetail")
@Data
public class MagazineDetail {
	@Id
	private int no;
	private String poster,title,content;
}
