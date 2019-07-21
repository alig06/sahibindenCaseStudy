package dataRepository;

public interface dataManage {
    interface identity{
        String REGISTER_NAME = "Ali";
         String REGISTER_SURNAME = "Göktaş";
         String REGISTER_MAIL = "test_sahibinden@gmail.com";
         String REGISTER_PASSWORD = "password123123";
         String REGISTER_MOBILE = "5457859234";

         String CHOSEN_CATEGORY = "200002";
         String CHOSEN_CITY = "34";
         String CHOSEN_TOWN = "444";
         String CHOSEN_QUARTER = "23101";
         String CHOSEN_ADDRESS = "namık kemal mah.";
         String CHOSEN_TAX_OFFICE = "502";

         String IDENTITY_NUMBER = "11231231123";
         String PHONE_NUMBER = "2164325342";
    }
    interface urls{
         String BASE_URL = "https://www.sahibinden.com";
         String REGISTER_PAGE_URL = "https://secure.sahibinden.com/kayit";
    }

}