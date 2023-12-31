package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GatheringCatcher extends AttackSkill {
    public GatheringCatcher() {
        this.setName("게더링 캐쳐");
        this.setDamage(170.0 + 100);
        this.setAttackCount(2L);
        this.setDelayByAttackSpeed(750L);
        this.setCooldown(90.0);             // 원래 5초, 마하의 영역 쿨
        this.setRelatedSkill(new ZoneOfMaha());
    }
}
