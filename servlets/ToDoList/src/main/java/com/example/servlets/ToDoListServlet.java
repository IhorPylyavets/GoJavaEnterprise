package com.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

        HttpSession session = request.getSession();

        if (request.getParameter("addTask") != null) {
            Task task = new Task();
            task.setName(request.getParameter(TASK_NAME));
            task.setCategory(request.getParameter(TASK_CATEGORY));
            task.setId(getCurrentTaskId());
            taskList.add(task);
        }
        else if (request.getParameter("updateTasks") != null) {
            session.setAttribute("taskList", taskList);

            if (request.getParameterValues("complete").length != 0) {
                String[] completed = request.getParameterValues("complete");

                for (Task task : taskList) {
                    if (Arrays.asList(completed).contains(String.valueOf(task.getId()))) {
                        task.setComplete(true);
                    } else if (task.isComplete()&& !Arrays.asList(completed).contains(task.getId())) {
                        task.setComplete(false);
                    }
                }
            }
        }
        else if (request.getParameter("deleteTask") != null) {
            session.setAttribute("taskList", taskList);

            taskList.remove(getTaskById(taskList, Integer.parseInt(request.getParameter("deleteTask"))));
        }

        session.setAttribute("taskList", taskList);

        try {
            getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        taskList = new ArrayList<>();
    }

    private int getCurrentTaskId() {
        if (taskList.size() == 0) {
            return 1;
        } else {
            int currentId = taskList.get(taskList.size()-1).getId();
            return currentId+1;
        }
    }

    private Task getTaskById(List<Task> list, int id) {
        for (Task task : list) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

}
