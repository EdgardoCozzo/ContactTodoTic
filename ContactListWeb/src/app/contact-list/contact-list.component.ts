import { Component, OnInit, inject } from '@angular/core';
import { ContactService } from '../service/contact.service';

@Component({
  selector: 'app-contact-list',
  standalone: true,
  imports: [],
  import { ContactService } from './../service/contact.service';
templateUrl: './contact-list.component.html',
  styleUrl: './contact-list.component.css'
})
export default class ContactListComponent implements OnInit {
private contactService = inject(ContactService);

ngOnInit(): void {
    this.contactService.list()
    .subscribe(contact => {
      console.log(contact);
    })
}
}
