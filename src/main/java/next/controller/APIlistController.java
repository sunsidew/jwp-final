package next.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import next.dao.QuestionDao;
import next.model.Question;
import core.mvc.Controller;
import core.mvc.FrontController;

public class APIlistController implements Controller {
	private QuestionDao questionDao = new QuestionDao();
	private List<Question> questions;
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		questions = questionDao.findAll();
		Gson gson = new Gson();
		request.setAttribute("json", gson.toJson(questions));
		
		return "json.jsp";
	}
}
