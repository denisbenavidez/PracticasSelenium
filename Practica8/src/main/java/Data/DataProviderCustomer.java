package Data;

import org.testng.annotations.DataProvider;

public class DataProviderCustomer {

    @DataProvider(name = "dataCustomer")
        public Object[][] getCustomerData(){ //DESDE ESTA FUNCION PODEMOS OBTENER DATOS DE PRUEBA YA SEA DESDE UN JSON O UNA BASE O CUALQUIER OTRO TIPO PARA TENER DIFERENTES DATOS PARA PRUEBAS
            return new Object[][]{{"Ricardo", "Torres", "ricardo1234123@yopmail.com", "Ricardo@123/", "Ricardo@123/"},
                    {"Rosa", "Chavez", "Rosa2222@yopmail.com", "Rosa@123/", "Rosa@123/"}}; //Como tenemos 2 objetos de array el test se ejecutara 2 veces, 1 vez con cada dato si tuvieramos 3 se ejecutaria 3 veces y asi sucesivamente
        }

    @DataProvider(name = "dataCustomerLogin")
    public Object[][] getCustomerDataLogin(){ //DESDE ESTA FUNCION PODEMOS OBTENER DATOS DE PRUEBA YA SEA DESDE UN JSON O UNA BASE O CUALQUIER OTRO TIPO PARA TENER DIFERENTES DATOS PARA PRUEBAS
        return new Object[][]{{"ricardo1234123@yopmail.com", "Ricardo@123/", true},
                {"Rosa@yopmail.com", "Rosa/", false}}; //Como tenemos 2 objetos de array el test se ejecutara 2 veces, 1 vez con cada dato si tuvieramos 3 se ejecutaria 3 veces y asi sucesivamente
    }

}
