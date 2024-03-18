package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity(name="chart")
@Getter
@Setter
@NoArgsConstructor
public class Music {
	  @Id
	  private int no;
	  private int idcrement;
	  private String title,singer,album,poster,state,hit,hit2,heart;
}