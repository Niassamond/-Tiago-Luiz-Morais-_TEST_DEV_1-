package backend
import grails.gorm.transactions.Transactional
import com.metryx.Stock

import java.math.RoundingMode
import java.time.LocalDateTime


@Transactional
class StockService {

    def serviceMethod() {

    }


    def getStocks(String company, int hours) {
        if(hours == 0){
            return Stock.findAll("from Stock s "
                + "where s.company.name = :name",
                [name:company]
        ).toList();
        }else {
            def timeStart = System.currentTimeMillis();
            def timeNow = LocalDateTime.now();
            def stocks = Stock.findAll("from Stock s "
                + "where s.company.name = :name and s.date >= :limit and s.date <= :timeNow",
                [name:company, limit:LocalDateTime.now().minusHours(hours), timeNow:LocalDateTime.now()]);

            stocks.forEach({
                stock -> println stock.quote();
            })
            def timeFinish = System.currentTimeMillis();
            println("Total time of execution, in millisseconds: " + (timeFinish - timeStart));
            println("Number of quotes retrieved:" + stocks.size());
            println("Time now :" + timeNow);
        }
    }

    def standartDeviation(List stocks) {

        def stockList = stocks.stream().mapToDouble({stock -> stock.getPrice()}).toArray();
        double sum = 0.0, standart_deviation = 0.0;
        int array_length = stockList.length;
        for (double i : stockList){
            sum += i;
        }
        double mean = sum/array_length;
        for(double i : stockList){
            standart_deviation += Math.pow(i - mean, 2);
        }
        return Math.sqrt(standart_deviation/array_length);
    }

}
 