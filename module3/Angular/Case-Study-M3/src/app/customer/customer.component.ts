import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Customer} from "../customer";
import {CustomerService} from "../customer.service";
import * as $ from 'jquery';
import {MatTableDataSource} from "@angular/material/table";
import {MatSort} from "@angular/material/sort";
import {MatPaginator} from "@angular/material/paginator";
import {MatDialog} from "@angular/material/dialog";
import {CustomerDetailComponent} from "./customer-detail/customer-detail.component";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit {
  displayedColumns: string[] = ['STT', 'maKhachHang', 'tenKhachHang', 'ngaySinh', 'gioiTinh', 'chinhSua', 'xoa', 'chiTiet'];
  dataSource: MatTableDataSource<Customer>;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  customerList: Customer[];
  message: string;
  customer: Customer;

  constructor(private customerService: CustomerService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              public dialog: MatDialog,
              private _snackBar: MatSnackBar

  ) {
    this.customerService.findAll().subscribe(
      next => {
        this.customerList = next;
        console.log(this.customerList);
        this.dataSource = new MatTableDataSource(this.customerList);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      },
      error => {
        console.log(error);
        this.customerList = [];
      });

  }

  ngOnInit(): void {

    this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
      this.message = param.get('message');

    });

    // $(function () {
    //   $('[data-toggle="tooltip"]').tooltip()
    // });
    // $(document).ready(function () {
    //   $('#dtBasicExample').DataTable();
    //   $('.dataTables_length').addClass('bs-select');
    // });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 2000,
    });
  }
  deleteCustomer(i: number) {
    if (confirm("Bạn muốn xóa khách hàng khỏi danh sách")) {
      this.customerService.deleteCustomer(i).subscribe(
        next => {
          this.openSnackBar('Xóa khách hàng thành công', 'Xóa');

          this.customerList = this.customerList.filter(t => t.id !== i);
          this.dataSource = new MatTableDataSource(this.customerList);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;

        }
      );
    }
  }

  openDialog(id: number) {
    this.customerService.findById(id).subscribe(
      next => {
        this.customer = next;
        const dialogRef = this.dialog.open(CustomerDetailComponent, {
          width: '250px',
          data: this.customer
        });

        dialogRef.afterClosed().subscribe(result => {
          console.log('The dialog was closed');
        });
      },
      error => {
        console.log(error);
        this.customer = null;
      }
    );

  }
}
