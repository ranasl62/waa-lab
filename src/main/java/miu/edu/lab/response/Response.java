package miu.edu.lab.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response<T> {
    private boolean success;
//    private int code;
    private String message;
    private T data;
}