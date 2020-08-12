export class Blog {
    id: number;
    contention: string;
    name: string;
    writeOfDay: string;
    category: any;

    constructor(id: number, contention: string, name: string, writeOfDay: string, category: any) {
        this.id = id;
        this.name = name;
        this.contention = contention;
        this.writeOfDay = writeOfDay;
        this.category = category;
    }
}
