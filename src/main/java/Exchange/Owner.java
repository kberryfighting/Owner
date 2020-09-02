package Exchange;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Owner_table")
public class Owner {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long ownerId;
    private String status;
    private String exchangeDate;
    private Long exchangeId;

    @PostUpdate
    public void onPostUpdate(){
        ExchangeApproved exchangeApproved = new ExchangeApproved();
        BeanUtils.copyProperties(this, exchangeApproved);
        exchangeApproved.publishAfterCommit();


        ExchangeDeclined exchangeDeclined = new ExchangeDeclined();
        BeanUtils.copyProperties(this, exchangeDeclined);
        exchangeDeclined.publishAfterCommit();


    }


    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(String exchangeDate) {
        this.exchangeDate = exchangeDate;
    }
    public Long getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Long exchangeId) {
        this.exchangeId = exchangeId;
    }




}
