package com.chf.sample.spring.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.chf.sample.domain.Customer;
import com.chf.sample.spring.controller.dao.CustomerRepository;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringComponent
@UIScope
public class CustomerEditor extends VerticalLayout {

	private static final long serialVersionUID = 6976991108117482142L;

	@Autowired
	private CustomerRepository customerRepository;

	private Customer customer;

	private TextField firstName = new TextField("First name");
	private TextField lastName = new TextField("Last name");

	private Button save = new Button("Save", FontAwesome.SAVE);
	private Button cancel = new Button("Cancel");
	private Button delete = new Button("Delete", FontAwesome.TRASH_O);
	private CssLayout actions = new CssLayout(save, cancel, delete);

	public CustomerEditor() {
		addComponents(firstName, lastName, actions);

		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

		save.addClickListener(e -> customerRepository.save(customer));
		delete.addClickListener(e -> customerRepository.delete(customer));
		cancel.addClickListener(e -> editCustomer(customer));
		setVisible(false);
	}

	public final void editCustomer(Customer c) {
		final boolean persisted = c.getId() != null;
		if (persisted) {
			customer = customerRepository.findOne(c.getId());
		} else {
			customer = c;
		}
		cancel.setVisible(persisted);
		BeanFieldGroup.bindFieldsUnbuffered(customer, this);
		setVisible(true);

		save.focus();
		firstName.selectAll();
	}

	public void setChangeHandler(ChangeHandler h) {
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}

	public interface ChangeHandler {
		void onChange();
	}
}
