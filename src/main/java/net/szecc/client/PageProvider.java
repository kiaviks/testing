package net.szecc.client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageProvider {
	
	private static Logger LOG = Logger.getLogger(PageProvider.class);
	
	@RequestMapping(value="/pages/private/{view}")
	public String privateView(
			@PathVariable("view") String view,
			HttpServletRequest req,
			HttpServletResponse res,
			HttpSession sess
			) {
		LOG.info("returning private view:" + view);
		return view;
	}
	
	@RequestMapping(value="/pages/{view}")
	public String publicView(
			@PathVariable("view") String view,
			HttpServletRequest req,
			HttpServletResponse res,
			HttpSession sess
			) {
		LOG.info("returning public view:" + view);
		return view;
	}

}
