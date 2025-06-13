package org.example.crudpractice.global.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.crudpractice.global.error.entity.ErrorResponseEntity;
import org.example.crudpractice.global.error.exception.CrudpracticeException;
import org.example.crudpractice.global.error.exception.ErrorCode;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class ExceptionFilter extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;//요청을 체계적으로 보내기

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
        try{
            filterChain.doFilter(request, response);
        } catch(CrudpracticeException e){
            sendErrorMessage(response, e.getErrorCode());
        }catch(Exception e){
            logger.error(e);
            sendErrorMessage(response, ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private void sendErrorMessage(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        ErrorResponseEntity errorResponse = ErrorResponseEntity.builder()
                .message(errorCode.getMessage())
                .status(errorCode.getHttpStatus())
                .createLocalDateTime(LocalDateTime.now())
                .build();
        String errorResponseJson = objectMapper.writeValueAsString(errorResponse);

        response.setStatus(errorCode.getHttpStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(errorResponseJson);
    }
}
