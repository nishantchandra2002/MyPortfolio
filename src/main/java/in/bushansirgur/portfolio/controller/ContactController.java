package in.bushansirgur.portfolio.controller;

import in.bushansirgur.portfolio.Entity.ContactForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact"; // matches contact.html
    }

    @PostMapping("/contact/submit")
    public String submitContact(@ModelAttribute ContactForm contactForm, Model model) {
        // You can save to DB, log, or send an email here
        System.out.println("Contact received: " + contactForm.getName());

        model.addAttribute("success", true);
        model.addAttribute("contactForm", new ContactForm()); // reset the form
        return "contact";
    }
}
