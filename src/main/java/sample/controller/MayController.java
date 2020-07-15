package sample.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sample.beans.May;
import sample.dao.MayDAO;
@Controller
public class MayController {
	@Autowired
	MayDAO mayDAO;
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
		return "redirect:/";
	}
	//phai trung ten vs cau hinh spring-servlet.xml
	@RequestMapping("/xemMay")
	public String xemMay(Model m) throws IOException {
//		Document doc = Jsoup.connect("https://xoso.com.vn/xsmb-01-03-2020.html").timeout(10000).validateTLSCertificates(false).get();
//		Element e = doc.getElementById("mb_prizeDB_item0");
//		String songuoinhiem = e.text();
//		System.out.println("so nguoi nhiem : " + songuoinhiem);
		List<May> list = mayDAO.getListMay();
		m.addAttribute("listMay", list);
		return "xemMay";
	}
	@RequestMapping("/timMay")
	public String timMay(@RequestParam(value = "maMay1") String maMay1, Model m) {
		List<May> list = mayDAO.searchMay(maMay1);
		m.addAttribute("listMay", list);
		return "xemMay";
	}
	
	@RequestMapping("/themMay")
	public String themMay(Model m) {
		m.addAttribute("temp", new May());  //dung temp de luu tru du lieu
		return "themMay";
	}
	
	@RequestMapping(value = "/luuMay", method = RequestMethod.POST)
	public String luuMay(@ModelAttribute("may") May may) {
		mayDAO.luuMay(may);
		return "redirect:/xemMay";
	}
	
	@RequestMapping(value="/xoaMay/{maMay}",method = RequestMethod.GET)    
    public String xoaMay(@PathVariable String maMay){    
        mayDAO.xoaMay(maMay);    
        return "redirect:/xemMay";    
    }     
	
	 @RequestMapping(value="/xemSuaMay/{maMay}")    
	 public String xemSuaMay(@PathVariable String maMay, Model m){    
	    May may = mayDAO.getMayInfo(maMay);    
	    m.addAttribute("temp",may);  
	    return "suaMay";    
	 }    
	 
	  @RequestMapping(value="/suaMay",method = RequestMethod.POST)    
	    public String suaMay(@ModelAttribute("may") May may){    
	        mayDAO.suaMay(may); 
	        return "redirect:/xemMay";    
	    }      
}
