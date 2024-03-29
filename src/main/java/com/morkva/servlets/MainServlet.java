package com.morkva.servlets;

import com.morkva.entities.Category;
import com.morkva.model.*;
import com.morkva.model.dao.DAOFactory;
import com.morkva.model.dao.PersistException;
import com.morkva.model.dao.jdbc.mysql.MySQLDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * Created by koros on 19.06.2015.
 */
@WebServlet("/s")
public class MainServlet extends HttpServlet {

    DAOFactory<Connection> daoFactory;
    private CategoryRepository categoryRepository;
    private Connection connection;
    private int initcount = 0;
    private int doget = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doget++;
        req.setAttribute("string", "string");
        List<Category> all = categoryRepository.getAll();
        req.setAttribute("cat_rep", categoryRepository.toString());
        req.setAttribute("all_count", all.size());
        req.setAttribute("categories", all);
        req.setAttribute("initcount", initcount);
        req.setAttribute("doget", doget);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        initcount++;
        daoFactory = new MySQLDaoFactory();
        try {
            connection = getConnection();
            categoryRepository = new CategoryRepositoryImpl(daoFactory.getDao(connection, Category.class));
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws PersistException {
        return daoFactory.getContext();
    }
}
