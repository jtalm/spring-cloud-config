package com.microservices.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class post extends ZuulFilter{

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        System.out.println("["+ new Date() +"] "+ctx.get("token"));

        return null;

    }
}
