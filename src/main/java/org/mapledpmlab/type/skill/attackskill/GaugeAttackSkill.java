package org.mapledpmlab.type.skill.attackskill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GaugeAttackSkill extends AttackSkill {
    private Double gaugeCharge = 0.0;
    private Long gaugePer = 0L;

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
