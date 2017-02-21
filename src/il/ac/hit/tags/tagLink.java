package il.ac.hit.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 
 * @author 89leo
 * This class is bonus: example of tags
 */

public class tagLink extends SimpleTagSupport {

		private String youtubeLINK;

		public String getYoutubeLINK() {
			return youtubeLINK;
		}

		public void setYoutubeLINK(String youtubeLINK) {
			this.youtubeLINK = youtubeLINK;
		}

		public void doTag() throws JspException, IOException {
			JspWriter write = getJspContext().getOut();
			write.print("<br>");
			write.print("  <iframe width="+"360 "+ "height="+"215 " +"src="+"https://www.youtube.com/embed/"+youtubeLINK+" frameborder="+"0 " +"allowfullscreen></iframe>");		
		}
		
	}
