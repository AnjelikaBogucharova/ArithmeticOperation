package com.angelikabog;

import com.angelikabog.logic.Model;
import com.angelikabog.logic.Operation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/go")
public class Servlet extends HttpServlet {
    Model model = Model.getInstance();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Map<String,String> result = new HashMap<String, String>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        StringBuffer sb = new StringBuffer();
        String line;
        try{
            BufferedReader reader = request.getReader();
            while((line = reader.readLine()) != null){
                sb.append(line);
            }
        }catch (Exception e){
            System.out.println("Error");
        }

        JsonObject jObj = new JsonParser().parse(sb.toString()).getAsJsonObject();
        request.setCharacterEncoding("UTF-8");
        int firstNum = jObj.get("a").getAsInt();
        int secondNum = jObj.get("b").getAsInt();
        String math = jObj.get("math").getAsString();

        Operation oper = new Operation(firstNum,secondNum,math);

        result.put("result", model.go(oper));

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(result));
    }


}
