package org.mapledpmlab.type.etc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuoDealCycle {
    DealCycle dealCycle1;
    DealCycle dealCycle2;

    String name = "";
    String description = "";

    public Long getDPM() {
        return dealCycle1.getDPM() + dealCycle2.getDPM();
    }

    public Long getRestraintRingDeal() {
        return dealCycle1.getRestraintRingDeal() + dealCycle2.getRestraintRingDeal();
    }

    public Long getFortyDeal() {
        return dealCycle1.getFortyDeal() + dealCycle2.getFortyDeal();
    }

    public Long getOriginXRestraintRingDeal() {
        return dealCycle1.getOriginXRestraintRingDeal() + dealCycle2.getOriginXRestraintRingDeal();
    }

    public Object[] getObject() {
        Object[] result = new Object[]{
                this.getName(), String.valueOf(this.getDPM()),
                "=TEXT(" + getDPM() + "/SUM(IF(A2:A100=\"비숍 2인팟(극딜 같이)\", VALUE(B2:B100),0)),\"0.0%\")", String.valueOf(this.getRestraintRingDeal()),
                "=TEXT(" + getRestraintRingDeal() + "/SUM(IF(A2:A100=\"비숍 2인팟(극딜 같이)\", VALUE(D2:D100),0)),\"0.0%\")", String.valueOf(this.getFortyDeal()),
                "=TEXT(" + getFortyDeal() + "/SUM(IF(A2:A100=\"비숍 2인팟(극딜 같이)\", VALUE(F2:F100),0)),\"0.0%\")", String.valueOf(this.getOriginXRestraintRingDeal()),
                "=TEXT(" + getOriginXRestraintRingDeal() + "/SUM(IF(A2:A100=\"비숍 2인팟(극딜 같이)\", VALUE(H2:H100),0)),\"0.0%\")",
                this.getDescription()
        };
        return result;
    }
}
