package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.dao.AnswerDao;
import next.model.Answer;
import core.mvc.Controller;
import core.mvc.FrontController;

public class AddanswerController implements Controller {
	public AnswerDao answerDao = new AnswerDao();
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Answer answer = new Answer(
				request.getParameter("writer"), 
				request.getParameter("contents"), 
				Long.parseLong(request.getParameter("questionId"))
		);
		answerDao.insert(answer);
		return "api";
	}
}
