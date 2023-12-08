package org.mapledpmlab.type.skill.buffskill.demonavenger;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class DemonFrenzyBuff extends GaugeBuffSkill {
    public DemonFrenzyBuff() {
        this.setName("데몬 프렌지");
        this.addBuffFinalDamage(1.2);
    }

    public void setFinalDamageByHp(Long hp) {
        int tmp = (int) (hp / 10000);
        if (tmp > 20) {
            this.addBuffFinalDamage(1.2);
        } else {
            this.addBuffFinalDamage(1.0 + 0.1 * tmp);
        }
    }
}
