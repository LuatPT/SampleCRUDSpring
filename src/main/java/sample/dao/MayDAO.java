package sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sample.beans.May;

public class MayDAO {
	JdbcTemplate template;
	//phai trung ten vs cau hinh spring-servlet.xml
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}  
	public List<May> getListMay(){
		String queryList = "select * from May";
		return template.query(queryList, new RowMapper<May>() {
			public May mapRow(ResultSet rs, int rowNum) throws SQLException {
				May may = new May();
				may.setMaMay(rs.getString(1));
				may.setViTri(rs.getString(2));
				may.setTrangThai(rs.getString(3));
				return may;
			}
			
		});
	}
	
	public List<May> searchMay(String maMay){
		String querySearch = "select * from May where MaMay like ?";
		return template.query(querySearch, new Object[] {"%"+maMay+"%"},new RowMapper<May>() {
			public May mapRow(ResultSet rs, int rowNum) throws SQLException {
				May may = new May();
				may.setMaMay(rs.getString(1));
				may.setViTri(rs.getString(2));
				may.setTrangThai(rs.getString(3));
				return may;
			}	
		});
	}
	
	public int luuMay(May m){    
	    String queryLuu = " Insert into May(MaMay, ViTri, TrangThai) values('"+m.getMaMay()+"', '"+m.getViTri()+"','"+m.getTrangThai()+"')";    
	    return template.update(queryLuu);    
	}    
	
	public int xoaMay(String maMay){    
	    String quertXoa="Delete from May where MaMay = '"+maMay+"'";    
	    return template.update(quertXoa);    
	}    
	
	public May getMayInfo(String maMay) {
		String getInfo = "Select * from May where maMay = ?";
		return template.queryForObject(getInfo, new Object[] {maMay}, new BeanPropertyRowMapper<May>(May.class));
	}
	
	 public int suaMay(May m){    
		String querySua="update May set ViTri='"+m.getViTri()+"',TrangThai='"+m.getTrangThai()+"' where MaMay='"+m.getMaMay()+"'";    
		return template.update(querySua);    
	}  
}
