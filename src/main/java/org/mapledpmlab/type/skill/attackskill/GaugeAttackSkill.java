package org.mapledpmlab.type.skill.attackskill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GaugeAttackSkill extends AttackSkill {
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
