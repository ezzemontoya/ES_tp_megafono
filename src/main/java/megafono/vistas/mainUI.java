package megafono.vistas;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
@Theme("valo")
public class mainUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = mainUI.class)
	public static class Servlet extends VaadinServlet {
	}


	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		getPage().setTitle("Megafono");
		
		
		Navigator navigator;
//		navigator = new Navigator(this, new VentanaPrincipal());
		navigator = new Navigator(this, this);
		// Y creamos y registramos las views (pantallas)
		navigator.addView(VentanaTagsAgregar.NAME, new VentanaTagsAgregar());
		navigator.addView(VentanaTagsBorrar.NAME, new VentanaTagsBorrar());
		navigator.addView(VentanaClienteAlta.NAME, new VentanaClienteAlta());
		

	}
	

}