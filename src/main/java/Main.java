package main.java;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String inputvalue = "";
        String confFile = "main/resources/applicationContext.xml";
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);
        SmsGatewayService bdmumCodes = (SmsGatewayService) context.getBean("SmsGatewayService");
        do {
            inputvalue = scanner.next().toString().toLowerCase();
            System.out.println(isBdNumberCode(bdmumCodes.validateBDMobileNumber,inputvalue));

        }while (!inputvalue.equals("0"));

    }

    public static boolean isBdNumberCode(List<String> bdnumbersCode,String tempNum){
        if(bdnumbersCode.size()>0) {
            for (int i = 0; i < bdnumbersCode.size(); i++) {
                if (tempNum.startsWith(bdnumbersCode.get(i).toString())){

                    return true;

                }
            }
        }
        return false;
    }

}
