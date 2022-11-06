package backend

import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject
import com.metryx.Company
import services.*

class CompanyController {

    private StockService stockService;
    private CompanyService companyService;

    CompanyController() {
        this.companyService = new CompanyService();
        this.stockService = new StockService();
    }

    def index() {
        def data = Company.findAll()
            .stream()
            .map({ company ->
                def obj = new JSONObject();
                obj.put("name", company.getName());
                obj.put("segment", company.getSegment());
                obj.put("standartDeviation", stockService.standartDeviation(stockService.getStocks(company.getName(),0)));
                return obj;
            })
            .collect(
                { -> new JSONArray() },
                { arr, obj -> arr.add(obj) },
                { arr1, arr2 -> arr1.addAll(arr2) }
            );
        response.setContentType("application/json");
        render data.toString();
    }
}