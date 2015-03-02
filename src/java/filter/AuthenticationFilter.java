package filter;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;

@WebFilter("/schedule/resources/*")
public class AuthenticationFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = servletRequest.getParameter("jwt");
        JWTVerifier jwtVerifier = new JWTVerifier("Angular rocks!");

        try {
            jwtVerifier.verify(token);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException | JWTVerifyException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void destroy() {

    }
}
