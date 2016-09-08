package com.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToDoListServlet extends HttpServlet {

    public static final String TASK_NAME = "name";
    public static final String TASK_CATEGORY = "category";

    public List<Task> taskList;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("taskList", taskList);

        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session =request.getSession();

        if (request.getParameter("addTask") != null) {
            Task task = new Task();
            task.setName(request.getParameter(TASK_NAME));
            task.setCategory(request.getParameter(TASK_CATEGORY));

            taskList.add(task);

            session.setAttribute("taskList", taskList);

            try {
                getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (request.getParameter("updateTasks") != null) {
            session.setAttribute("taskList", taskList);

            /*for (Task task : taskList) {
                System.out.println(task);
            }*/

            String[] tasks = request.getParameterValues("complete");
            for (String task : tasks) {
                System.out.println(task);
            }

            try {
                getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void init() throws ServletException {
        taskList = new ArrayList<>();
    }

}
