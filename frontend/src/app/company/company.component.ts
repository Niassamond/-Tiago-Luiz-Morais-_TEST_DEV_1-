import { Component, OnInit } from '@angular/core';
import { CompanyService } from './company.service';
@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.scss']
})
export class CompanyComponent  {


  companies;

  constructor(private companyService: CompanyService) { }

  public findCompaniesData() {
    this.companyService.get().subscribe((data) => {
      this.companies = data;
    });
  }

}
