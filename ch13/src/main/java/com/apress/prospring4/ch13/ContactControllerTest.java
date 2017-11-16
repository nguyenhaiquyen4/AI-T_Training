package com.apress.prospring4.ch13;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
public class ContactControllerTest {
    private final List<Contact> contacts = new ArrayList<Contact>();
    @Before
    public void initContacts() {
        Contact contact = new Contact();
        contact.setId(1l);
        contact.setFirstName("Chris");
        contact.setLastName("Schaefer");
        contacts.add(contact);
    }
    @Test
    public void testList() throws Exception {
        ContactService contactService = mock(ContactService.class);
        when(contactService.findAll()).thenReturn(contacts);
        ContactController contactController = new ContactController();
        ReflectionTestUtils.setField(contactController, "contactService", contactService);
        ExtendedModelMap uiModel = new ExtendedModelMap();
        uiModel.addAttribute("contacts", contactController.listData());
        Contacts modelContacts = (Contacts) uiModel.get("contacts");
        assertEquals(1, modelContacts.getContacts().size());
    }
}