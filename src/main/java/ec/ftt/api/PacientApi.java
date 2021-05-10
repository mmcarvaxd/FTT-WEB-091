package ec.ftt.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ec.ftt.dao.PacientDao;
import ec.ftt.dao.UserDao;
import ec.ftt.model.Pacient;
import ec.ftt.model.User;

/**
 * Servlet implementation class PacientApi
 */
@WebServlet("/pacient")
public class PacientApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PacientApi() {
		super();
	}

	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setAccessControlHeaders(resp);
		resp.setStatus(HttpServletResponse.SC_OK);
	}

	private void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET");
		resp.setHeader("Access-Control-Allow-Methods", "POST");
		resp.setHeader("Access-Control-Allow-Methods", "PUT");
		resp.setHeader("Access-Control-Allow-Methods", "DELETE");
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setAccessControlHeaders(response);
		String pacientId = request.getParameter("pacient-id");
		if (pacientId != null) {
			int id = Integer.valueOf(pacientId);

			PacientDao pacientDao = new PacientDao();

			Pacient pacient = pacientDao.getPacientById(id);
			Gson gson = new Gson();
			response.getWriter().append(gson.toJson(pacient));

			return;
		}

		PacientDao pacientDao = new PacientDao();

		List<Pacient> pacientList = pacientDao.getAllPacient();

		Gson gson = new Gson();
		response.getWriter().append(gson.toJson(pacientList));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("pacient-name") == null || request.getParameter("pacient-age") == null
				|| request.getParameter("pacient-weight") == null) {
			response.setStatus(400);
			return;
		}
		setAccessControlHeaders(response);
		Pacient u = new Pacient(0, request.getParameter("pacient-name"),
				Integer.parseInt(request.getParameter("pacient-age")),
				Integer.parseInt(request.getParameter("pacient-weight")));

		PacientDao pacientDao = new PacientDao();

		pacientDao.addPacient(u);
		response.setContentType("application/json");
		Gson gson = new Gson();
		response.getWriter().append(gson.toJson(u));
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Pacient u = new Pacient(
				request.getParameter("pacient-id"),
				request.getParameter("pacient-name"),
				Integer.valueOf(request.getParameter("pacient-age")),
				Integer.valueOf(request.getParameter("pacient-weight"))
				);
		
		PacientDao pacientDao = new PacientDao();
		
		pacientDao.updatePacient(u);
		
		response.getWriter().append(u.toString());
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setAccessControlHeaders(response);
		if (request.getParameter("pacient-id") == null)
			response.sendError(407, "Informe o ID do usuário a ser retornado!!!");
		else {
			int pacientId = Integer.valueOf(request.getParameter("pacient-id"));

			PacientDao pacientDao = new PacientDao();

			pacientDao.deletePacient(pacientId);

			response.getWriter().append(request.getParameter("pacient-id") + " User removido");
		}
	}

}
