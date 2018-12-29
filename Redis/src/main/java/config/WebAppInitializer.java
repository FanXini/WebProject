package config;


import javax.servlet.MultipartConfigElement;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * @author 凡鑫
 * @description:配置Dispacher和contextListenLoader
 * 这个文件和Web.xml种的文件只能二选一
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	@Override
	protected void customizeRegistration(javax.servlet.ServletRegistration.Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement("/temp/upload"));
	}

}
