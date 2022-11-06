package backend

import com.metryx.*
import java.math.RoundingMode
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId;

class BootStrap {

    def init = { servletContext ->

        def ford = new Company("Ford", "vehicles");
        def poucelle = new Company("Poucelle", "handbags");
        def ifood = new Company("Ifood", "food");
        ford.save();
        poucelle.save();
        ifood.save();

        def timeNow = LocalDate.now();
        def oldTime;

        def random = new Random();

        Arrays.asList(ford, poucelle, ifood).forEach({
            company -> oldTime = timeNow.minusDays(30);
            while(oldTime.compareTo(timeNow) <= 0){
                def workHour = LocalTime.of(10,0);
                while(workHour.compareTo(LocalTime.of(18,0)) <= 0){
                    def stockPrice = random.nextDouble();
                    new Stock(
                        BigDecimal.valueOf(stockPrice).setScale(2, RoundingMode.HALF_UP).toDouble(),
                        oldTime.atTime(workHour),
                        company).save();
                    workHour = workHour.plusMinutes(1);
                    }
                    oldTime = oldTime.plusDays(1);
                }
        });

        new StockService().getStocks("Ford", 1);
        println "all stocks size -> " + Stock.findAll().size();
        new CompanyService().findAll();


    }
    def destroy = {
    }
}
