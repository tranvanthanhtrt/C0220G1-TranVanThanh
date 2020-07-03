import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SinhVien} from './sinhVien';
import {GiaoVien} from './giaoVien';

@Injectable({
    providedIn: 'root'
})
export class SinhVienService {
    API_URL = 'http://localhost:3000/students';
    GIAO_VIEN_URL = 'http://localhost:3000/giaoVien';

    constructor(private httpClient: HttpClient) {

    }

    findAll(): Observable<SinhVien[]> {
        return this.httpClient.get<SinhVien[]>(this.API_URL);
    }

    findById(id: number): Observable<SinhVien> {
        return this.httpClient.get<SinhVien>(this.API_URL + '/' + id);
    }

    suaSinhVien(sinhVien: SinhVien): Observable<SinhVien> {
        return this.httpClient.patch<SinhVien>(`${this.API_URL}/${sinhVien.id}`, sinhVien);
    }

    xoaSinhVien(id: Number): Observable<any> {
        return this.httpClient.delete(this.API_URL + '/' + id);
    }

    findAllLoaiKhach(): Observable<GiaoVien[]> {
        return this.httpClient.get<GiaoVien[]>(this.GIAO_VIEN_URL);
    }
}
