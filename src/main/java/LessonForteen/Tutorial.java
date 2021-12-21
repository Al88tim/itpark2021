package main.java.LessonForteen;

public class Tutorial {
    public static void main(String[] args)throws CloneNotSupportedException {
        AddressBook addressBook = new AddressBook();
        addressBook.addRecord("123-11-32", "Дейв Гроул", "ул. Дзержинского, 43");
        addressBook.addRecord("883-47-21", "Курт Кобейн", "пр. Ветеранов , 32");
        addressBook.addRecord("919-41-85", "Крист Новоселич", "пер. Славы 66");
        System.out.println(addressBook.allRecords());
     
        
    }

}
