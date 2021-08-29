package mx.edu.utez.controller;

import mx.edu.utez.model.aparatos.BeanAparatos;
import mx.edu.utez.model.aparatos.DaoAparatos;
import mx.edu.utez.model.direccion.BeanDireccion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ServletAparatos", urlPatterns = {"/readAparatos", "/createAparatos", "/findById", "/updateAparatos", "/deleteAparatos"})
public class ServletAparatos extends HttpServlet {
    private Map map = new HashMap();
    final private Logger CONSOLE = LoggerFactory.getLogger(ServletAparatos.class);

    BeanAparatos beanAparatos = new BeanAparatos();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        BeanAparatos beanAparatos = new BeanAparatos();
        BeanDireccion beanDireccion = new BeanDireccion();
        DaoAparatos daoAparatos = new DaoAparatos();

        switch(action){
            case "create":
                beanDireccion.setId(Integer.parseInt(request.getParameter("id")));

                beanAparatos.setNombre(request.getParameter("nombre"));
                beanAparatos.setDireccion(beanDireccion);
                beanAparatos.setFechaDeRegistro(request.getParameter("fechaDeRegistro"));
                boolean flag = daoAparatos.create(beanAparatos);

                if(flag){
                    map.put("message", "Se ha registrado correctamente.");
                } else {
                    map.put("message", "No se registró correctamente.");
                }
                break;
            case "update":
                beanDireccion.setId(Integer.parseInt(request.getParameter("id")));

                beanAparatos.setNombre(request.getParameter("nombre"));
                beanAparatos.setDireccion(beanDireccion);
                beanAparatos.setFechaDeRegistro(request.getParameter("fechaDeRegistro"));
                boolean flag1 = daoAparatos.create(beanAparatos);

                if(flag1){
                    map.put("message", "Se ha Actualizado correctamente.");
                } else {
                    map.put("message", "No se Actualizo correctamente.");
                }
                break;
            case "delete":
                long id = Long.parseLong(request.getParameter("id"));
                if(new DaoAparatos().delete((int) id)){
                    request.setAttribute("message", "Usuario eliminado correctamente");
                } else {
                    request.setAttribute("message", "Usuario no eliminado");
                }
                doGet(request, response);
                break;
        }
        response.sendRedirect(request.getContextPath()+"/readAparatos");
    }
}
