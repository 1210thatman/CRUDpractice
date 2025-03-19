package org.example.crudpractice.global.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.crudpractice.global.error.exceptions.CrudpracticeException;
import org.example.crudpractice.global.error.exceptions.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class GlobalExcpetionFilter extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException{
        try{
            filterChain.doFilter(request, response);
        }
        catch (CrudpracticeException e){
            ErrorCode errorCode = e.getErrorCode();
            wrtieErrorResponse(response, ErrorResponse.of(errorCode.getMessage(), errorCode.getStatusCode()));
        }
        catch (Exception e) {
            wrtieErrorResponse(response, ErrorResponse.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }

    private void wrtieErrorResponse(HttpServletResponse response, ErrorResponse errorResponse) throws IOException {
        response.setStatus(errorResponse.getStatus());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        objectMapper.writeValue(response.getWriter(), errorResponse);
    }
}
