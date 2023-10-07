package org.mapledpmlab.type.skill.buffskill;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GaugeBuffSkill extends BuffSkill {
    private Double gaugeCharge = 0.0;

    public String getInfo() {
        String str;
        str = super.getInfo();
        if (getGaugeCharge() != 0) {
            str = str + "\n게이지 : " + getGaugeCharge();
            setColNum(getColNum() + 1);
        }
        return str;
    }
}
