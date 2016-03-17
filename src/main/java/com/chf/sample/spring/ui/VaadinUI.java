package com.chf.sample.spring.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.chf.sample.domain.Customer;
import com.chf.sample.spring.controller.dao.CustomerRepository;
import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "/vaadin")
@Theme("valo")
public class VaadinUI extends UI {

	private static final long serialVersionUID = 7489756944099529543L;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerEditor editor;

	private final Grid grid = new Grid();

	private final TextField filter = new TextField();

	private final Button addNewBtn = new Button("New customer", FontAwesome.PLUS);

	@Override
	protected void init(VaadinRequest request) {
		// build layout
		HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
		actions.setSpacing(true);

		VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		setContent(mainLayout);

		grid.setHeight(300, Unit.PIXELS);
		grid.setColumns("id", "firstName", "lastName");

		grid.addSelectionListener(e -> {
			if (e.getSelected().isEmpty()) {
				editor.setVisible(false);
			} else {
				editor.editCustomer((Customer) grid.getSelectedRow());
			}
		});

		filter.setInputPrompt("Filter by last name");
		filter.addTextChangeListener(e -> listCustomers(e.getText()));

		// Instantiate and edit new Customer the new button is clicked
		addNewBtn.addClickListener(e -> editor.editCustomer(new Customer("", "")));

		// Listen changes made by the editor, refresh data from backend
		editor.setChangeHandler(() -> {
			editor.setVisible(false);
			listCustomers(filter.getValue());
		});

		listCustomers(null);
	}

	private void listCustomers(String text) {
		BeanItemContainer<Customer> container = null;
		if (StringUtils.isEmpty(text)) {
			container = new BeanItemContainer<>(Customer.class, customerRepository.findAll());
		} else {
			container = new BeanItemContainer<>(Customer.class, customerRepository.findByLastNameStartsWithIgnoreCase(text));
		}
		grid.setContainerDataSource(container);
	}
}
