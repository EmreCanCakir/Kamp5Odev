package core.concretes;

import core.abstracts.LoggerService;

import java.util.Scanner;


public class LoggerManager implements LoggerService {

    @Override
    public void Log(String message) {
    System.out.println("Email adresinize dogrulama postasi gonderilmistir."+message);
    System.out.println("Doğrulamayı onaylamak için 2 kez 1'e basınız. ");
    Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
       while (scanner.nextInt()!=1){
           System.out.println("Dogrulamaniz onaylanmamistir. Tekrar deneyiniz. ");
       }
       System.out.println("E posta dogrulamaniz onaylanmistir.");



    }
}
