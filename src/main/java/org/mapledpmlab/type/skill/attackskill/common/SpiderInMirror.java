package org.mapledpmlab.type.skill.attackskill.common;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiderInMirror extends AttackSkill {
    public SpiderInMirror() {
        this.setName("스파이더 인 미러");
        this.setDamage(990.0);
        this.setAttackCount(15L);
        this.setCooldown(250.0);
        this.setDelayByAttackSpeed(960L);
        this.setRelatedSkill(new SpiderInMirrorDot());
    }
}
