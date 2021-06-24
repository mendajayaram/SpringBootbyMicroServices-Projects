package com.nt.jai.filter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.nt.jai.filtercons.FilterConstants;

public class MyResponseFilter extends ZuulFilter {

	private static final Logger LOG = LoggerFactory.getLogger(MyResponseFilter.class);

	public boolean shouldFilter() {
		return true;
	}

	public Object run() throws ZuulException {
		LOG.info("FROM RESPONSE FILTER");
		RequestContext ctx = RequestContext.getCurrentContext();
		try (final InputStream responseDataStream = ctx.getResponseDataStream()) {
			if (responseDataStream != null) {
				String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));
				if (!responseData.contains("notworking")) {
					responseData = responseData + " , DATA IS MODIFIED!";
					ctx.setResponseBody(responseData);
				}
			}
		} catch (IOException e) {
			LOG.error("Error reading body", e);
		}
		return null;
	}

	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

	public int filterOrder() {
		return 0;
	}

}
