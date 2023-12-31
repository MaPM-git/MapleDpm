package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BoostEndHuntersTargetingFirstDelay extends AttackSkill {
    public BoostEndHuntersTargetingFirstDelay() {
        this.setName("부스트 엔드-헌터즈 타겟팅(키다운 준비 딜레이)");
        this.setDelay(60L);
        this.setRelatedSkill(new BoostEndHuntersTargeting());
    }
}

