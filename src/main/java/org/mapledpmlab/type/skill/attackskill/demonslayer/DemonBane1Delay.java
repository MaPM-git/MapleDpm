package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DemonBane1Delay extends AttackSkill {
    public DemonBane1Delay() {
        this.setName("데몬베인(키다운)");
        this.setDelay(2640L + 690);     // 막타 선딜레이 690ms
        this.setRelatedSkill(new DemonBane2());
    }
}
