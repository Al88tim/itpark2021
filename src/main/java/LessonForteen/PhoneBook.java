package main.java.LessonForteen;

public class PhoneBook {

        private String number;
        private int id;
        private String FIO;


        @Override
        public String toString() {
            return "PhoneBook{" +
                    "number='" + number + '\'' +
                    ", id=" + id +
                    ", FIO='" + FIO + '\'' +

                    '}' + "\n";
        }

        public String getFIO() {
            return FIO;
        }

        public String getNumber() {
            return number;
        }

        public PhoneBook(String number, int id, String FIO) {
            this.number = number;
            this.id = id;
            this.FIO = FIO;

        }


    }

