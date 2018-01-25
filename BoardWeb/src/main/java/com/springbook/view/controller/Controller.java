package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 Controller를 같은 타입으로 관리하기 위한 인터페이스
public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
