package backend
import com.metryx.Company
import grails.gorm.transactions.Transactional

@Transactional
class CompanyService {

    def serviceMethod() {

    }

    def findAll() {
        return println(Company.findAll());
    }
}
