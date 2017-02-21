package il.ac.hit;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Rest bonus implementation 
 *  //   /rest/rest
 * @author 89leo
 *
 */

@Path("/rest")
public class RestfullClass {

	@GET
	  @Produces(MediaType.TEXT_PLAIN)

		public String getClichedMessage() {
			
			return "Rest Class bonus";
	}
}
	

