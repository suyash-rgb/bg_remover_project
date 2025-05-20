package com.example.removebg.response;

import com.example.removebg.dto.UserDTO;
import org.springframework.http.HttpStatus;

public class RemoveBgResponse {
    private boolean success;
    private HttpStatus statusCode;
    private Object data;

    public RemoveBgResponse() {
    }

    public RemoveBgResponse(boolean success, HttpStatus statusCode, Object data) {
        this.success = success;
        this.statusCode = statusCode;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static class Builder{

        private boolean success;
        private HttpStatus statusCode;
        private Object data;

        public Builder success(boolean success){
            this.success = success;
            return this;
        }

        public Builder statusCode(HttpStatus statusCode){
            this.statusCode=statusCode;
            return this;
        }

        public Builder data(Object data){
            this.data = data;
            return this;
        }

        public RemoveBgResponse build(){
            return new RemoveBgResponse(success, statusCode, data);
        }
    }
    public static Builder builder(){

        return new Builder();
    }

}
