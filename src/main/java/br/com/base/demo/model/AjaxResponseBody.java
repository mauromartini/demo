package br.com.base.demo.model;

import java.util.List;

public class AjaxResponseBody {

    String msg;
  List<Customer> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

  public List<Customer> getResult() {
        return result;
    }

  public void setResult(List<Customer> result) {
        this.result = result;
    }

}
