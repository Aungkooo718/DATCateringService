package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BookBean;
import Persistant.DAO.bookDAO;
import Persistant.DTO.BookRequestDTO;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
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
		// TODO Auto-generated method stub
		BookBean bean = new BookBean();
		bean.setBookCode(request.getParameter("bCode"));
		bean.setBookTitle(request.getParameter("bTitle"));
		bean.setBookAuthor(request.getParameter("bAuthor"));
		bean.setBookPrice(request.getParameter("bPrice"));
		if( bean.getBookCode().equals("") || bean.getBookTitle().equals("") || bean.getBookAuthor().equals("") || bean.getBookPrice().equals("") )
		{
			request.setAttribute("Error", "Field cannot be blank!");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("AddBook.jsp").forward(request, response);
		}else
		{
			bookDAO dao = new bookDAO();
			BookRequestDTO dto = new BookRequestDTO();
			dto.setBookCode(bean.getBookCode());
			dto.setBookTitle(bean.getBookTitle());
			dto.setBookAuthor(bean.getBookAuthor());
			dto.setBookPrice(Double.valueOf(bean.getBookPrice()));
			int result =  dao.insertData(dto);
			if( result > 0)
			{
			response.sendRedirect("ViewServlet");
			}else
			{
				request.setAttribute("Error", "Insert Failed!!");
				request.getRequestDispatcher("AddBook.jsp").forward(request, response);
			}
		}
	}

}
