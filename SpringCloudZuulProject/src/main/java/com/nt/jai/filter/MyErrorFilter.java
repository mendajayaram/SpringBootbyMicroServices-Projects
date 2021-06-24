package com.nt.jai.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.nt.jai.filtercons.FilterConstants;

@Component
public class MyErrorFilter extends ZuulFilter {
	private static final Logger LOG = LoggerFactory.getLogger(MyErrorFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		try {
			RequestContext ctx = RequestContext.getCurrentContext();
			Object e = ctx.getThrowable();
			if (e != null && e instanceof ZuulException) {
				ZuulException zuulException = (ZuulException) e;
				LOG.error("Zuul failure detected: " + zuulException.getMessage(), zuulException);
				ctx.remove("throwable");
				ctx.setResponseBody("{ \"code\": 500,\"problem\": \"notworking\"}");
				ctx.getResponse().setContentType("application/json");
				ctx.setResponseStatusCode(500);
			}
		} catch (Exception ex) {
			LOG.error("Exception filtering in custom errorfilter", ex);
			ReflectionUtils.rethrowRuntimeException(ex);
		}
		return null;

	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return FilterConstants.ERROR_TYPE;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return -1;
	}

}
