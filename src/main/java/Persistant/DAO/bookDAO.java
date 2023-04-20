package Persistant.DAO;

import java.io.IOException;
import java.io.Reader;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Persistant.DTO.BookRequestDTO;
import Persistant.DTO.BookResponseDTO;


public class bookDAO 
{
	static SqlSession session=null;
	static {
	try {
	Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
	SqlSessionFactory sqlSessionFactory = new
	SqlSessionFactoryBuilder().build(reader);
	session = sqlSessionFactory.openSession();
	} catch (IOException e) {
	e.printStackTrace();
	}
	}
	public int insertData(BookRequestDTO dto) 
	{
		int result=0;
		result=session.insert("book.insert",dto);
		return result;
	}
	public int updateData(BookRequestDTO dto) 
	{
		int result=0;
		result=session.update("book.update",dto);
		return result;
	}
	public int deleteData(BookRequestDTO dto) 
	{
		int result=0;
		result=session.delete("book.delete",dto.getBookCode());
		return result;
	}
	public BookResponseDTO selectOne (BookRequestDTO dto) 
	{
		BookResponseDTO res=new BookResponseDTO();
		res=session.selectOne("book.getByCode",dto.getBookCode());
		return res;
	}
	public List<BookResponseDTO> selectAll () 
	{
		List<BookResponseDTO> list=session.selectList("book.getAll");
		return list;
	}

}
