package learning.edtex.bootjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


//entity , Id are used. Now SB takes care of creating a table alien in DB
@Entity
public class Alien {
	@Id
	private int aid;
	private String aname;
	private String lang;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", lang=" +lang + "]";
	}
	
}
