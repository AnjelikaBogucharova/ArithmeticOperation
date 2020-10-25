package com.angelikabog.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {
    private static final Model instance = new Model();
    private final Operation model;

    public static Model getInstance(){
        return instance;
    }

    private Model(){
        model = new Operation();
    }

    public String go(Operation oper){
        String resultOper = "";
        if(oper.getOperation().equals("*")){
            resultOper = String.valueOf(oper.getFirstNum() * oper.getSecondNum());
        }else if(oper.getOperation().equals("/")){
            resultOper = String.valueOf(oper.getFirstNum() / oper.getSecondNum());
        }else if(oper.getOperation().equals("+")){
            resultOper = String.valueOf(oper.getFirstNum() + oper.getSecondNum());
        }else if(oper.getOperation().equals("-")){
            resultOper = String.valueOf(oper.getFirstNum() - oper.getSecondNum());
        }else if(oper.getOperation().equals("%")){
            resultOper = String.valueOf(oper.getFirstNum() % oper.getSecondNum());
        }
        return resultOper;
    }
}
