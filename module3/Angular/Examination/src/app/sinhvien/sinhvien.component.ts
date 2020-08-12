import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {SinhVien} from "../sinhVien";
import {SinhVienService} from "../sinhVien.service";
import * as $ from 'jquery';
import {MatTableDataSource} from "@angular/material/table";
import {MatSort} from "@angular/material/sort";
import {MatPaginator} from "@angular/material/paginator";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-customer',
  templateUrl: './sinhvien.component.html',
  styleUrls: ['./sinhvien.component.scss']
})
export class SinhvienComponent implements OnInit {
  displayedColumns: string[] = ['STT', 'maSinhVien', 'tenSinhVien', 'tenDeTai',
    'tenNhom',  'gvHuongDan', 'email', 'sdt', 'chinhSua', 'xoa'];
  dataSource: MatTableDataSource<SinhVien>;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  sinhViens: SinhVien[];
  message: string;

  constructor(private sinhVienService: SinhVienService,
              private router: Router,
              private activatedRoute: ActivatedRoute,
              private _snackBar: MatSnackBar

  ) {
    this.sinhVienService.findAll().subscribe(
      next => {
        this.sinhViens = next;
        // console.log(this.sinhViens);
        this.dataSource = new MatTableDataSource(this.sinhViens);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      },
      error => {
        console.log(error);
        this.sinhViens = [];
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
  xoaSinhVien(i: number) {
    if (confirm("Bạn muốn xóa sinh viên này khỏi danh sách")) {
      this.sinhVienService.xoaSinhVien(i).subscribe(
        next => {
          this.openSnackBar('Xóa sinh viên thành công', 'Xóa');

          this.sinhViens = this.sinhViens.filter(t => t.id !== i);
          this.dataSource = new MatTableDataSource(this.sinhViens);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;

        }
      );
    }
  }


}
