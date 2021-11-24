package com.klutz.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * created on 2021/11/8
 * @author klutz
 */
@Slf4j
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        boolean isFirstRequest = !isAsyncDispatch(request);
        HttpServletRequest requestToUse = request;
        HttpServletResponse responseToUse = response;

        if (isFirstRequest ) {
            if( !(request instanceof ContentCachingRequestWrapper)) {
                requestToUse = new ContentCachingRequestWrapper(request);
            }
            if( !(response instanceof ContentCachingResponseWrapper)) {
                responseToUse = new ContentCachingResponseWrapper(response);
            }
        }

        try {
            filterChain.doFilter(requestToUse, responseToUse);
        }
        finally {
            if (!isAsyncStarted(requestToUse)) {
                doLog(requestToUse, responseToUse);
            }
        }
    }

    protected String getMessagePayload(HttpServletRequest request) {
        ContentCachingRequestWrapper wrapper =
                WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
        if (wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                try {
                    return new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
                }
                catch (UnsupportedEncodingException ex) {
                    return "[unknown]";
                }
            }
        }
        return null;
    }

    protected String getResponseBody(HttpServletResponse response) {
        ContentCachingResponseWrapper wrapper =
                WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        if (wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                try {
                    return new String(buf, 0, buf.length, StandardCharsets.UTF_8);
                } finally {
                    try {
                        wrapper.copyBodyToResponse();
                    } catch (IOException e) {
                        log.error("",e);
                    }
                }
            }
        }
        return null;
    }

    protected void doLog( HttpServletRequest request,HttpServletResponse response ){
        log.debug("request:{} response:{}",
                createRequestMessage(request),createResponseMessage(response));
    }

    protected String createRequestMessage(HttpServletRequest request) {
        StringBuilder msg = new StringBuilder();
        msg.append(request.getMethod()).append(" ");
        msg.append(request.getRequestURI());

        String queryString = request.getQueryString();
        if (queryString != null) {
            msg.append('?').append(queryString);
        }

        HttpHeaders headers = new ServletServerHttpRequest(request).getHeaders();
        //msg.append(", headers=").append(headers);

        String payload = getMessagePayload(request);
        if (payload != null) {
            msg.append(", payload=").append(payload);
        }

        return msg.toString();
    }

    protected String createResponseMessage(HttpServletResponse response) {
        StringBuilder msg = new StringBuilder();
        msg.append("status=").append(response.getStatus()).append(" ");

        String payload = getResponseBody(response);
        if (payload != null) {
            msg.append(", body=").append(payload);
        }

        return msg.toString();
    }
}
