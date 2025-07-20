package org.mapledpmlab.type.skill.buffskill;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GaugeBuffSkill extends BuffSkill {
    private Double gaugeCharge = 0.0;
    private Long gaugePer = 0L;

    @JsonIgnore
    public String getInfo() {
        String str;
        str = super.getInfo();
        if (getGaugeCharge() != 0) {
            str = str + "\n게이지 : " + getGaugeCharge();
            setColNum(getColNum() + 1);
        }
        if (getGaugePer() != 0) {
            str = str + "\n게이지% : " + getGaugePer();
            setColNum(getColNum() + 1);
        }
        return str;
    }
}
