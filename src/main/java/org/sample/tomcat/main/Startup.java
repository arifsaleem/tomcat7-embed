package org.sample.tomcat.main;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;

public class Startup {
	public static void main(String[] args) throws ServletException, LifecycleException {
		String appBase = getAppBase(args);

		Tomcat tomcat = createTomcat();

		addWebApp(tomcat, appBase);

		tomcat.start();
		tomcat.getServer().await();
	}

	private static String getAppBase(String[] args) {
		if (args.length > 0)
			return args[0];
		else
			return null;
	}

	private static Tomcat createTomcat() {
		Tomcat tomcat = new Tomcat();

		tomcat.setBaseDir(".");
		tomcat.getHost().setAppBase(".");
		return tomcat;
	}

	private static void addWebApp(Tomcat tomcat, String appBase) throws ServletException {
		tomcat.addWebapp("/tomcat", appBase);
	}
}
