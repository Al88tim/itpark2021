package main.java.LessonForteen;

    import java.util.*;

    public class PhoneBookRunner {
        public static void main(String[] args) {
            Collection<PhoneBook> phonebook = new ArrayList<>();

            for (int i = 1; i <= 1000; i++) {

                phonebook.add(new PhoneBook(generateNumber(), i, generateFIO()));
            }

            Collection<PhoneBook> phonebook2 = new ArrayList<>();

            for (int i = 1; i <= 1000; i++) {

                phonebook2.add(new PhoneBook(generateNumber(), i, generateFIO()));
            }
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (PhoneBook num : phonebook) {
                String tt = (num.getNumber());
                if (!map.containsKey(tt)) {

                    map.put(tt, 0);

                    for (PhoneBook num2 : phonebook2) {
                        String tt2 = num2.getNumber();
                        if (tt.equals(tt2)) {
                            Integer k = map.get(tt);
                            k = k + 1;
                            map.put(tt, k);
                        }

                    }
                }


            }
            map.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(System.out::println);
        }


        public static String generateFIO() {
            String fioValue = "";

            for (int tt = 1; tt < 4; tt++) {
                for (int j = 1; j < Math.random() * 14 + 5; j++) {
                    fioValue += (char) Math.round(Math.random() * 32 + 1040);
                }
                if (tt < 3) {
                    fioValue += " ";
                }

            }
            return fioValue;
        }

        public static String generateNumber() {
            String numberValue;
            int operator = (int) Math.round(Math.random()) * 2 + 1;
            String operatorValue = "";
            switch (operator) {
                //МТС
                case 1:
                    operatorValue = "+7912";
                    break;
                // Мегафон
                case 2:
                    operatorValue = "+7922";
                    break;
                // Мотив
                case 3:
                    operatorValue = "+7900";
                    break;
            }
            //генерация номера от 1 до 100
            int numberTmp = (int) (Math.round(Math.random() * 100));
            // формирование сотового номера
            numberValue = operatorValue + String.format("%07d", numberTmp);
            return numberValue;
        }
    }

