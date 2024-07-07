package org.mapledpmlab.old.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BoostEndHuntersTargetingBeforeDelay extends AttackSkill {
    public BoostEndHuntersTargetingBeforeDelay() {
        this.setName("부스트 엔드-헌터즈 타겟팅(키다운)");
        this.setDelay(720L);
        this.setRelatedSkill(new BoostEndHuntersTargetingKeydown());
    }
}

