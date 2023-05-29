package connect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Servlet implementation class AddEventThumbnail
 */
@MultipartConfig
public class AddEventThumbnail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEventThumbnail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
        int eventID = (int) session.getAttribute("eventID");
		String uploadPath = getServletContext().getRealPath("") + File.separator + "resources" + File.separator + eventID + File.separator;
		String fileName;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();
		System.out.println(uploadPath);
		for (Part part : request.getParts()) {
		    fileName = "thumb.jpg";
		    part.write(uploadPath + File.separator + fileName);
	          response.sendRedirect("index.jsp"); //error page 

		}
	}
	public boolean uploadFile(InputStream is, String path) {
		boolean test = false;
		try {
			byte[] byt = new byte[is.available()];
			is.read();
			FileOutputStream fops = new FileOutputStream(path);
			fops.write(byt);
			fops.flush();
			fops.close();
			
			test = true;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return test;
	}

}
