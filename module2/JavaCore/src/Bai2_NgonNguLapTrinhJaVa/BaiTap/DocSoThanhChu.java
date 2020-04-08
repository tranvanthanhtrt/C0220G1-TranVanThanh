package Bai2_NgonNguLapTrinhJaVa.BaiTap;

import java.util.Scanner;
public class DocSoThanhChu {
    public static StringBuilder stringBuilder;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số có 3 chữ sô");
        String number = scanner.next();
        stringBuilder = new StringBuilder();
        convertNumberToString(number);
        System.out.println(stringBuilder);
    }
    public static void convertNumberToString(String number) {
        char hangTram = (number + "").charAt(0);
        char hangChuc = (number + "").charAt(1);
        char hangDonVi = (number + "").charAt(2);
        if(hangTram!='0'){
            hangDonVi(hangTram);
        }
        if(hangTram!='0'){
            if (hangDonVi == '0' && hangChuc == '0') {
                stringBuilder.append(" hundred  ");
            } else {
                stringBuilder.append(" hundred and ");
            }
        }
        switch (hangChuc) {
            case '0': {
                if(hangTram=='0'){
                    hangDonVi(hangDonVi);
                    break;
                }
                hangDonVi(hangDonVi);
                break;
            }
            case '1': {
                switch (hangDonVi) {
                    case '0': {
                        stringBuilder.append("ten");
                        break;
                    }
                    case '1': {
                        stringBuilder.append("eleven");
                        break;
                    }
                    case '2': {
                        stringBuilder.append("twelve");
                        break;
                    }
                    case '3': {
                        stringBuilder.append("thirteen");
                        break;
                    }
                    case '4': {
                        stringBuilder.append("fourteen");
                        break;
                    }
                    case '5': {
                        stringBuilder.append("fifteen");
                        break;
                    }
                    case '6': {
                        stringBuilder.append("sixteen");
                        break;
                    }
                    case '7': {
                        stringBuilder.append("seventeen");
                        break;
                    }
                    case '8': {
                        stringBuilder.append("eightteen");
                        break;
                    }
                    case '9': {
                        stringBuilder.append("nineteen");
                        break;
                    }
                }
                break;
            }
            case '2': {
                stringBuilder.append("twenty ");
                hangDonVi(hangDonVi);
                break;
            }
            case '3': {
                stringBuilder.append("thirty ");
                hangDonVi(hangDonVi);
                break;
            }
            case '4': {
                stringBuilder.append("fourty ");
                hangDonVi(hangDonVi);
                break;
            }
            case '5': {
                stringBuilder.append("fifty ");
                hangDonVi(hangDonVi);
                break;
            }
            case '6': {
                stringBuilder.append("sixty ");
                hangDonVi(hangDonVi);
                break;
            }
            case '7': {
                stringBuilder.append("seventy ");
                hangDonVi(hangDonVi);
                break;
            }
            case '8': {
                stringBuilder.append("eighty ");
                hangDonVi(hangDonVi);
                break;
            }
            case '9': {
                stringBuilder.append("ninety ");
                hangDonVi(hangDonVi);
                break;
            }
        }
    }
    public static void hangDonVi(char hangDonVi) {
        switch (hangDonVi) {
            case '0': {
                break;
            }
            case '1': {
                stringBuilder.append("one");
                break;
            }
            case '2': {
                stringBuilder.append("two");
                break;
            }
            case '3': {
                stringBuilder.append("three");
                break;
            }
            case '4': {
                stringBuilder.append("four");
                break;
            }
            case '5': {
                stringBuilder.append("five");
                break;
            }
            case '6': {
                stringBuilder.append("six");
                break;
            }
            case '7': {
                stringBuilder.append("seven");
                break;
            }
            case '8': {
                stringBuilder.append("eight");
                break;
            }
            case '9': {
                stringBuilder.append("nine");
                break;
            }
        }
    }
}